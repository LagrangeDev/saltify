package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class RecordSegment(
    message: IncomingMessage,
    resourceId: String,

    /**
     * The duration of the audio in seconds.
     */
    val duration: String
) : ResourceLikeSegment(message, resourceId)