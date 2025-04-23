package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.message.incoming.segment.Segment

interface FaceSegment : Segment {
    /**
     * The ID of the face.
     */
    val id: String
}