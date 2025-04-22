package org.ntqqrev.saltify.operation.system

import io.ktor.utils.io.core.*
import kotlinx.io.*
import kotlinx.io.Buffer
import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.packet.login.TlvQrCode
import org.ntqqrev.saltify.packet.login.TlvQrCodeD1ResponseBody
import org.ntqqrev.saltify.util.binary.Prefix
import org.ntqqrev.saltify.util.binary.pb
import org.ntqqrev.saltify.util.binary.readPrefixedBytes
import org.ntqqrev.saltify.util.binary.writeBytes

class FetchQrCodeResult(
    val qrCodeUrl: String,
    val qrCodePng: ByteArray
)

object FetchQrCode : NoInputOperation<FetchQrCodeResult> {
    override val command: String = "wtlogin.trans_emp"

    override fun build(bot: BotContext, payload: Unit): ByteArray {
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
        return bot.wtLoginContext.buildCode2DPacket(packet.readByteArray(), 0x31u)
    }

    override fun parse(bot: BotContext, payload: ByteArray): FetchQrCodeResult {
        val wtlogin = bot.wtLoginContext.parseWtLogin(payload)
        val code2d = bot.wtLoginContext.parseCode2DPacket(wtlogin)
        val reader = Buffer().apply {
            write(code2d, endIndex = 0 + code2d.size)
        }
        reader.discard(1)
        val sig = reader.readPrefixedBytes(Prefix.UINT_16 or Prefix.LENGTH_ONLY)
        val tlv = bot.wtLoginContext.readTlv(reader)
        bot.keystore.qrSig = sig
        val response = tlv
        val respD1Body = response.getValue(0xD1u).pb<TlvQrCodeD1ResponseBody>()
        return FetchQrCodeResult(
            qrCodeUrl = respD1Body.qrCodeUrl,
            qrCodePng = response.getValue(0x17u)
        )
    }
}