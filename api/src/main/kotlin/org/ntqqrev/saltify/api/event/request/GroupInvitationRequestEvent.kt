package org.ntqqrev.saltify.api.event.request

import org.ntqqrev.saltify.api.Context
import java.time.Instant

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