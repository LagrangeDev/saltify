package org.ntqqrev.saltify.api.context.event.message

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage

open class MessageReceiveEvent(
    ctx: Context,

    /**
     * The message that was received.
     */
    val message: IncomingMessage
) : AbstractMessageEvent(ctx, message.time, message.messageId)