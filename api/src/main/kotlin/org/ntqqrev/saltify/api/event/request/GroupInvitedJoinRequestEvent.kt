package org.ntqqrev.saltify.api.event.request

import org.ntqqrev.saltify.api.Context
import java.time.Instant

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