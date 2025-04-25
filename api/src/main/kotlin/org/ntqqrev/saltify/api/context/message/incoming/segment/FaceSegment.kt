package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class FaceSegment(
    message: IncomingMessage,

    /**
     * The ID of the face.
     */
    val id: String
) : Segment(message)