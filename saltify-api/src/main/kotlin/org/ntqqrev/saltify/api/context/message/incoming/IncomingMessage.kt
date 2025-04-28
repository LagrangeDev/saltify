package org.ntqqrev.saltify.api.context.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment

interface IncomingMessage : Entity {
    /**
     * The ID of the message.
     */
    val messageId: String

    /**
     * The time when the message was sent.
     */
    val time: Instant

    /**
     * The content of the message.
     */
    val segments: List<Segment>
}