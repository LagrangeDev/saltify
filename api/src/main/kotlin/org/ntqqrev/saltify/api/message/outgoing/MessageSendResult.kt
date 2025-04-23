package org.ntqqrev.saltify.api.message.outgoing

import org.ntqqrev.saltify.api.Entity
import java.time.Instant

interface MessageSendResult : Entity {
    /**
     * The ID of the message that was sent.
     */
    val messageId: String

    /**
     * The time when the message was sent.
     */
    val instant: Instant
}