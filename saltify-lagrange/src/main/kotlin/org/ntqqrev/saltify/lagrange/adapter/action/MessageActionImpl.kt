package org.ntqqrev.saltify.lagrange.adapter.action

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.action.MessageAction
import org.ntqqrev.saltify.api.context.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.context.message.outgoing.PrivateMessageBuilder
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.adapter.message.MessageType
import org.ntqqrev.saltify.lagrange.adapter.message.encodeMessageId
import org.ntqqrev.saltify.lagrange.adapter.message.outgoing.LagrangeGroupMessageBuilder
import org.ntqqrev.saltify.lagrange.operation.highway.*
import org.ntqqrev.saltify.lagrange.operation.message.SendMessage
import org.ntqqrev.saltify.lagrange.packet.highway.FileId
import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.lagrange.util.binary.pb
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.random.Random

class MessageActionImpl(val lagrange: BotContext) : AbstractImplementation(), MessageAction {
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
        val builder = LagrangeGroupMessageBuilder(
            outerContext,
            groupUin,
            clientSequence = Random.nextInt(10000, 99999),
            random = Random.nextInt(100000, Int.MAX_VALUE)
        )
        builder.builder()
        val message = builder.build()
        val result = lagrange.callOperation(SendMessage, message)
        return SendResult(
            sequence = result.sequence,
            time = Instant.fromEpochSeconds(result.timestamp),
            ctx = outerContext,
        )
    }

    override suspend fun queryPrivateMessage(
        userUin: Long,
        beginSequence: Long,
        endSequence: Long
    ): List<PrivateIncomingMessage> {
        TODO("Not yet implemented")
    }

    override suspend fun queryGroupMessage(
        groupUin: Long,
        beginSequence: Long,
        endSequence: Long
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
            1402 -> lagrange.callOperation(GetPrivateRecordUrl, indexNode)
            1403 -> lagrange.callOperation(GetGroupRecordUrl, indexNode)
            1413 -> lagrange.callOperation(GetPrivateVideoUrl, indexNode)
            1415 -> lagrange.callOperation(GetGroupVideoUrl, indexNode)
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

    class SendResult(
        override val sequence: Long,
        override val time: Instant,
        override val ctx: Context,
    ) : MessageSendResult
}