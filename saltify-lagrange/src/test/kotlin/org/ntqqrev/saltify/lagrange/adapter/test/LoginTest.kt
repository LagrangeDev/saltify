package org.ntqqrev.saltify.lagrange.adapter.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContextFactory
import org.ntqqrev.saltify.lagrange.adapter.LagrangeInit

suspend fun main() {
    testEnv.scope.run {
        val ctx = LagrangeContextFactory.createContext(
            init = LagrangeInit(),
            env = testEnv,
            channel = MutableSharedFlow()
        )
        ctx.start()

        ctx.getAllFriends().forEach { println(it) }
        ctx.getAllGroups().forEach { println(it) }

        delay(Long.MAX_VALUE)
    }
}