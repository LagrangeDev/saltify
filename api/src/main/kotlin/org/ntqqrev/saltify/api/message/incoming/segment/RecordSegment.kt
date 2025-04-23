package org.ntqqrev.saltify.api.message.incoming.segment

interface RecordSegment : ResourceLikeSegment {
    /**
     * The duration of the audio in seconds.
     */
    val duration: String
}