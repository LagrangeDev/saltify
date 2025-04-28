package org.ntqqrev.saltify.lagrange.adapter.cache

import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroup
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroupMember
import org.ntqqrev.saltify.lagrange.operation.group.FetchGroupMembers
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupMembersResponse

class GroupMemberCacheService(val group: LagrangeGroup) :
    AbstractCacheService<LagrangeGroupMember, Long, OidbFetchGroupMembersResponse.Entry>(group.ctx) {
    override suspend fun fetchData(): Map<Long, OidbFetchGroupMembersResponse.Entry> {
        var token: String? = null
        val result = mutableMapOf<Long, OidbFetchGroupMembersResponse.Entry>()
        do {
            val fetchResult = ctx.lagrange
                .callOperation(
                    FetchGroupMembers,
                    FetchGroupMembers.Req(group.uin, token)
                )
            token = fetchResult.token
            fetchResult.entries.forEach { result[it.identity.uin] = it }
        } while (token != null)
        return result
    }

    override fun constructNewEntity(data: OidbFetchGroupMembersResponse.Entry): LagrangeGroupMember =
        LagrangeGroupMember(group, data, ctx)
}