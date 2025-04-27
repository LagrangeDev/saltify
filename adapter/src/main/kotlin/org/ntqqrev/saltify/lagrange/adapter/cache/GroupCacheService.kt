package org.ntqqrev.saltify.lagrange.adapter.cache

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroup
import org.ntqqrev.saltify.lagrange.operation.system.FetchGroups

class GroupCacheService(ctx: LagrangeContext) :
    AbstractCacheService<LagrangeGroup, Long, LagrangeGroup.Binding>(ctx) {
    override suspend fun fetchData(): Map<Long, LagrangeGroup.Binding> =
        ctx.lagrange.callOperation(FetchGroups)
            .entries.associate { it.groupUin to LagrangeGroup.Binding(
                uin = it.groupUin,
                name = it.info.groupName ?: "群聊",
                remark = it.customInfo?.remark,
                description = it.info.description,
                question = it.info.question,
                announcement = it.info.announcement,
                createdAt = Instant.fromEpochSeconds(it.info.createdTime),
                memberCount = it.info.memberCount,
                maxMemberCount = it.info.memberMax,
            ) }

    override fun constructNewEntity(data: LagrangeGroup.Binding): LagrangeGroup =
        LagrangeGroup(data, ctx)
}