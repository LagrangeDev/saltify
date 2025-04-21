package org.ntqqrev.saltify.common

import org.ntqqrev.saltify.packet.common.SsoSecureInfo

fun interface SignProvider {
    suspend fun sign(cmd: String, seq: Int, src: ByteArray): SsoSecureInfo
}