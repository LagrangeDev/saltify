package org.ntqqrev.saltify.lagrange.adapter.action

import org.ntqqrev.saltify.api.context.action.RequestAction
import org.ntqqrev.saltify.lagrange.BotContext

class RequestActionImpl(val lagrange: BotContext) : AbstractImplementation(), RequestAction {
    override suspend fun acceptRequest(requestFlag: String) {
        TODO("Not yet implemented")
    }

    override suspend fun rejectRequest(requestFlag: String, reason: String?) {
        TODO("Not yet implemented")
    }
}