package org.ntqqrev.saltify.api.context.message.incoming

interface ForwardedIncomingMessage : IncomingMessage {
    /**
     * The sender of the original message. Can be fake.
     */
    val senderUin: Long

    /**
     * The sender's nickname in the original message.
     */
    val senderName: String
}