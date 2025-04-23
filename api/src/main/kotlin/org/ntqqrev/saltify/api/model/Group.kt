package org.ntqqrev.saltify.api.model

import org.ntqqrev.saltify.api.Entity
import java.time.Instant

interface Group : Entity {
    /**
     * The group ID.
     */
    val uin: Long

    /**
     * The group name.
     */
    val name: String

    /**
     * The remark of the group defined by the bot.
     */
    val remark: String

    /**
     * The description of the group, if present.
     */
    val description: String?

    /**
     * The question to answer to join the group, if present.
     */
    val question: String?

    /**
     * The announcement of the group, if present.
     */
    val announcement: String?

    /**
     * The creation time of the group.
     */
    val createdAt: Instant

    /**
     * The number of members in the group.
     */
    val memberCount: Int

    /**
     * The maximum number of members allowed in the group.
     * Possible values are 200, 500, 1000, 2000 and 3000.
     */
    val maxMemberCount: Int
}