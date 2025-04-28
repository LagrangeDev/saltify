package org.ntqqrev.saltify.api.context

/**
 * Represents an object bound to a context.
 */
interface Entity {
    /**
     * The context where the entity is bound to.
     */
    val ctx: Context
}