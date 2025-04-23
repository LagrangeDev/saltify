package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.message.incoming.segment.Segment

interface ResourceLikeSegment : Segment {
    /**
     * The permanent ID of the resource. Can be used to download the resource.
     */
    val resourceId: String
}