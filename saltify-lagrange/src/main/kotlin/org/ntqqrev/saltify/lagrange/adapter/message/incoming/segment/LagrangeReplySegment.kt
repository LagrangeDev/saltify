package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.ReplySegment
import org.ntqqrev.saltify.lagrange.adapter.message.encodeMessageId
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory

class LagrangeReplySegment(message: LagrangeIncomingMessage, repliedSequence: Long) :
    ReplySegment(message, repliedSequence) {
    companion object : LagrangeSegmentFactory<ReplySegment> {
        override fun tryParse(reader: ElementReader): ReplySegment? {
            val srcMsg = reader.next()?.srcMsg
                ?: return reader.pushBackAndReturnNull()
            val peek = reader.peek()
            reader.skip(
                when {
                    peek?.text != null && peek.text?.mentionExtra != null -> 2 // @mention + text
                    peek?.generalFlags != null ->
                        if (reader.message is PrivateIncomingMessage) 2 // generalFlags + elemFlags2
                        else 4 // generalFlags + elemFlags2 + @mention + text
                    else -> 0
                }
            )

            return LagrangeReplySegment(
                reader.message,
                srcMsg.reserve?.friendSequence
                    ?: srcMsg.origSeqs.getOrNull(0) ?: 0L
            )
        }
    }

    override fun toString(): String = "[回复消息] "
}