package org.ntqqrev.saltify.api.message.outgoing.feature

interface VideoFeature {
    /**
     * Create a video segment with custom cover (if provided).
     */
    fun video(raw: kotlinx.io.Source, cover: kotlinx.io.Source?)
}