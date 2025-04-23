package org.ntqqrev.saltify.api.message.incoming

import org.ntqqrev.saltify.api.Entity
import org.ntqqrev.saltify.api.message.incoming.segment.Segment
import kotlinx.datetime.Instant

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