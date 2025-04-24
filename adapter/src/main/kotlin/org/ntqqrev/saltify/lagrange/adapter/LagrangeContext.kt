package org.ntqqrev.saltify.lagrange.adapter

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.action.FileAction
import org.ntqqrev.saltify.api.context.action.GroupAction
import org.ntqqrev.saltify.api.context.action.MessageAction
import org.ntqqrev.saltify.api.context.action.RequestAction
import org.ntqqrev.saltify.api.context.action.UserAction
import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.model.Group

class LagrangeContext(
    messageActionImpl: MessageAction,
    userActionImpl: UserAction,
    groupActionImpl: GroupAction,
    requestActionImpl: RequestAction,
    fileActionImpl: FileAction
) : Context, MessageAction by messageActionImpl, UserAction by userActionImpl, GroupAction by groupActionImpl,
    RequestAction by requestActionImpl, FileAction by fileActionImpl {

    override val uin: Long
        get() = TODO("Not yet implemented")
    override val state: Context.State
        get() = TODO("Not yet implemented")

    override suspend fun start() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFriends(cacheFirst: Boolean): Iterable<Friend> {
        TODO("Not yet implemented")
    }

    override suspend fun getFriend(friendUin: Long, cacheFirst: Boolean): Friend? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllGroups(cacheFirst: Boolean): Iterable<Group> {
        TODO("Not yet implemented")
    }

    override suspend fun getGroup(groupUin: Long, cacheFirst: Boolean): Group? {
        TODO("Not yet implemented")
    }

    override suspend fun stop() {
        TODO("Not yet implemented")
    }
}