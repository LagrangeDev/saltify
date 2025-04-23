package org.ntqqrev.saltify.api.message.incoming.segment

import org.ntqqrev.saltify.api.model.GroupMember

interface MentionSegment : Segment {
    /**
     * The member to mention; if null, it means to mention all members.
     */
    val member: GroupMember?
}