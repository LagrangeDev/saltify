package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.message.incoming.segment.Segment

interface TextSegment : Segment {
    /**
     * The text content of the segment.
     */
    val text: String
}