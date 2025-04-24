package org.ntqqrev.saltify.api.context

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.event.Event

interface ContextFactory<T> {
    /**
     * Creates a context using the given initialization config.
     * All async operations should be done in the given coroutine context.
     * The context may push events to the given channel.
     *
     * This function should not "start" the context.
     */
    suspend fun createContext(
        init: T,
        env: Environment,
        channel: MutableSharedFlow<Event>
    ): Context
}