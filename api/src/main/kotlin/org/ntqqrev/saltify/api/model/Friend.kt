package org.ntqqrev.saltify.api.model

interface Friend : User {
    /**
     * The category which the friend belongs to.
     */
    val category: Int
}