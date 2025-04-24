package org.ntqqrev.saltify.api.context.message.outgoing.feature

import kotlinx.io.Source

interface VideoFeature {
    /**
     * Create a video segment with custom cover (if provided).
     */
    fun video(raw: Source, cover: Source?)
}