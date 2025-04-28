package org.ntqqrev.saltify.lagrange.adapter.model

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.cache.CachedEntity
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupsResponse

class LagrangeGroup(
    override var dataBinding: OidbFetchGroupsResponse.Entry,
    override val ctx: LagrangeContext
) : Group, CachedEntity<OidbFetchGroupsResponse.Entry> {
    override val uin: Long
        get() = dataBinding.groupUin
    override val name: String
        get() = dataBinding.info.groupName ?: "群聊"
    override val remark: String?
        get() = dataBinding.customInfo?.remark
    override val description: String?
        get() = dataBinding.info.description
    override val question: String?
        get() = dataBinding.info.question
    override val announcement: String?
        get() = dataBinding.info.announcement
    override val createdAt: Instant
        get() = Instant.fromEpochSeconds(dataBinding.info.createdTime)
    override val memberCount: Int
        get() = dataBinding.info.memberCount
    override val maxMemberCount: Int
        get() = dataBinding.info.memberMax

    override fun toString(): String = "${if (remark.isNullOrEmpty()) name else remark} ($uin)"
}