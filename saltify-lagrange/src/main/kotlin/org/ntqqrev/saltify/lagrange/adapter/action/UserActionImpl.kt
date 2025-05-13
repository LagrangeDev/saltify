package org.ntqqrev.saltify.lagrange.adapter.action

import org.ntqqrev.saltify.api.context.action.UserAction
import org.ntqqrev.saltify.lagrange.BotContext

class UserActionImpl(val lagrange: BotContext) : AbstractImplementation(), UserAction {
    override suspend fun sendProfileLike(userUin: Long, count: Int): Boolean {
        TODO("Not yet implemented")
    }
}