package org.ntqqrev.saltify.api.context.event.friend

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.api.context.model.Friend

abstract class AbstractFriendEvent(
    ctx: Context,
    time: Instant,

    /**
     * The friend related to the event.
     */
    val friend: Friend
) : Event(ctx, time)