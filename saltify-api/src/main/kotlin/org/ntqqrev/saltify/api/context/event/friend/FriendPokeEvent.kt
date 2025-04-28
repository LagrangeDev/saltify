package org.ntqqrev.saltify.api.context.event.friend

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Friend
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