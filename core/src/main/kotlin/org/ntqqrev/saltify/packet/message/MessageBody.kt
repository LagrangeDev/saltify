package org.ntqqrev.saltify.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class MessageBody(
    val richText: RichText,
    val msgContent: ByteArray,
    val msgEncryptContent: ByteArray,
)