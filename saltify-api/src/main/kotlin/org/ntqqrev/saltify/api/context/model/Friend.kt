package org.ntqqrev.saltify.api.context.model

interface Friend : User {
    /**
     * The category which the friend belongs to.
     */
    val category: Int
}