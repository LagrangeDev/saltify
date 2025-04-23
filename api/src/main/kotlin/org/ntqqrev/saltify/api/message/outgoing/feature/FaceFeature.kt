package org.ntqqrev.saltify.api.message.outgoing.feature

interface FaceFeature {
    /**
     * Create a face segment with the given face ID.
     */
    fun face(id: String)
}