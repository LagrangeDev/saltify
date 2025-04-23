package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.GroupMember
import java.time.Instant

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