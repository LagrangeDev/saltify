package org.ntqqrev.saltify.api.context.event.group

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.event.Event
import kotlinx.datetime.Instant

abstract class AbstractGroupEvent(
    ctx: Context,
    time: Instant,

    /**
     * The group related to the event.
     */
    val group: Group
) : Event(ctx, time)