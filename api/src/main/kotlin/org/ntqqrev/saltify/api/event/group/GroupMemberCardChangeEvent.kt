package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.GroupMember
import kotlinx.datetime.Instant

open class GroupMemberCardChangeEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member whose card has changed.
     */
    val member: GroupMember,

    /**
     * The old card of the group member.
     */
    val oldCard: String?,

    /**
     * The new card of the group member, null if the member has no card.
     */
    val newCard: String?,
) : AbstractGroupEvent(ctx, time, group)