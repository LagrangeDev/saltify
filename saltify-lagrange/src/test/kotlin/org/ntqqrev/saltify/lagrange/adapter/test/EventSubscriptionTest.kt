package org.ntqqrev.saltify.lagrange.adapter.test

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch
import org.ntqqrev.saltify.api.context.event.message.MessageReceiveEvent
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

        launch {
            ctx.channel.filterIsInstance<MessageReceiveEvent>()
                .collect {
                    println("Received message ${it.messageId}")
                }
        }

        delay(Long.MAX_VALUE)
    }
}