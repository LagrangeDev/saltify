package org.ntqqrev.saltify.api.context.event.request

import org.ntqqrev.saltify.api.context.Context
import kotlinx.datetime.Instant

/**
 * Someone wants to add you as a friend.
 */
open class FriendRequestEvent(
    ctx: Context,
    time: Instant,
    flag: String,
    operatorUin: Long,

    /**
     * The additional message sent with the request.
     */
    val comment: String,

    /**
     * How the requestor found you, e.g., via a group, a friend, or a search.
     */
    val via: String,
) : AbstractRequestEvent(ctx, time, flag, operatorUin)