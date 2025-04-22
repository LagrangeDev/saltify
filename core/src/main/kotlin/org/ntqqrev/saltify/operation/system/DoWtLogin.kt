package org.ntqqrev.saltify.operation.system

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation

object DoWtLogin : NoInputOperation<Boolean> {
    override val command = "wtlogin.login"

    override fun build(bot: BotContext, payload: Unit): ByteArray = bot.wtLoginContext.buildLogin()

    override fun parse(bot: BotContext, payload: ByteArray): Boolean = bot.wtLoginContext.parseLogin(payload)
}