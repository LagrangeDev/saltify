package org.ntqqrev.saltify.api.model.group

import org.ntqqrev.saltify.api.Entity
import org.ntqqrev.saltify.api.model.Group

interface FileSystemEntry : Entity {
    /**
     * The group the file system entry belongs to.
     */
    val group: Group
}