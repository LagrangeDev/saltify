package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.model.GroupMember

open class MentionSegment(
    message: IncomingMessage,

    /**
     * The member to mention; if null, it means to mention all members.
     */
    val member: GroupMember?
) : Segment(message)