package org.ntqqrev.saltify.lagrange.operation

import org.ntqqrev.saltify.lagrange.BotContext

interface Operation<T, R> {
    val command: String
    fun build(bot: BotContext, payload: T): ByteArray
    fun parse(bot: BotContext, payload: ByteArray): R
}