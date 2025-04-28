package org.ntqqrev.saltify.lagrange.event

import org.ntqqrev.saltify.lagrange.BotContext

interface SystemEventFactory<T : SystemEvent> {
    val command: String

    fun buildEvent(bot: BotContext, payload: ByteArray): T?
}