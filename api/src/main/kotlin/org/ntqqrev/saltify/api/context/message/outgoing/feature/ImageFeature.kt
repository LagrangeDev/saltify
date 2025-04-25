package org.ntqqrev.saltify.api.context.message.outgoing.feature

import org.ntqqrev.saltify.api.context.message.ImageSubType
import java.io.InputStream

interface ImageFeature {
    /**
     * Create an image segment.
     */
    fun image(raw: InputStream, subType: ImageSubType?, summary: String?)
}