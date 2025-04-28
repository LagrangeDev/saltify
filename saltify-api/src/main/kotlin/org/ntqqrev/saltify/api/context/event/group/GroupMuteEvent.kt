package org.ntqqrev.saltify.api.context.event.group

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember

open class GroupMuteEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member who is muted. Null if the whole group is muted.
     */
    val member: GroupMember?,

    /**
     * The group member who muted the group member.
     */
    val operator: GroupMember? = null,

    /**
     * The duration in seconds.
     * Null means unmuted, and -1 means permanently muted (only in whole mute).
     */
    val duration: Int?,
) : AbstractGroupEvent(ctx, time, group)