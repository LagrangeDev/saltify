package org.ntqqrev.saltify.api.context.event.friend

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.event.Event
import kotlinx.datetime.Instant

abstract class AbstractFriendEvent(
    ctx: Context,
    time: Instant,

    /**
     * The friend related to the event.
     */
    val friend: Friend
) : Event(ctx, time)