package org.ntqqrev.saltify.lagrange.operation

import org.ntqqrev.saltify.lagrange.BotContext

interface NoInputOperation<R> : Operation<Unit, R> {
    override fun build(bot: BotContext, payload: Unit): ByteArray
}