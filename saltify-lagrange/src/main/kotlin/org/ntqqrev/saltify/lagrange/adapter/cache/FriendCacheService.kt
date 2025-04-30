package org.ntqqrev.saltify.lagrange.adapter.cache

import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeFriend
import org.ntqqrev.saltify.lagrange.operation.friend.FetchFriends

class FriendCacheService(ctx: LagrangeContext) :
    AbstractCacheService<LagrangeFriend, Long, FetchFriends.Entry>(ctx) {
    override suspend fun fetchData(): Map<Long, FetchFriends.Entry> {
        var nextUin: Long? = null
        val result = mutableMapOf<Long, FetchFriends.Entry>()
        do {
            val fetchResult = ctx.lagrange
                .callOperation(FetchFriends, FetchFriends.Req(nextUin))
            nextUin = fetchResult.nextUin
            fetchResult.entries.forEach {
                result[it.uin] = it
            }
        } while (nextUin != null && nextUin != 0L)
        return result
    }

    override fun constructNewEntity(data: FetchFriends.Entry): LagrangeFriend =
        LagrangeFriend(data, ctx)
}