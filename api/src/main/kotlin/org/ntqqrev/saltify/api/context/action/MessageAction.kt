package org.ntqqrev.saltify.api.context.action

import org.ntqqrev.saltify.api.context.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.context.message.outgoing.PrivateMessageBuilder

interface MessageAction {
    /**
     * Send a private message to a user.
     */
    suspend fun sendPrivateMessage(userUin: Long, builder: PrivateMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Send a group message to a group.
     */
    suspend fun sendGroupMessage(groupUin: Long, builder: GroupMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Get a message by its ID.
     */
    suspend fun getMessageById(messageId: String): IncomingMessage

    /**
     * Get some history messages from a user, starting from a specific message ID.
     */
    suspend fun getHistoryPrivateMessage(userUin: Long, startId: String, count: Int): List<PrivateIncomingMessage>

    /**
     * Get some history messages from a group, starting from a specific message ID.
     */
    suspend fun getHistoryGroupMessage(groupUin: Long, startId: String, count: Int): List<GroupIncomingMessage>

    /**
     * Get a URL for a resource.
     */
    suspend fun getResourceTempUrl(resourceId: String): String

    /**
     * Get the forward messages from ID.
     */
    suspend fun getForwardedMessages(forwardId: String): List<ForwardedIncomingMessage>

    /**
     * Recall a message.
     * @return true if the message was recalled successfully, false otherwise.
     */
    suspend fun recallMessage(incomingMessage: IncomingMessage): Boolean

    /**
     * Send a poke to a user.
     */
    suspend fun sendPrivatePoke(userUin: Long)

    /**
     * Send a poke to a group.
     */
    suspend fun sendGroupPoke(groupUin: Long, memberUin: Long)

    /**
     * Add / delete a reaction to a **group** message.
     */
    suspend fun setMessageFaceReaction(messageId: String, reactionId: String, isAdd: Boolean)
}