package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.GroupMember
import java.time.Instant

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