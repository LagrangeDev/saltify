package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.event.Event
import java.time.Instant

abstract class AbstractGroupEvent(
    ctx: Context,
    time: Instant,

    /**
     * The group related to the event.
     */
    val group: Group
) : Event(ctx, time)