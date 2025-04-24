package org.ntqqrev.saltify.lagrange.adapter

import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.action.*
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.lagrange.BotContext

class LagrangeContext(
    val lagrange: BotContext,
    val init: LagrangeInit,
    val env: Environment,
    val channel: MutableSharedFlow<Event>,
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