package org.ntqqrev.saltify.api.context.message.incoming.segment

interface TextSegment : Segment {
    /**
     * The text content of the segment.
     */
    val text: String
}