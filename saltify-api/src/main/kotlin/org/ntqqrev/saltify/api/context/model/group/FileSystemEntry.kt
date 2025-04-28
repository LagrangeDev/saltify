package org.ntqqrev.saltify.api.context.model.group

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.model.Group

interface FileSystemEntry : Entity {
    /**
     * The group the file system entry belongs to.
     */
    val group: Group
}