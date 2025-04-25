package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.TextSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

class LagrangeTextSegment(message: IncomingMessage, text: String) : TextSegment(message, text) {
    companion object : LagrangeSegmentFactory<TextSegment> {
        override fun tryParse(element: MessageElement, message: LagrangeIncomingMessage): TextSegment? {
            if (element.text != null)
                if (element.text!!.attr6Buf?.isEmpty() ?: true) {
                    return LagrangeTextSegment(
                        message = message,
                        text = element.text!!.str ?: ""
                    )
                }
            return null
        }
    }

    override fun toString(): String {
        return text
    }
}