package org.ntqqrev.saltify.operation.system

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.packet.login.QrCodeState

object QueryQrCodeState : NoInputOperation<QrCodeState> {
    override val command = "wtlogin.trans_emp"

    override fun build(bot: BotContext, payload: Unit): ByteArray = bot.wtLoginContext.buildTransEmp0x12()

    override fun parse(bot: BotContext, payload: ByteArray): QrCodeState = bot.wtLoginContext.parseTransEmp0x12(payload)
}