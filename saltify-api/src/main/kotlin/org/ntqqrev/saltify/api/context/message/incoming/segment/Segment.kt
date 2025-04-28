package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

/**
 * Represents part of the content of a message.
 */
abstract class Segment(
    /**
     * The message that this segment belongs to.
     */
    val message: IncomingMessage
)