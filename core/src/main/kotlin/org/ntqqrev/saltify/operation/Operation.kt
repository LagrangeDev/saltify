package org.ntqqrev.saltify.operation

import org.ntqqrev.saltify.BotContext

interface Operation<T, R> {
    val command: String
    fun build(bot: BotContext, payload: T): ByteArray
    fun parse(bot: BotContext, payload: ByteArray): R
}
