package org.ntqqrev.saltify.api.context.action

interface UserAction {
    /**
     * Send profile like to a user.
     */
    suspend fun sendProfileLike(userUin: Long, count: Int): Boolean
}