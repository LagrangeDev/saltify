package org.ntqqrev.saltify.api.context.event.message

import kotlinx.datetime.Instant
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.model.GroupMember

open class MessageRecallEvent(
    ctx: Context,
    time: Instant,
    message: String,

    /**
     * The group member who recalled the message if the message was sent in a group.
     */
    val operator: GroupMember?
) : AbstractMessageEvent(ctx, time, message)