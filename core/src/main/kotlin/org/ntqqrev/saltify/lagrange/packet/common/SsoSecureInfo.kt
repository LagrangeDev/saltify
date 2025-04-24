package org.ntqqrev.saltify.lagrange.packet.common

import kotlinx.serialization.Serializable

@Serializable
class SsoSecureInfo(
    val sign: ByteArray,
    val token: ByteArray,
    val extra: ByteArray,
)