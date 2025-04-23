package org.ntqqrev.saltify.api

/**
 * Represents an object bound to a context.
 */
interface Entity {
    /**
     * The context where the entity is bound to.
     */
    val ctx: Context
}