package org.ntqqrev.saltify.api.context.message.outgoing.feature

import java.io.InputStream

interface VideoFeature {
    /**
     * Create a video segment with custom cover (if provided).
     */
    fun video(raw: InputStream, cover: InputStream?)
}