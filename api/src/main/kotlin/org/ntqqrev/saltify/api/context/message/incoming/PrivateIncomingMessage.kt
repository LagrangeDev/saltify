package org.ntqqrev.saltify.api.context.message.incoming

import org.ntqqrev.saltify.api.context.model.User

interface PrivateIncomingMessage : IncomingMessage {
    /**
     * The peer the bot is interacting with.
     */
    val peer: User

    /**
     * Whether the message was sent by the bot itself.
     */
    val isSelf: Boolean
}