package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.model.GroupMember

open class MentionSegment(
    message: IncomingMessage,

    /**
     * The uin of the mentioned user.
     */
    val mentionedUin: Long?,

    /**
     * The name of the mentioned user.
     */
    val mentionedName: String?
) : Segment(message)