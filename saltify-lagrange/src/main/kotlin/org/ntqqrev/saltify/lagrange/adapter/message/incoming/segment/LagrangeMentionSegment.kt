package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.MentionSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory

class LagrangeMentionSegment(message: IncomingMessage, uin: Long, name: String) :
    MentionSegment(message, uin, name) {
    companion object : LagrangeSegmentFactory<MentionSegment> {
        override fun tryParse(reader: ElementReader): MentionSegment? {
            val element = reader.next()?.text
                ?.takeIf { it.mentionExtra?.type == 2 }
                ?: return reader.pushBackAndReturnNull()

            return LagrangeMentionSegment(
                reader.message,
                element.mentionExtra!!.uin,
                element.str
            )
        }
    }

    override fun toString(): String = name
}