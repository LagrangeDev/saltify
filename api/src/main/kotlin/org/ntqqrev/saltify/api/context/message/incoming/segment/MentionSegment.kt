package org.ntqqrev.saltify.api.context.message.incoming.segment

import org.ntqqrev.saltify.api.context.model.GroupMember

interface MentionSegment : Segment {
    /**
     * The member to mention; if null, it means to mention all members.
     */
    val member: GroupMember?
}