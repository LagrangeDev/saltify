package org.ntqqrev.saltify.api.message.outgoing.feature

interface VideoFeature {
    /**
     * Create a video segment with custom cover (if provided).
     */
    fun video(raw: ByteArray, cover: ByteArray?)
}