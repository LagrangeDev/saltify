package org.ntqqrev.saltify.api.context.message.outgoing.feature

import kotlinx.io.Source
import org.ntqqrev.saltify.api.context.message.ImageSubType

interface ImageFeature {
    /**
     * Create an image segment.
     */
    fun image(raw: Source, subType: ImageSubType?, summary: String?)
}