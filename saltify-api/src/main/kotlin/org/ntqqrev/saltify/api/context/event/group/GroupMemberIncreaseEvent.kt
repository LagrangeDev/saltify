package org.ntqqrev.saltify.api.context.event.group

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import kotlinx.datetime.Instant

open class GroupMemberIncreaseEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member who joined the group.
     */
    val member: GroupMember,

    /**
     * The group member who invited the new member to the group, if applicable.
     */
    val operator: GroupMember? = null,

    /**
     * The group member who invited the new member to the group, if applicable.
     */
    val invitor: GroupMember? = null,
) : AbstractGroupEvent(ctx, time, group)