package org.ntqqrev.saltify.api.event.group

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.Group
import org.ntqqrev.saltify.api.model.GroupMember
import java.time.Instant

open class GroupMessageReactionEvent(
    ctx: Context,
    time: Instant,
    group: Group,

    /**
     * The ID of the message that was reacted to.
     */
    val messageId: String,

    /**
     * The group member who sent the reaction.
     */
    val sender: GroupMember,

    /**
     * The ID of the reaction.
     */
    val reactionId: String,

    /**
     * Whether the reaction was added or removed.
     */
    val isAdd: Boolean,
) : AbstractGroupEvent(ctx, time, group)