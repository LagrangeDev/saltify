package org.ntqqrev.saltify.lagrange.adapter

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.ContextFactory
import org.ntqqrev.saltify.api.context.event.Event
import kotlin.coroutines.CoroutineContext

class LagrangeContextFactory : ContextFactory<LagrangeInit> {
    override suspend fun createContext(
        init: LagrangeInit,
        coroutineContext: CoroutineContext,
        channel: MutableSharedFlow<Event>
    ): Context {
        TODO("Not yet implemented")
    }
}