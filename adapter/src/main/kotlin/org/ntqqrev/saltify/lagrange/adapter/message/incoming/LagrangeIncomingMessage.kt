package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType

abstract class LagrangeIncomingMessage(
    override val time: Instant,
    override val ctx: Context,
    val messageType: MessageType,
    val peerUin: Long,
    val sequence: Long,
) : IncomingMessage {
    override val messageId: String = "${messageType.type}:$peerUin:$sequence"

    val segmentMutableList: MutableList<Segment> = mutableListOf()

    override val segments: List<Segment>
        get() = segmentMutableList
}