package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.Segment
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.packet.message.PushMsgBody

abstract class LagrangeIncomingMessage(
    override val ctx: Context,
    val raw: PushMsgBody,
    val messageType: MessageType,
    val peerUin: Long,
    val sequence: Long,
) : IncomingMessage {
    override val messageId: String = "${messageType.type}:$peerUin:$sequence"

    override val time: Instant = Instant.fromEpochSeconds(raw.contentHead.timestamp ?: 0L)

    val segmentMutableList: MutableList<Segment> = mutableListOf()
    override val segments: List<Segment>
        get() = segmentMutableList

    val contentToString by lazy { segments.joinToString("") }
}