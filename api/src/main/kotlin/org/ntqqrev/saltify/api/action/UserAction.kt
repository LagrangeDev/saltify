package org.ntqqrev.saltify.api.action

interface UserAction {
    /**
     * Send profile like to a user.
     */
    suspend fun sendProfileLike(userUin: Long, count: Int): Boolean
}