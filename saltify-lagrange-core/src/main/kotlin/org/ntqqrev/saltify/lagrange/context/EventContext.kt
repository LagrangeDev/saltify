package org.ntqqrev.saltify.lagrange.context

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.event.MessagePushEvent
import org.ntqqrev.saltify.lagrange.event.SystemEvent
import org.ntqqrev.saltify.lagrange.event.SystemEventFactory
import org.ntqqrev.saltify.lagrange.packet.SsoResponse

class EventContext(bot: BotContext) : Context(bot) {
    internal val flow = MutableSharedFlow<SystemEvent>()
    internal val factories = listOf<SystemEventFactory<*>>(
        MessagePushEvent.Companion
    ).associateBy { it.command }

    fun process(ssoResponse: SsoResponse) {
        if (ssoResponse.retCode != 0)
            return
        factories[ssoResponse.command]?.also { factory ->
            factory.buildEvent(bot, ssoResponse.response)?.also {
                flow.tryEmit(it)
            }
        }
    }
}