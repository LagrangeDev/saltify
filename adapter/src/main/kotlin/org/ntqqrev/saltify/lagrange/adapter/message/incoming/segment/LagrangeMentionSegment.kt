package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.MentionSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

class LagrangeMentionSegment(message: IncomingMessage, uin: Long, name: String) :
    MentionSegment(message, uin, name) {
    companion object : LagrangeSegmentFactory<MentionSegment> {
        override fun tryParse(element: MessageElement, message: LagrangeIncomingMessage): MentionSegment? =
            element.text?.let { text ->
                text.mentionExtra
                    ?.takeIf { it.type == 2 }
                    ?.let { LagrangeMentionSegment(message, it.uin, text.str ?: "") }
            }
    }

    override fun toString(): String = name
}