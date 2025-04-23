package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.message.incoming.segment.Segment

interface ForwardSegment : Segment {
    /**
     * The ID of the forwarded messages.
     * Can be used to retrieve the original messages.
     */
    val forwardId: String
}