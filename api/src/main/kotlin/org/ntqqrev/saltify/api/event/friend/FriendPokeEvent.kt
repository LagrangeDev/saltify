package org.ntqqrev.saltify.api.event.friend

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Friend
import kotlinx.datetime.Instant

open class FriendPokeEvent(
    ctx: Context,
    time: Instant,
    friend: Friend,

    /**
     * Whether the poke is sent by the bot itself.
     */
    val isSelf: Boolean,
) : AbstractFriendEvent(ctx, time, friend)