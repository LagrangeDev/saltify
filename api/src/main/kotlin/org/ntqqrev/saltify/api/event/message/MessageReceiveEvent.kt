package org.ntqqrev.saltify.api.event.message

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.message.incoming.IncomingMessage

open class MessageReceiveEvent(
    ctx: Context,

    /**
     * The message that was received.
     */
    val message: IncomingMessage
) : AbstractMessageEvent(ctx, message.time, message.messageId)