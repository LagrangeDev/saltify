package org.ntqqrev.saltify.packet.login

import io.ktor.utils.io.core.*
import kotlinx.io.*
import kotlinx.io.Buffer
import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.util.binary.*

internal class TlvQrCode(val bot: BotContext) {

    private val builder = Buffer()

    private var tlvCount: UShort = 0u

    fun tlv16() = defineTlv(0x16u) {
        writeUInt(0u)
        writeInt(bot.appInfo.appId)
        writeInt(bot.appInfo.subAppId)
        writeFully(bot.keystore.guid)
        writeString(bot.appInfo.packageName, Prefix.UINT_16 or Prefix.LENGTH_ONLY)
        writeString(bot.appInfo.ptVersion, Prefix.UINT_16 or Prefix.LENGTH_ONLY)
        writeString(bot.appInfo.packageName, Prefix.UINT_16 or Prefix.LENGTH_ONLY)
    }

    fun tlv1b() = defineTlv(0x1bu) {
        writeUInt(0u) // micro
        writeUInt(0u) // version
        writeUInt(3u) // size
        writeUInt(4u) // margin
        writeUInt(72u) // dpi
        writeUInt(2u) // eclevel
        writeUInt(2u) // hint
        writeUShort(0u) // unknown
    }

    fun tlv1d() = defineTlv(0x1du) {
        writeUByte(1u)
        writeInt(bot.appInfo.mainSigMap) // misc bitmap
        writeUInt(0u)
        writeUByte(0u)
    }

    fun tlv33() = defineTlv(0x33u) {
        writeFully(bot.keystore.guid)
    }

    fun tlv35() = defineTlv(0x35u) {
        writeInt(bot.appInfo.ssoVersion)
    }

    fun tlv66() = defineTlv(0x66u) {
        writeInt(bot.appInfo.ssoVersion)
    }

    fun tlvD1() = defineTlv(0xd1u) {
        writeFully(
            TlvQrCodeD1Body(
                system = TlvQrCodeD1Body.System(
                    os = bot.appInfo.os,
                    deviceName = bot.keystore.deviceName,
                ),
                typeBuf = "3001".fromHex()
            ).pb()
        )
    }

    fun build(): ByteArray = Buffer().apply {
        writeUShort(tlvCount)
        writeFully(builder.readByteArray())
    }.readByteArray()

    private fun defineTlv(tag: UShort, tlv: Sink.() -> Unit) {
        tlvCount++

        builder.writeUShort(tag)
        builder.barrier(Prefix.UINT_16 or Prefix.LENGTH_ONLY) {
            tlv()
        }
    }
}
