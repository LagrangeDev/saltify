package org.ntqqrev.saltify

import org.ntqqrev.saltify.common.AppInfo
import org.ntqqrev.saltify.common.Keystore
import org.ntqqrev.saltify.common.SignProvider
import org.ntqqrev.saltify.operation.Operation
import org.ntqqrev.saltify.util.crypto.ecdh.ECDH
import org.ntqqrev.saltify.util.crypto.ecdh.EllipticCurve

class BotContext(
    val appInfo: AppInfo,
    val keystore: Keystore,
    val signProvider: SignProvider
) {
    internal val ecdh192 = ECDH(EllipticCurve.secp192k1)
    internal val ecdh256 = ECDH(EllipticCurve.prime256v1)

    suspend fun <T, R> callOperation(operation: Operation<T, R>, payload: T): R {
        val byteArray = operation.build(this, payload)
        // TODO: send packet by suspend function
        return operation.parse(this, byteArray)
    }
}