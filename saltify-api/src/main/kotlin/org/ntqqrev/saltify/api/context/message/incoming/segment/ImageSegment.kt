package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.ImageSubType
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class ImageSegment(
    message: IncomingMessage,
    resourceId: String,

    /**
     * How the image appears in the chat window.
     */
    val subType: ImageSubType,

    /**
     * The preview text of the image.
     */
    val summary: String,
) : ResourceLikeSegment(message, resourceId)