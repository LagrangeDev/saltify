package org.ntqqrev.saltify.lagrange.adapter.model

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.cache.CachedEntity

class LagrangeGroup(
    override var dataBinding: Binding,
    override val ctx: LagrangeContext
) : Group, CachedEntity<LagrangeGroup.Binding> {
    override val uin: Long
        get() = dataBinding.uin
    override val name: String
        get() = dataBinding.name
    override val remark: String?
        get() = dataBinding.remark
    override val description: String?
        get() = dataBinding.description
    override val question: String?
        get() = dataBinding.question
    override val announcement: String?
        get() = dataBinding.announcement
    override val createdAt: Instant
        get() = dataBinding.createdAt
    override val memberCount: Int
        get() = dataBinding.memberCount
    override val maxMemberCount: Int
        get() = dataBinding.maxMemberCount

    class Binding(
        var uin: Long,
        var name: String,
        var remark: String?,
        var description: String?,
        var question: String?,
        var announcement: String?,
        var createdAt: Instant,
        var memberCount: Int,
        var maxMemberCount: Int
    )

    override fun toString(): String = "${if (remark.isNullOrEmpty()) name else remark} ($uin)"
}