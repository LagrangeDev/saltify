package org.ntqqrev.saltify.lagrange.adapter.cache

import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroup
import org.ntqqrev.saltify.lagrange.operation.system.FetchGroups
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupsResponse

class GroupCacheService(ctx: LagrangeContext) :
    AbstractCacheService<LagrangeGroup, Long, OidbFetchGroupsResponse.Entry>(ctx) {
    override suspend fun fetchData(): Map<Long, OidbFetchGroupsResponse.Entry> =
        ctx.lagrange.callOperation(FetchGroups)
            .entries.associateBy { it.groupUin }

    override fun constructNewEntity(data: OidbFetchGroupsResponse.Entry): LagrangeGroup =
        LagrangeGroup(data, ctx)
}