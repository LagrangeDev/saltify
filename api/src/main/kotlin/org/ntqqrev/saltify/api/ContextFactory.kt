package org.ntqqrev.saltify.api

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.event.Event
import kotlin.coroutines.CoroutineContext

interface ContextFactory<T> {
    /**
     * Creates a context using the given initialization config.
     * All async operations should be done in the given coroutine context.
     * The context may push events to the given channel.
     *
     * This function is not `suspend`, and should not "start" the context.
     */
    fun createContext(
        init: T,
        coroutineContext: CoroutineContext,
        channel: MutableSharedFlow<Event>
    ): Context
}