package org.ntqqrev.saltify.api.context.message.outgoing.feature

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.ForwardMessageBuilder

interface ForwardFeature {
    /**
     * Create a forward segment with multiple messages.
     */
    fun forward(packer: Packer.() -> Unit)

    interface Packer {
        /**
         * Construct a forwarded message with the given uin and name.
         */
        fun fake(uin: Long, name: String, builder: ForwardMessageBuilder.() -> Unit)

        /**
         * Forward an existing message.
         */
        fun existing(incomingMessage: IncomingMessage)
    }
}