package org.ntqqrev.saltify.lagrange.adapter.cache

import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeFriend
import org.ntqqrev.saltify.lagrange.operation.system.FetchFriends

class FriendCacheService(ctx: LagrangeContext) :
    AbstractCacheService<LagrangeFriend, Long, LagrangeFriend.Binding>(ctx) {
    override suspend fun fetchData(): Map<Long, LagrangeFriend.Binding> {
        var nextUin: Long? = null
        val result = mutableMapOf<Long, LagrangeFriend.Binding>()
        do {
            val fetchResult = ctx.lagrange
                .callOperation(FetchFriends, FetchFriends.Req(nextUin))
            nextUin = fetchResult.nextUin
            fetchResult.entries.forEach {
                result[it.uin] = LagrangeFriend.Binding(
                    uin = it.uin,
                    name = it.nickname ?: it.uin.toString(),
                    remark = it.remark,
                    signature = it.signature,
                    qid = it.qid,
                    category = it.category
                )
            }
        } while (nextUin != null)
        return result
    }

    override fun constructNewEntity(data: LagrangeFriend.Binding): LagrangeFriend =
        LagrangeFriend(data, ctx)
}