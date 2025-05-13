package org.ntqqrev.saltify.lagrange.operation.message

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.Operation
import org.ntqqrev.saltify.lagrange.packet.message.PbSendMsg
import org.ntqqrev.saltify.lagrange.packet.message.PbSendMsgResponse
import org.ntqqrev.saltify.lagrange.util.binary.pb

object SendMessage : Operation<PbSendMsg, SendMessage.Resp> {
    override val command = "MessageSvc.PbSendMsg"

    override fun build(bot: BotContext, payload: PbSendMsg) = payload.pb()

    override fun parse(bot: BotContext, payload: ByteArray): Resp {
        val pbSendMsgResponse = payload.pb<PbSendMsgResponse>()
        if (pbSendMsgResponse.result != 0) {
            throw IllegalStateException("Failed to send message: ${pbSendMsgResponse.errorMsg}")
        }
        return Resp(
            timestamp = pbSendMsgResponse.timestamp,
            sequence = pbSendMsgResponse.sequence,
        )
    }

    class Resp(
        val timestamp: Long,
        val sequence: Long,
    )
}