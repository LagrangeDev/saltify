package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

class ElementReader(
    val ctx: LagrangeContext,
    val message: LagrangeIncomingMessage,
    val elements: List<MessageElement>,
) {
    private var index = 0

    fun next(): MessageElement? {
        if (index >= elements.size) return null
        return elements[index++]
    }

    fun pushBack() {
        if (index > 0) index--
    }

    fun <T> pushBackAndReturnNull(): T? {
        pushBack()
        return null
    }

    fun skip(count: Int = 1) {
        index += count
    }

    fun hasNext(): Boolean {
        return index < elements.size
    }
}