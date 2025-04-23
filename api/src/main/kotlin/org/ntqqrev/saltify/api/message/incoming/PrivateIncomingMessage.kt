package org.ntqqrev.saltify.api.message.incoming

import org.ntqqrev.saltify.api.model.User

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