package org.ntqqrev.saltify.api.context.event.friend

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Friend

open class FriendPokeEvent(
    ctx: Context,
    time: Instant,
    friend: Friend,

    /**
     * Whether the poke is sent by the bot itself.
     */
    val isSelf: Boolean,
) : AbstractFriendEvent(ctx, time, friend)