package org.ntqqrev.saltify.api.model

import kotlinx.datetime.Instant

interface GroupMember : User {
    /**
     * The group which the member belongs to.
     */
    val group: Group

    /**
     * The member's group-specific nickname.
     */
    val card: String?

    /**
     * The member's special title granted by the group owner.
     */
    val specialTitle: String?

    /**
     * The member's group-specific level, from 1 to 100.
     */
    val level: Int

    /**
     * The join time of the member.
     */
    val joinedAt: Instant

    /**
     * The last time the member spoke in the group.
     */
    val lastSpokeAt: Instant?

    /**
     * The time the member can speak again after being banned.
     */
    val isBannedUntil: Instant?

    /**
     * The member's role in the group.
     */
    val role: Role

    enum class Role {
        OWNER,
        ADMIN,
        MEMBER,
    }
}