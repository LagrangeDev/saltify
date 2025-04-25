package org.ntqqrev.saltify.lagrange.adapter.message.incoming

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.model.User
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.packet.message.PushMsg

class LagrangePrivateIncomingMessage(
    time: Instant,
    ctx: Context,
    messageType: MessageType,
    peerUin: Long,
    sequence: Long,
    override val peer: User,
    override val isSelf: Boolean
) : LagrangeIncomingMessage(time, ctx, messageType, peerUin, sequence), PrivateIncomingMessage {
    companion object {
        suspend fun create(ctx: LagrangeContext, pushMsg: PushMsg) {

        }
    }
}