package org.ntqqrev.saltify.lagrange.event

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.packet.message.PushMsg
import org.ntqqrev.saltify.lagrange.packet.message.PushMsgBody
import org.ntqqrev.saltify.lagrange.util.binary.pb

class MessagePushEvent(val push: PushMsgBody) : SystemEvent() {
    val type: Int = push.contentHead.type
    val subType: Int? = push.contentHead.subType

    companion object : SystemEventFactory<MessagePushEvent> {
        override val command = "trpc.msg.olpush.OlPushService.MsgPush"

        override fun buildEvent(bot: BotContext, payload: ByteArray) =
            MessagePushEvent(payload.pb<PushMsg>().message)
    }
}