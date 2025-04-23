package org.ntqqrev.saltify.api.message.outgoing.feature

interface MentionFeature {
    /**
     * Mention a user in the group.
     */
    fun mention(uin: Long)

    /**
     * Mention all users in the group.
     */
    fun mentionAll()
}