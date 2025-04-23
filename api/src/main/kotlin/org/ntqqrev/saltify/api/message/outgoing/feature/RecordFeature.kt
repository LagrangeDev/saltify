package org.ntqqrev.saltify.api.message.outgoing.feature

interface RecordFeature {
    /**
     * Create a record segment.
     */
    fun record(raw: ByteArray)
}