package org.ntqqrev.saltify.lagrange.adapter.model

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.adapter.cache.CachedEntity
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupMembersResponse

class LagrangeGroupMember(
    override val group: Group,
    override var dataBinding: OidbFetchGroupMembersResponse.Entry,
    override val ctx: LagrangeContext
) : GroupMember, CachedEntity<OidbFetchGroupMembersResponse.Entry> {
    override val uin: Long
        get() = dataBinding.identity.uin
    override val name: String
        get() = dataBinding.memberName ?: uin.toString()
    override val remark: String?
        get() = null
    override val signature: String?
        get() = null
    override val qid: String?
        get() = null
    override val card: String?
        get() = dataBinding.memberCard?.memberCard
    override val specialTitle: String?
        get() = dataBinding.specialTitle
    override val level: Int
        get() = dataBinding.level?.level ?: 0
    override val joinedAt: Instant
        get() = Instant.fromEpochSeconds(dataBinding.joinTimestamp)
    override val lastSpokeAt: Instant?
        get() = Instant.fromEpochSeconds(dataBinding.lastMsgTimestamp)
    override val isBannedUntil: Instant?
        get() = dataBinding.shutUpTimestamp?.let { Instant.fromEpochSeconds(it) }
    override val role: GroupMember.Role
        get() = when (dataBinding.permission) {
            0 -> GroupMember.Role.MEMBER
            1 -> GroupMember.Role.ADMIN
            2 -> GroupMember.Role.OWNER
            else -> throw Exception("Unknown role: ${dataBinding.permission}")
        }

    override fun toString(): String = "${
        if (remark.isNullOrEmpty()) (
                if (card.isNullOrEmpty()) name else card
                ) else remark
    } ($uin)"
}