package org.ntqqrev.saltify.api.action

interface ContextAction {
    /**
     * The starting logic of the context.
     */
    suspend fun start()

    /**
     * The stopping logic of the context.
     */
    suspend fun stop()
}