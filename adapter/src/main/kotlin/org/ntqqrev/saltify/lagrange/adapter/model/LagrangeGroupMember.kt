package org.ntqqrev.saltify.lagrange.adapter.model

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.util.cache.CachedEntity

class LagrangeGroupMember(
    override val group: Group,
    override var dataBinding: Binding,
    override val ctx: LagrangeContext
) : GroupMember, CachedEntity<LagrangeGroupMember.Binding> {
    override val uin: Long
        get() = dataBinding.uin
    override val name: String
        get() = dataBinding.name
    override val remark: String?
        get() = dataBinding.remark
    override val signature: String?
        get() = dataBinding.signature
    override val qid: String?
        get() = dataBinding.qid
    override val card: String?
        get() = dataBinding.card
    override val specialTitle: String?
        get() = dataBinding.specialTitle
    override val level: Int
        get() = dataBinding.level
    override val joinedAt: Instant
        get() = dataBinding.joinedAt
    override val lastSpokeAt: Instant?
        get() = dataBinding.lastSpokeAt
    override val isBannedUntil: Instant?
        get() = dataBinding.isBannedUntil
    override val role: GroupMember.Role
        get() = dataBinding.role

    class Binding(
        var uin: Long,
        var name: String,
        var remark: String?,
        var signature: String?,
        var qid: String?,
        var card: String?,
        var specialTitle: String?,
        var level: Int,
        var joinedAt: Instant,
        var lastSpokeAt: Instant?,
        var isBannedUntil: Instant?,
        var role: GroupMember.Role,
    )

    override fun toString(): String = "${
        if (remark.isNullOrEmpty()) (
                if (card.isNullOrEmpty()) name else card
                ) else remark
    } ($uin)"
}