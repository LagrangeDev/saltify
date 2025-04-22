package org.ntqqrev.saltify.operation.system

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.packet.login.TlvQrCodeD1ResponseBody
import org.ntqqrev.saltify.util.binary.pb

class FetchQrCodeResult(
    val qrCodeUrl: String,
    val qrCodePng: ByteArray
)

object FetchQrCode : NoInputOperation<FetchQrCodeResult> {
    override val command: String = "wtlogin.trans_emp"

    override fun build(bot: BotContext, payload: Unit): ByteArray = bot.wtLoginContext.buildTransEmp0x31()

    override fun parse(bot: BotContext, payload: ByteArray): FetchQrCodeResult {
        val response = bot.wtLoginContext.parseTransEmp0x31(payload)
        val respD1Body = response.getValue(0xD1u).pb<TlvQrCodeD1ResponseBody>()
        return FetchQrCodeResult(
            qrCodeUrl = respD1Body.qrCodeUrl,
            qrCodePng = response.getValue(0x17u)
        )
    }
}