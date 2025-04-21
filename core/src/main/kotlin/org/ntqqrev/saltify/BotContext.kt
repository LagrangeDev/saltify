package org.ntqqrev.saltify

import org.ntqqrev.saltify.common.AppInfo
import org.ntqqrev.saltify.common.Keystore
import org.ntqqrev.saltify.common.SignProvider
import org.ntqqrev.saltify.context.SsoContext
import org.ntqqrev.saltify.context.WtLoginContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.operation.Operation
import org.ntqqrev.saltify.util.crypto.ecdh.ECDH
import org.ntqqrev.saltify.util.crypto.ecdh.EllipticCurve

class BotContext(
    val appInfo: AppInfo,
    val keystore: Keystore,
    val signProvider: SignProvider
) {
    internal val ssoContext = SsoContext(this)
    internal val wtLoginContext = WtLoginContext(this)

    internal val ecdh192 = ECDH(EllipticCurve.secp192k1)
    internal val ecdh256 = ECDH(EllipticCurve.prime256v1)

    suspend fun <T, R> callOperation(operation: Operation<T, R>, payload: T): R {
        val byteArray = operation.build(this, payload)
        val resp = ssoContext.sendPacket(
            operation.command,
            operation.build(this, payload)
        )
        if (resp.retCode != 0) {
            throw Exception("Error when calling operation: ${resp.retCode} ${resp.extra}")
        }
        return operation.parse(this, byteArray)
    }

    suspend fun <R> callOperation(operation: NoInputOperation<R>): R {
        return callOperation(operation, Unit)
    }
}