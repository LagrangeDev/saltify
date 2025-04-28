package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class ForwardSegment(
    message: IncomingMessage,

    /**
     * The ID of the forwarded messages.
     * Can be used to retrieve the original messages.
     */
    val forwardId: String
) : Segment(message)