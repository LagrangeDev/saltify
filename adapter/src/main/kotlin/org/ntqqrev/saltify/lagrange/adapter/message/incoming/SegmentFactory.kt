package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

interface SegmentFactory<T : Segment> {
    fun tryParse(element: MessageElement, message: LagrangeIncomingMessage): T?
}