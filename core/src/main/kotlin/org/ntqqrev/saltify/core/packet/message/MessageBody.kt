package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class MessageBody(
    val richText: RichText,
    val msgContent: ByteArray,
    val msgEncryptContent: ByteArray,
)