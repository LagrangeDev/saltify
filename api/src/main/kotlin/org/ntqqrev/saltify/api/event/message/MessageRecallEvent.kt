package org.ntqqrev.saltify.api.event.message

import org.ntqqrev.saltify.api.Context
import org.ntqqrev.saltify.api.model.GroupMember
import kotlinx.datetime.Instant

open class MessageRecallEvent(
    ctx: Context,
    time: Instant,
    message: String,

    /**
     * The group member who recalled the message if the message was sent in a group.
     */
    val operator: GroupMember?
) : AbstractMessageEvent(ctx, time, message)