package org.ntqqrev.saltify.api.context.message.outgoing.feature

import java.io.InputStream

interface RecordFeature {
    /**
     * Create a record segment.
     */
    fun record(raw: InputStream)
}