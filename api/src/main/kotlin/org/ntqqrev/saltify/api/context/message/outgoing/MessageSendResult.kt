package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity
import kotlinx.datetime.Instant

interface MessageSendResult : Entity {
    /**
     * The ID of the message that was sent.
     */
    val messageId: String

    /**
     * The time when the message was sent.
     */
    val time: Instant
}