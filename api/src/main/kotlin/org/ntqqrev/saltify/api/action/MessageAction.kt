package org.ntqqrev.saltify.api.action

import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.User
import org.ntqqrev.saltify.api.message.incoming.ForwardedIncomingMessage
import org.ntqqrev.saltify.api.message.incoming.GroupIncomingMessage
import org.ntqqrev.saltify.api.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.message.incoming.PrivateIncomingMessage
import org.ntqqrev.saltify.api.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.message.outgoing.MessageSendResult
import org.ntqqrev.saltify.api.message.outgoing.PrivateMessageBuilder

interface MessageAction {
    /**
     * Send a private message to a user.
     */
    suspend fun sendPrivateMessage(peer: User, builder: PrivateMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Send a group message to a group.
     */
    suspend fun sendGroupMessage(peer: Group, builder: GroupMessageBuilder.() -> Unit): MessageSendResult

    /**
     * Get a message by its ID.
     */
    suspend fun getMessageById(messageId: String): IncomingMessage

    /**
     * Get some history messages from a user, starting from a specific message ID.
     */
    suspend fun getHistoryPrivateMessage(peer: User, startId: String, count: Int): List<PrivateIncomingMessage>

    /**
     * Get some history messages from a group, starting from a specific message ID.
     */
    suspend fun getHistoryGroupMessage(peer: Group, startId: String, count: Int): List<GroupIncomingMessage>

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
     * Add / delete a reaction to a **group** message.
     */
    suspend fun setMessageFaceReaction(messageId: String, reactionId: String, isAdd: Boolean)
}