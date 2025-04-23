package org.ntqqrev.saltify.api.event.friend

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Friend
import org.ntqqrev.saltify.api.event.Event
import kotlinx.datetime.Instant

abstract class AbstractFriendEvent(
    ctx: Context,
    time: Instant,

    /**
     * The friend related to the event.
     */
    val friend: Friend
) : Event(ctx, time)