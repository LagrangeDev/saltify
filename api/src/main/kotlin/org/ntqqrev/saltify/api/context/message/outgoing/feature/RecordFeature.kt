package org.ntqqrev.saltify.api.context.message.outgoing.feature

import kotlinx.io.Source

interface RecordFeature {
    /**
     * Create a record segment.
     */
    fun record(raw: Source)
}