package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import io.github.oshai.kotlinlogging.KotlinLogging
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment.*
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeFriend
import org.ntqqrev.saltify.lagrange.packet.message.PushMsgBody
import org.ntqqrev.saltify.lagrange.util.binary.pb

private val logger = KotlinLogging.logger { }

class LagrangePrivateIncomingMessage(
    ctx: LagrangeContext,
    raw: PushMsgBody,
    override val peer: LagrangeFriend,
    override val isSelf: Boolean
) : LagrangeIncomingMessage(
    ctx, raw, MessageType.PRIVATE,
    peer.uin, raw.contentHead.ntMsgSeq ?: 0L
), PrivateIncomingMessage {
    val clientSequence: Long = raw.contentHead.sequence ?: 0L

    companion object {
        val factories = listOf<LagrangeSegmentFactory<*>>(
            LagrangeTextSegment.Companion,
            LagrangeFaceSegment.Companion,
            LagrangeImageSegment.Companion,
            LagrangeReplySegment.Companion,
            LagrangeRecordSegment.Companion,
            LagrangeVideoSegment.Companion,
            LagrangeForwardSegment.Companion,
        )

        suspend fun create(ctx: LagrangeContext, raw: PushMsgBody): LagrangePrivateIncomingMessage? {
            val friend = ctx.getFriend(raw.responseHead.fromUin)
            if (friend == null) {
                logger.warn { "Failed to resolve friend ${raw.responseHead.fromUin}" }
                return null
            }
            val isSelf = raw.responseHead.fromUin == ctx.uin

            val draft = LagrangePrivateIncomingMessage(ctx, raw, friend, isSelf)
            val elementReader = ElementReader(
                ctx,
                message = draft,
                elements = raw.body!!.richText.elements.map { it.pb() }
            )
            while (elementReader.hasNext())
                factories.firstNotNullOfOrNull { it.tryParse(elementReader) }
                    ?.let { draft.segmentMutableList.add(it) }
                    ?: elementReader.skip()
            return draft.takeUnless { it.segments.isEmpty() }
        }
    }

    override fun toString(): String = "[$peer] $contentToString"
}