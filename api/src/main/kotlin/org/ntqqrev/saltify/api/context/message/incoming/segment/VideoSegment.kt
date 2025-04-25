package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class VideoSegment(
    message: IncomingMessage,
    resourceId: String,
) : ResourceLikeSegment(message, resourceId)