package org.ntqqrev.saltify.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class SsoSecureInfo(
    val sign: ByteArray,
    val token: ByteArray,
    val extra: ByteArray,
)