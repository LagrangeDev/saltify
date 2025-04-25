package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.packet.message.PushMsgBody

class LagrangeGroupIncomingMessage(
    time: Instant,
    ctx: Context,
    messageType: MessageType,
    peerUin: Long,
    sequence: Long,
    override val group: Group,
    override val sender: GroupMember,
) : LagrangeIncomingMessage(time, ctx, messageType, peerUin, sequence), GroupIncomingMessage {
    companion object {
        suspend fun create(ctx: LagrangeContext, raw: PushMsgBody) {

        }
    }
}