package org.ntqqrev.saltify.api.message.outgoing.feature

interface TextFeature {
    /**
     * Create a text segment.
     */
    fun text(text: String)
}