package org.ntqqrev.saltify.operation

import org.ntqqrev.saltify.BotContext

interface Operation<T, R> {
    val command: String
    fun build(bot: BotContext, payload: T): ByteArray
    fun parse(bot: BotContext, payload: ByteArray): R
}

interface NoInputOperation<R> : Operation<Unit, R> {
    override fun build(bot: BotContext, payload: Unit): ByteArray
}

abstract class NoOutputOperation<T> : Operation<T, Unit> {
    override fun parse(bot: BotContext, payload: ByteArray): Unit = Unit
}
