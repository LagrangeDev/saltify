package org.ntqqrev.saltify.api.context.event.request

import org.ntqqrev.saltify.api.context.Context
import kotlinx.datetime.Instant

/**
 * Someone requests to join the group.
 */
open class GroupJoinRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,
    groupUin: Long,

    /**
     * Whether the request is filtered (regarded as unsafe).
     */
    val isFiltered: Boolean,

    /**
     * The additional message sent with the request.
     */
    val comment: String,
) : GroupRequestEvent(ctx, time, flag, operatorUin, groupUin)