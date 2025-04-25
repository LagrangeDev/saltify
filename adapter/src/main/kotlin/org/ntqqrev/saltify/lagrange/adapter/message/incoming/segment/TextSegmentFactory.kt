package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.segment.TextSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.SegmentFactory
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

object TextSegmentFactory : SegmentFactory<TextSegment> {
    override fun tryParse(element: MessageElement, message: LagrangeIncomingMessage): TextSegment? {
        if (element.text != null)
            if (element.text!!.attr6Buf?.isEmpty() ?: true) {
                return TextSegment(
                    message = message,
                    text = element.text!!.str ?: ""
                )
            }
        return null
    }
}