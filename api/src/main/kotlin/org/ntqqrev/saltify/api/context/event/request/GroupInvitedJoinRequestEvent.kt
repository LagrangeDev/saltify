package org.ntqqrev.saltify.api.context.event.request

import org.ntqqrev.saltify.api.context.Context
import kotlinx.datetime.Instant

/**
 * Someone in a group invited another user to join the group
 */
open class GroupInvitedJoinRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long,

    /**
     * The uin of the one being invited to join the group.
     */
    val inviteeUin: Long
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)