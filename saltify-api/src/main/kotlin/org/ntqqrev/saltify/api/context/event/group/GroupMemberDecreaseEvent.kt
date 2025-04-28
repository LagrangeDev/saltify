package org.ntqqrev.saltify.api.context.event.group

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember

open class GroupMemberDecreaseEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member who left the group.
     * It is no longer a member, so the param is not a GroupMember object.
     */
    val memberUin: Long,

    /**
     * The one who kicked the member out of the group, if applicable.
     * The bot may not be able to retrieve the operator.
     */
    val operator: GroupMember? = null,
) : AbstractGroupEvent(ctx, time, group)