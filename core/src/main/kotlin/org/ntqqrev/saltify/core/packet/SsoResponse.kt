package org.ntqqrev.saltify.core.packet

internal class SsoResponse(
    val retCode: Int,
    val command: String,
    val response: ByteArray,
    val sequence: Int,
    val extra: String? = null
)
