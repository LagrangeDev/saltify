package org.ntqqrev.saltify.api.message.outgoing.feature

import org.ntqqrev.saltify.api.message.ImageSubType

interface ImageFeature {
    /**
     * Create an image segment.
     */
    fun image(raw: kotlinx.io.Source, subType: ImageSubType?, summary: String?)
}