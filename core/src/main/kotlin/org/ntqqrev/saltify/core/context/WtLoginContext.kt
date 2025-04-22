package org.ntqqrev.saltify.core.context

import io.ktor.utils.io.core.*
import kotlinx.io.*
import kotlinx.io.Buffer
import org.ntqqrev.saltify.core.BotContext
import org.ntqqrev.saltify.core.util.binary.Prefix
import org.ntqqrev.saltify.core.util.binary.barrier
import org.ntqqrev.saltify.core.util.binary.fromHex
import org.ntqqrev.saltify.core.util.binary.writeBytes
import org.ntqqrev.saltify.core.util.crypto.TEA
import kotlin.random.Random

internal class WtLoginContext(bot: BotContext) : Context(bot) {
    private val ecdhKey =
        "04928D8850673088B343264E0C6BACB8496D697799F37211DEB25BB73906CB089FEA9639B4E0260498B51A992D50813DA8".fromHex()

    fun buildCode2DPacket(tlvPack: ByteArray, command: UShort): ByteArray {
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

    fun parseCode2DPacket(wtlogin: ByteArray): ByteArray {
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

    fun buildWtLogin(payload: ByteArray, command: UShort): ByteArray {
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

    fun parseWtLogin(raw: ByteArray): ByteArray {
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

    fun readTlv(reader: Buffer): Map<UShort, ByteArray> {
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