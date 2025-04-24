package org.ntqqrev.saltify.lagrange.adapter

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.ContextFactory
import org.ntqqrev.saltify.api.context.event.Event

class LagrangeContextFactory : ContextFactory<LagrangeInit> {
    override suspend fun createContext(
        init: LagrangeInit,
        env: Environment,
        channel: MutableSharedFlow<Event>
    ): LagrangeContext {
        TODO("Not yet implemented")
    }
}