package org.ntqqrev.saltify.api.context.message.incoming.segment

interface ResourceLikeSegment : Segment {
    /**
     * The permanent ID of the resource. Can be used to download the resource.
     */
    val resourceId: String
}