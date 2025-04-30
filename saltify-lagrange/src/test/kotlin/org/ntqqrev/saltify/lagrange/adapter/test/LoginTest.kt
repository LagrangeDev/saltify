package org.ntqqrev.saltify.lagrange.adapter.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContextFactory
import org.ntqqrev.saltify.lagrange.adapter.LagrangeInit
import org.ntqqrev.saltify.lagrange.event.MessagePushEvent

suspend fun main(): Unit {
    val scope = CoroutineScope(testEnv.parentCoroutineContext)
    scope.run {
        val ctx = LagrangeContextFactory.createContext(
            init = LagrangeInit(),
            env = testEnv,
            channel = MutableSharedFlow()
        )
        ctx.start()

        ctx.getAllFriends().forEach { println(it) }
        ctx.getAllGroups().forEach { println(it) }

        ctx.lagrange.eventFlow
            .filterIsInstance<MessagePushEvent>()
            .collect {
                println(it.push.responseHead.groupExt?.groupName)
                println(it.push.contentHead.sequence)
            }

        delay(Long.MAX_VALUE)
    }
}