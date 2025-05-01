package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import io.github.oshai.kotlinlogging.KotlinLogging
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment.LagrangeFaceSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment.LagrangeImageSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment.LagrangeMentionSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment.LagrangeTextSegment
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroup
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroupMember
import org.ntqqrev.saltify.lagrange.packet.message.PushMsgBody
import org.ntqqrev.saltify.lagrange.util.binary.pb

private val logger = KotlinLogging.logger { }

class LagrangeGroupIncomingMessage(
    ctx: LagrangeContext,
    raw: PushMsgBody,
    override val group: LagrangeGroup,
    override val sender: LagrangeGroupMember,
) : LagrangeIncomingMessage(
    ctx, raw, MessageType.GROUP,
    group.uin, raw.contentHead.sequence ?: 0L,
), GroupIncomingMessage {
    companion object {
        val factories = listOf<LagrangeSegmentFactory<*>>(
            LagrangeTextSegment.Companion,
            LagrangeMentionSegment.Companion,
            LagrangeFaceSegment.Companion,
            LagrangeImageSegment.Companion,
        )

        suspend fun create(ctx: LagrangeContext, raw: PushMsgBody): LagrangeGroupIncomingMessage? {
            val groupExt = raw.responseHead.groupExt!!

            val group = ctx.getGroup(groupExt.groupUin)
            if (group == null) {
                logger.warn { "Failed to resolve group ${groupExt.groupUin}" }
                return null
            }
            val sender = ctx.getGroupMember(group.uin, raw.responseHead.fromUin)
            if (sender == null) {
                logger.warn { "Failed to resolve group member ${raw.responseHead.fromUin} in group ${group.uin}" }
                return null
            }

            val draft = LagrangeGroupIncomingMessage(ctx, raw, group, sender)
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

    override fun toString() = "[$group] [$sender] $contentToString"
}