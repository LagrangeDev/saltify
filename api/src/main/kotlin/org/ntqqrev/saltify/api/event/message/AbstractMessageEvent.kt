package org.ntqqrev.saltify.api.event.message

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.event.Event
import java.time.Instant

abstract class AbstractMessageEvent(
    ctx: Context,
    time: Instant,

    /**
     * The message ID related to the event.
     */
    val messageId: String
) : Event(ctx, time)