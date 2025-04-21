package org.ntqqrev.saltify.common

fun interface SignProvider {
    suspend fun sign(cmd: String, seq: Int, src: ByteArray): SignResult
}

class SignResult(
    val sign: ByteArray,
    val token: ByteArray,
    val extra: ByteArray,
)