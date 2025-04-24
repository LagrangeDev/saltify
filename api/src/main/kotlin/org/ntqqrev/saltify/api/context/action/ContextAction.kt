package org.ntqqrev.saltify.api.context.action

import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.model.Group

interface ContextAction {
    /**
     * The starting logic of the context.
     */
    suspend fun start()

    /**
     * Get all friends.
     */
    suspend fun getAllFriends(): Iterable<Friend>

    /**
     * Get a friend by its uin.
     */
    suspend fun getFriend(friendUin: Long): Friend?

    /**
     * Get all groups.
     */
    suspend fun getAllGroups(): Iterable<Group>

    /**
     * Get a group by its uin.
     */
    suspend fun getGroup(groupUin: Long): Group?

    /**
     * The stopping logic of the context.
     */
    suspend fun stop()
}