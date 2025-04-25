package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.TextSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

class LagrangeTextSegment(message: IncomingMessage, text: String) : TextSegment(message, text) {
    companion object : LagrangeSegmentFactory<TextSegment> {
        override fun tryParse(element: MessageElement, message: LagrangeIncomingMessage): TextSegment? =
            element.text
                ?.takeUnless { it.attr6Buf?.isNotEmpty() ?: false }
                ?.let { LagrangeTextSegment(message, it.str ?: "") }
    }

    override fun toString(): String = text
}