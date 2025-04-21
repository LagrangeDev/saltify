package org.ntqqrev.saltify.context

import io.ktor.utils.io.core.discard
import io.ktor.utils.io.core.remaining
import io.ktor.utils.io.core.writeFully
import kotlinx.io.*
import kotlinx.io.Buffer
import kotlinx.io.readByteArray
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.packet.login.QrCodeState
import org.ntqqrev.saltify.packet.login.Tlv
import org.ntqqrev.saltify.packet.login.Tlv543Body
import org.ntqqrev.saltify.packet.login.TlvQrCode
import org.ntqqrev.saltify.util.binary.Prefix
import org.ntqqrev.saltify.util.binary.barrier
import org.ntqqrev.saltify.util.binary.fromHex
import org.ntqqrev.saltify.util.binary.readPrefixedBytes
import org.ntqqrev.saltify.util.binary.readPrefixedString
import org.ntqqrev.saltify.util.binary.writeBytes
import org.ntqqrev.saltify.util.crypto.TEA
import kotlin.random.Random

internal class WtLoginContext(bot: BotContext) : Context(bot) {
    private val ecdhKey =
        "04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8".fromHex()

    fun buildTransEmp0x31(): ByteArray {
        val tlvPack = TlvQrCode(bot).apply {
            tlv16()
            tlv1b()
            tlv1d()
            tlv33()
            tlv35()
            tlv66()
            tlvD1()
        }

        val packet = Buffer().apply {
            writeUShort(0u)
            writeUInt(bot.appInfo.appId.toUInt())
            writeULong(0u) // uin
            writeBytes(ByteArray(0))
            writeByte(0)
            writeBytes(ByteArray(0), Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            writeBytes(tlvPack.build())
        }

        return buildCode2DPacket(packet.readByteArray(), 0x31u)
    }

    fun buildTransEmp0x12(): ByteArray {
        val packet = Buffer().apply {
            writeUShort(0u)
            writeUInt(bot.appInfo.appId.toUInt())
            writeBytes(bot.keystore.qrSig, Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            writeULong(0u) // uin
            writeByte(0)
            writeBytes(ByteArray(0), Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            writeUShort(0u)  // actually it is the tlv count, but there is no tlv so 0x0 is used
        }

        return buildCode2DPacket(packet.readByteArray(), 0x12u)
    }

    fun buildLogin(): ByteArray {
        val tlvPack = Tlv(bot).apply {
            tlv106A2()
            tlv144()
            tlv116()
            tlv142()
            tlv145()
            tlv18()
            tlv141()
            tlv177()
            tlv191()
            tlv100()
            tlv107()
            tlv318()
            tlv16a()
            tlv166()
            tlv521()
        }

        val packet = Buffer().apply {
            writeUShort(9u) // internal command
            writeFully(tlvPack.build())
        }

        return buildWtLogin(packet.readByteArray(), 2064u)
    }

    fun parseTransEmp0x31(raw: ByteArray): Map<UShort, ByteArray> {
        val wtlogin = parseWtLogin(raw)
        val code2d = parseCode2DPacket(wtlogin)

        val reader = Buffer().apply {
            write(code2d, endIndex = 0 + code2d.size)
        }
        reader.discard(1)

        val sig = reader.readPrefixedBytes(Prefix.UINT_16 or Prefix.LENGTH_ONLY)
        val tlv = readTlv(reader)
        bot.keystore.qrSig = sig

        return tlv
    }

    fun parseTransEmp0x12(raw: ByteArray): QrCodeState {
        val wtlogin = parseWtLogin(raw)
        val code2d = parseCode2DPacket(wtlogin)

        val reader = Buffer().apply {
            write(code2d, endIndex = 0 + code2d.size)
        }
        val retCode = QrCodeState(reader.readByte())
        if (retCode.value == QrCodeState.Confirmed.value) {
            reader.discard(4)
            bot.keystore.uin = reader.readUInt().toLong()
            reader.discard(4)

            val tlv = readTlv(reader)
            bot.keystore.tgtgt = tlv[0x1eu]!!
            bot.keystore.encryptedA1 = tlv[0x18u]!!
            bot.keystore.noPicSig = tlv[0x19u]!!
        }

        return retCode
    }

    fun parseLogin(raw: ByteArray): Boolean {
        val wtlogin = parseWtLogin(raw)
        val reader = Buffer().apply {
            write(wtlogin, endIndex = 0 + wtlogin.size)
        }

        val command = reader.readUShort()
        val state = reader.readUByte()
        val tlv119Reader = readTlv(reader)

        if (state.toInt() == 0) {
            val tlv119 = tlv119Reader[0x119u]!!
            val array = TEA.decrypt(tlv119, bot.keystore.tgtgt)
            val tlvPack = readTlv(
     Buffer().apply {
         write(array, endIndex = 0 + array.size)
     }
            )
            bot.keystore.apply {
                d2Key = tlvPack[0x305u]!!
                uid = ProtoBuf.decodeFromByteArray<Tlv543Body>(tlvPack[0x543u]!!)
                    .layer1.layer2.uid
                a2 = tlvPack[0x10Au]!!
                d2 = tlvPack[0x143u]!!
                encryptedA1 = tlvPack[0x106u]!!
            }
            return true
        } else {
            val array = tlv119Reader[0x146u]!!
            val tlv146 = Buffer().apply {
                write(array, endIndex = 0 + array.size)
            }
            val state = tlv146.readUInt()
            val tag = tlv146.readPrefixedString(Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            val message = tlv146.readPrefixedString(Prefix.UINT_16 or Prefix.LENGTH_ONLY)

            println("Login failed: $state, $tag, $message")
        }

        return false
    }

    private fun buildCode2DPacket(tlvPack: ByteArray, command: UShort): ByteArray {
        val newPacket = Buffer().apply {
            writeByte(0x2) // packet Start
            writeUShort((43 + tlvPack.size + 1).toUShort()) // _head_len = 43 + data.size +1
            writeUShort(command)
            writeFully(ByteArray(21))
            writeByte(0x3)
            writeShort(0x0) // close
            writeShort(0x32) // Version Code: 50
            writeUInt(0u) // trans_emp sequence
            writeULong(0.toULong()) // dummy uin
            writeFully(tlvPack)
            writeByte(0x3)
        }

        val requestBody = Buffer().apply {
            writeUInt((System.currentTimeMillis() / 1000).toUInt())
            writeFully(newPacket.readByteArray())
        }

        val packet = Buffer().apply {
            writeByte(0x0) // encryptMethod == EncryptMethod.EM_ST || encryptMethod == EncryptMethod.EM_ECDH_ST
            writeUShort(requestBody.size.toUShort())
            writeInt(bot.appInfo.appId) // TODO: AppInfo.AppId
            writeInt(0x72) // Role
            writeBytes(ByteArray(0), Prefix.UINT_16 or Prefix.LENGTH_ONLY) // uSt
            writeBytes(ByteArray(0), Prefix.UINT_8 or Prefix.LENGTH_ONLY) // rollback
            writeFully(requestBody.readByteArray())
        }

        return buildWtLogin(packet.readByteArray(), 2066u)
    }

    private fun parseCode2DPacket(wtlogin: ByteArray): ByteArray {
        val reader = Buffer().apply {
            write(wtlogin, endIndex = 0 + wtlogin.size)
        }

        val packetLength = reader.readUInt()
        reader.discard(4)
        val command = reader.readUShort()
        reader.discard(40)
        val appId = reader.readUInt()

        return reader.readByteArray(reader.remaining.toInt())
    }

    private fun buildWtLogin(payload: ByteArray, command: UShort): ByteArray {
        val encrypted = TEA.encrypt(payload, bot.ecdh192.keyExchange(ecdhKey, true))
        val packet = Buffer()
        packet.writeByte(2)
        packet.barrier(Prefix.UINT_16 or Prefix.INCLUDE_PREFIX, 1) {
            writeUShort(8001u)
            writeUShort(command)
            writeUShort(0u) // TODO: Sequence
            writeUInt(bot.keystore.uin.toUInt()) // TODO: Uin
            writeByte(3) // extVer
            writeByte(135.toByte()) // cmdVer
            writeUInt(0u) // actually unknown const 0
            writeByte(19) // pubId
            writeUShort(0u) // insId
            writeUShort(bot.appInfo.appClientVersion.toUShort())
            writeUInt(0u) // retryTime
            writeFully(buildEncryptHead())
            writeFully(encrypted)
            writeByte(3)
        } // addition of 1, aiming to include packet start

        return packet.readByteArray()
    }

    private fun parseWtLogin(raw: ByteArray): ByteArray {
        val reader = Buffer().apply {
            write(raw, endIndex = 0 + raw.size)
        }
        val header = reader.readByte()
        if (header != 0x02.toByte()) throw Exception("Invalid Header")

        val internalLength = reader.readUShort()
        val ver = reader.readUShort()
        val cmd = reader.readUShort()
        val sequence = reader.readUShort()
        val uin = reader.readUInt()
        val flag = reader.readByte()
        val retryTime = reader.readUShort()

        val encrypted = reader.readByteArray(reader.remaining.toInt() - 1)
        val decrypted = TEA.decrypt(
            encrypted,
            bot.ecdh192.keyExchange(ecdhKey, true)
        )
        if (reader.readByte() != 0x03.toByte()) throw Exception("Packet end not found")

        return decrypted
    }

    private fun buildEncryptHead(): ByteArray = Buffer().apply {
        writeByte(1)
        writeByte(1)
        writeBytes(Random.nextBytes(16))
        writeUShort(0x102u) // unknown const
        writeBytes(bot.ecdh192.getPublicKey(true), Prefix.UINT_16 or Prefix.LENGTH_ONLY)
    }.readByteArray()

    private fun readTlv(reader: Buffer): Map<UShort, ByteArray> {
        val tlvCount = reader.readUShort()
        val result = mutableMapOf<UShort, ByteArray>()
        for (i in 0 until tlvCount.toInt()) {
            val tag = reader.readUShort()
            val length = reader.readUShort()
            val value = reader.readByteArray(length.toInt())

            result[tag] = value
        }

        return result
    }
}