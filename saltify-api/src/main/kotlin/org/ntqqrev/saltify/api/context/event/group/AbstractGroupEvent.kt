package org.ntqqrev.saltify.api.context.event.group

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.api.context.model.Group

abstract class AbstractGroupEvent(
    ctx: Context,
    time: Instant,

    /**
     * The group related to the event.
     */
    val group: Group
) : Event(ctx, time)