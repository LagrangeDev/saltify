package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.TextSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory

class LagrangeTextSegment(message: IncomingMessage, text: String) : TextSegment(message, text) {
    companion object : LagrangeSegmentFactory<TextSegment> {
        override fun tryParse(reader: ElementReader): TextSegment? {
            val textElement = reader.next()?.text
                ?.takeUnless { it.attr6Buf?.isNotEmpty() ?: false }
                ?: return reader.pushBackAndReturnNull()

            return LagrangeTextSegment(reader.message, textElement.str ?: "")
        }
    }

    override fun toString(): String = text
}