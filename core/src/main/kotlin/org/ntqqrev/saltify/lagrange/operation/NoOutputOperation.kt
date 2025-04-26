package org.ntqqrev.saltify.lagrange.operation

import org.ntqqrev.saltify.lagrange.BotContext

abstract class NoOutputOperation<T> : Operation<T, Unit> {
    override fun parse(bot: BotContext, payload: ByteArray): Unit = Unit
}