package org.ntqqrev.saltify.api.context.message.incoming

import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.api.context.model.GroupMember

interface GroupIncomingMessage : IncomingMessage {
    /**
     * The group where the message was sent.
     */
    val group: Group

    /**
     * The member who sent the message.
     */
    val sender: GroupMember
}