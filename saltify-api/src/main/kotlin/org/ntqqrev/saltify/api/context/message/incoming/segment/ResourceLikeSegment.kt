package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

abstract class ResourceLikeSegment(
    message: IncomingMessage,

    /**
     * The permanent ID of the resource. Can be used to download the resource.
     */
    val resourceId: String
) : Segment(message)