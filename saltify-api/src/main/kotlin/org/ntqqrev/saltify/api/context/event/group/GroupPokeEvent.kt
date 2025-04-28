package org.ntqqrev.saltify.api.context.event.group

import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember
import kotlinx.datetime.Instant

open class GroupPokeEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The group member who sent the poke.
     */
    val sender: GroupMember,

    /**
     * The group member who received the poke.
     */
    val receiver: GroupMember,
) : AbstractGroupEvent(ctx, time, group)