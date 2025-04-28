package org.ntqqrev.saltify.lagrange.operation.system

import kotlinx.io.*
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.NoInputOperation
import org.ntqqrev.saltify.lagrange.packet.login.QrCodeState
import org.ntqqrev.saltify.lagrange.util.binary.Prefix
import org.ntqqrev.saltify.lagrange.util.binary.reader
import org.ntqqrev.saltify.lagrange.util.binary.writeBytes

object QueryQrCodeState : NoInputOperation<QrCodeState> {
    override val command = "wtlogin.trans_emp"

    override fun build(bot: BotContext, payload: Unit): ByteArray {
        val packet = Buffer().apply {
            writeUShort(0u)
            writeUInt(bot.appInfo.appId.toUInt())
            writeBytes(bot.keystore.qrSig, Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            writeULong(0u) // uin
            writeByte(0)
            writeBytes(ByteArray(0), Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            writeUShort(0u)  // actually it is the tlv count, but there is no tlv so 0x0 is used
        }
        return bot.wtLoginContext.buildCode2DPacket(packet.readByteArray(), 0x12u)
    }

    override fun parse(bot: BotContext, payload: ByteArray): QrCodeState {
        val wtlogin = bot.wtLoginContext.parseWtLogin(payload)
        val reader = bot.wtLoginContext.parseCode2DPacket(wtlogin).reader()
        val retCode = QrCodeState(reader.readByte())
        if (retCode.value == QrCodeState.Confirmed.value) {
            reader.discard(4)
            bot.keystore.uin = reader.readUInt().toLong()
            reader.discard(4)

            val tlv = bot.wtLoginContext.readTlv(reader)
            bot.keystore.tgtgt = tlv[0x1eu]!!
            bot.keystore.encryptedA1 = tlv[0x18u]!!
            bot.keystore.noPicSig = tlv[0x19u]!!
        }
        return retCode
    }
}