package org.ntqqrev.saltify.lagrange.adapter.test

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContextFactory
import org.ntqqrev.saltify.lagrange.adapter.LagrangeInit

suspend fun main() {
    val ctx = LagrangeContextFactory.createContext(
        init = LagrangeInit(),
        env = testEnv,
        channel = MutableSharedFlow()
    )
    ctx.start()
}