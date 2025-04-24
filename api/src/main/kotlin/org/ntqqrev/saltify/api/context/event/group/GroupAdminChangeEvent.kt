package org.ntqqrev.saltify.api.context.event.group

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import kotlinx.datetime.Instant

open class GroupAdminChangeEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member who is changed to / from admin.
     */
    val member: GroupMember,

    /**
     * Whether the member is changed to admin (true) or from admin (false).
     */
    val isAdmin: Boolean,
) : AbstractGroupEvent(ctx, time, group)