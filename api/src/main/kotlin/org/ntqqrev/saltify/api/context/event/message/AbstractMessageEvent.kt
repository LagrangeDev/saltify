package org.ntqqrev.saltify.api.context.event.message

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.event.Event
import kotlinx.datetime.Instant

abstract class AbstractMessageEvent(
    ctx: Context,
    time: Instant,

    /**
     * The message ID related to the event.
     */
    val messageId: String
) : Event(ctx, time)