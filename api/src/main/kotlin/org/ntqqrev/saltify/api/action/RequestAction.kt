package org.ntqqrev.saltify.api.action

interface RequestAction {
    /**
     * Accept the request with the given flag.
     */
    suspend fun acceptRequest(requestFlag: String)

    /**
     * Reject the request with the given flag, using the given reason or no reason.
     */
    suspend fun rejectRequest(requestFlag: String, reason: String?)
}