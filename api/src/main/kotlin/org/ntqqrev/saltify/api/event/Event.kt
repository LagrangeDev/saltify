package org.ntqqrev.saltify.api.event

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.Entity
import kotlinx.datetime.Instant

abstract class Event(
    override val ctx: Context,

    /**
     * The time when the event was signaled.
     */
    val time: Instant
) : Entity