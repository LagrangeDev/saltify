package org.ntqqrev.saltify.api.context.event.request

import org.ntqqrev.saltify.api.context.Context
import kotlinx.datetime.Instant

abstract class GroupRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,

    /**
     * The uin of the group related to the request.
     */
    val groupUin: Long
) : AbstractRequestEvent(ctx, time, flag, operatorUin)