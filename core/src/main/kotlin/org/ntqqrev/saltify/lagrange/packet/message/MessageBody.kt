package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class MessageBody(
    val richText: RichText,
    val msgContent: ByteArray,
    val msgEncryptContent: ByteArray,
)