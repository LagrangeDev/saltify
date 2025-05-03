package org.ntqqrev.saltify.lagrange.adapter.action

import org.ntqqrev.saltify.api.context.action.MessageAction
import org.ntqqrev.saltify.api.context.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.context.message.outgoing.PrivateMessageBuilder
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.highway.GetGroupImageUrl
import org.ntqqrev.saltify.lagrange.operation.highway.GetPrivateImageUrl
import org.ntqqrev.saltify.lagrange.packet.highway.FileId
import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.lagrange.util.binary.pb
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

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

    @OptIn(ExperimentalEncodingApi::class)
    override suspend fun getResourceTempUrl(resourceId: String): String {
        if (resourceId.startsWith("url:"))
            return resourceId.substring(4)

        // Is File ID
        val actualLength = if (resourceId.length % 4 == 0) {
            resourceId.length
        } else {
            resourceId.length + (4 - resourceId.length % 4)
        }
        val normalizedBase64 = resourceId
            .replace("-", "+")
            .replace("_", "/")
            .padEnd(actualLength, '=')
        val fileIdDecoded = Base64.Default.decode(normalizedBase64).pb<FileId>()
        val indexNode = IndexNode(
            fileUuid = resourceId,
            ttl = fileIdDecoded.ttl
        )

        return when (fileIdDecoded.appId) {
            1406 -> lagrange.callOperation(GetPrivateImageUrl, indexNode)
            1407 -> lagrange.callOperation(GetGroupImageUrl, indexNode)
            // TODO: Handle other app IDs
            else -> throw IllegalArgumentException("Unsupported appId: ${fileIdDecoded.appId}")
        }
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