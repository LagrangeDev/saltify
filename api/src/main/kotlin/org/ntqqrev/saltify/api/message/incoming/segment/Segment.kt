package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.message.incoming.IncomingMessage

/**
 * Represents part of the content of a message.
 */
interface Segment {
    /**
     * The message that this segment belongs to.
     */
    val message: IncomingMessage
}