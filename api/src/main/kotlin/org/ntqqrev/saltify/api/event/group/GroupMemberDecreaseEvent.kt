package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.GroupMember
import java.time.Instant

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