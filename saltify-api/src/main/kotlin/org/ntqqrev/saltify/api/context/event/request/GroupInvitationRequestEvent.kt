package org.ntqqrev.saltify.api.context.event.request

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context

/**
 * Someone invited you to join the group.
 */
open class GroupInvitationRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)