package org.ntqqrev.saltify.lagrange.adapter.event.message

import org.ntqqrev.saltify.api.context.event.message.MessageReceiveEvent
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.event.EventFactory
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeGroupIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangePrivateIncomingMessage
import org.ntqqrev.saltify.lagrange.event.MessagePushEvent

object MessageReceiveEventFactory : EventFactory<MessagePushEvent, MessageReceiveEvent> {
    override suspend fun tryProcess(ctx: LagrangeContext, systemEvent: MessagePushEvent): MessageReceiveEvent? {
        val message = if (systemEvent.push.responseHead.friendExt != null) {
            LagrangePrivateIncomingMessage.create(ctx, systemEvent.push)
        } else {
            LagrangeGroupIncomingMessage.create(ctx, systemEvent.push)
        }
        return message?.let { MessageReceiveEvent(ctx, it) }
    }
}