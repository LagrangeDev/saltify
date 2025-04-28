package org.ntqqrev.saltify.api.context.action

import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember

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
     * Get all group members from a group.
     */
    suspend fun getGroupMembers(groupUin: Long, cacheFirst: Boolean = true): Iterable<GroupMember>

    /**
     * Get a group member by its uin.
     */
    suspend fun getGroupMember(groupUin: Long, memberUin: Long, cacheFirst: Boolean = true): GroupMember?

    /**
     * The stopping logic of the context.
     */
    suspend fun stop()
}