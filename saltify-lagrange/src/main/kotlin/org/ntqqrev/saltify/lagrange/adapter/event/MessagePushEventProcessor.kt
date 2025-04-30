package org.ntqqrev.saltify.lagrange.adapter.event

import io.github.oshai.kotlinlogging.KotlinLogging
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.event.message.MessageReceiveEventFactory
import org.ntqqrev.saltify.lagrange.event.MessagePushEvent
import org.ntqqrev.saltify.lagrange.packet.message.PackageType

private val logger = KotlinLogging.logger {  }

class MessagePushEventProcessor(val ctx: LagrangeContext) {
    suspend fun process(event: MessagePushEvent) {
        val factory: EventFactory<MessagePushEvent, *>? = when (event.type) {
            PackageType.PRIVATE_MESSAGE.value, PackageType.GROUP_MESSAGE.value ->
                MessageReceiveEventFactory
            else -> null
        }
        if (factory != null) {
            factory.tryProcess(ctx, event)?.also { ctx.channel.emit(it) }
        } else {
            logger.warn { "Unknown package type ${event.type}" }
        }
    }
}