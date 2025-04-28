package org.ntqqrev.saltify.lagrange.operation

import org.ntqqrev.saltify.lagrange.BotContext

abstract class NoOutputOidbOperation<T>(cmd: Int, subCmd: Int, reserve: Boolean = false) :
    OidbOperation<T, Unit>(cmd, subCmd, reserve) {
    override fun parseOidb(bot: BotContext, payload: ByteArray) = Unit
}