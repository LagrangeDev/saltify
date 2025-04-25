package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class TextSegment(
    message: IncomingMessage,

    /**
     * The text content of the segment.
     */
    val text: String
) : Segment(message)