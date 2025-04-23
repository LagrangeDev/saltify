package org.ntqqrev.saltify.api.model

import org.ntqqrev.saltify.api.Entity

/**
 * Represents a user in the system.
 */
interface User : Entity {
    /**
     * The ID of the user.
     */
    val uin: Long

    /**
     * The nickname of the user.
     */
    val name: String

    /**
     * The remark name of the user defined by the bot.
     */
    val remark: String?

    /**
     * The signature of the user.
     */
    val signature: String?

    /**
     * Another identifier of the user, if defined.
     */
    val qid: String?
}