package org.ntqqrev.saltify.lagrange.adapter.message.outgoing

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.outgoing.feature.TextFeature
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement
import org.ntqqrev.saltify.lagrange.packet.message.PbSendMsg
import org.ntqqrev.saltify.lagrange.packet.message.element.TextElement

abstract class LagrangeMessageBuilder(
    override val ctx: LagrangeContext,
    val clientSequence: Int,
    val random: Int,
) : Entity, TextFeature {
    protected val deferredElements = mutableListOf<Deferred<MessageElement>>()

    override fun text(text: String) {
        deferredElements.add(ctx.env.scope.async {
            MessageElement(
                text = TextElement(
                    str = text
                )
            )
        })
    }

    suspend fun build(): PbSendMsg {
        val elements = deferredElements.map { it.await() }
        return buildActual(elements)
    }

    abstract fun buildActual(elements: List<MessageElement>): PbSendMsg
}