package org.ntqqrev.saltify.api.context.event.request

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.event.Event
import kotlinx.datetime.Instant

abstract class AbstractRequestEvent(
    ctx: Context,
    time: Instant,

    /**
     * The flag of the request.
     * Can be used to handle the request.
     */
    val flag: String,

    /**
     * The uin of the operator who sent the request.
     */
    val operatorUin: Long,
) : Event(ctx, time)