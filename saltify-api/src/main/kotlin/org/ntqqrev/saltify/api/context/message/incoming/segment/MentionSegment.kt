package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.model.GroupMember

open class MentionSegment(
    message: IncomingMessage,

    /**
     * The uin of the mentioned user. `0L` means all members of the group are mentioned.
     */
    val uin: Long,

    /**
     * The name of the mentioned user.
     */
    val name: String
) : Segment(message)