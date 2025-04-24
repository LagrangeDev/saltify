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
    suspend fun getAllFriends(cacheFirst: Boolean = true): Iterable<Friend>

    /**
     * Get a friend by its uin.
     */
    suspend fun getFriend(friendUin: Long, cacheFirst: Boolean = true): Friend?

    /**
     * Get all groups.
     */
    suspend fun getAllGroups(cacheFirst: Boolean = true): Iterable<Group>

    /**
     * Get a group by its uin.
     */
    suspend fun getGroup(groupUin: Long, cacheFirst: Boolean = true): Group?

    /**
     * The stopping logic of the context.
     */
    suspend fun stop()
}