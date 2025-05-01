package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment

interface LagrangeSegmentFactory<T : Segment> {
    fun tryParse(reader: ElementReader): T?
}