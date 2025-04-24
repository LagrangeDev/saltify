package org.ntqqrev.saltify.api.context.message.incoming.segment

interface ForwardSegment : Segment {
    /**
     * The ID of the forwarded messages.
     * Can be used to retrieve the original messages.
     */
    val forwardId: String
}