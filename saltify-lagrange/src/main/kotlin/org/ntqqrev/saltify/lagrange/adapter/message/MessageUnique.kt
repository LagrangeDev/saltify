package org.ntqqrev.saltify.lagrange.adapter.message

fun encodeMessageId(messageType: MessageType, peerUin: Long, sequence: Long) =
    "${messageType.type}:$peerUin:$sequence"

fun decodeMessageId(id: String): Triple<MessageType, Long, Long> {
    val (messageType, peerUin, sequence) = id.split(":", limit = 3)
    return Triple(
        when (messageType) {
            "1" -> MessageType.PRIVATE
            "2" -> MessageType.GROUP
            else -> throw IllegalArgumentException("Unknown message type: $messageType")
        },
        peerUin.toLong(),
        sequence.toLong(),
    )
}