package org.ntqqrev.saltify.api.context.event

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.Entity
import kotlinx.datetime.Instant

abstract class Event(
    override val ctx: Context,

    /**
     * The time when the event was signaled.
     */
    val time: Instant
) : Entity