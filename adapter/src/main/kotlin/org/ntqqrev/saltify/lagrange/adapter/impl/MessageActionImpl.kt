package org.ntqqrev.saltify.lagrange.adapter.impl

import org.ntqqrev.saltify.api.context.action.MessageAction
import org.ntqqrev.saltify.api.context.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.context.message.outgoing.PrivateMessageBuilder
import org.ntqqrev.saltify.lagrange.BotContext

class MessageActionImpl(val lagrange: BotContext) : MessageAction {
    override suspend fun sendPrivateMessage(
        userUin: Long,
        builder: PrivateMessageBuilder.() -> Unit
    ): MessageSendResult {
        TODO("Not yet implemented")
    }

    override suspend fun sendGroupMessage(
        groupUin: Long,
        builder: GroupMessageBuilder.() -> Unit
    ): MessageSendResult {
        TODO("Not yet implemented")
    }

    override suspend fun getMessageById(messageId: String): IncomingMessage {
        TODO("Not yet implemented")
    }

    override suspend fun getHistoryPrivateMessage(
        userUin: Long,
        startId: String,
        count: Int
    ): List<PrivateIncomingMessage> {
        TODO("Not yet implemented")
    }

    override suspend fun getHistoryGroupMessage(
        groupUin: Long,
        startId: String,
        count: Int
    ): List<GroupIncomingMessage> {
        TODO("Not yet implemented")
    }

    override suspend fun getResourceTempUrl(resourceId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getForwardedMessages(forwardId: String): List<ForwardedIncomingMessage> {
        TODO("Not yet implemented")
    }

    override suspend fun recallMessage(incomingMessage: IncomingMessage): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun sendPrivatePoke(userUin: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun sendGroupPoke(groupUin: Long, memberUin: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun setMessageFaceReaction(
        messageId: String,
        reactionId: String,
        isAdd: Boolean
    ) {
        TODO("Not yet implemented")
    }
}