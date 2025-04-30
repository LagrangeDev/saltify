package org.ntqqrev.saltify.lagrange.adapter.event

import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.event.SystemEvent

interface EventFactory<S : SystemEvent, E : Event> {
    suspend fun tryProcess(ctx: LagrangeContext, systemEvent: S): E?
}