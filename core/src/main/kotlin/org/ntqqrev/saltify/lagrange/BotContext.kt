package org.ntqqrev.saltify.lagrange

import org.ntqqrev.saltify.lagrange.common.AppInfo
import org.ntqqrev.saltify.lagrange.common.Keystore
import org.ntqqrev.saltify.lagrange.common.SignProvider
import org.ntqqrev.saltify.lagrange.context.SsoContext
import org.ntqqrev.saltify.lagrange.context.WtLoginContext
import org.ntqqrev.saltify.lagrange.exception.OperationCallException
import org.ntqqrev.saltify.lagrange.operation.NoInputOperation
import org.ntqqrev.saltify.lagrange.operation.Operation
import org.ntqqrev.saltify.lagrange.util.crypto.ecdh.ECDH
import org.ntqqrev.saltify.lagrange.util.crypto.ecdh.EllipticCurve
import kotlin.coroutines.CoroutineContext

class BotContext(
    val appInfo: AppInfo,
    val keystore: Keystore,
    val signProvider: SignProvider,
    val parentCoroutineContext: CoroutineContext
) {
    val ssoContext = SsoContext(this)
    val wtLoginContext = WtLoginContext(this)

    internal val ecdh192 = ECDH(EllipticCurve.secp192k1)
    internal val ecdh256 = ECDH(EllipticCurve.prime256v1)

    suspend fun <T, R> callOperation(operation: Operation<T, R>, payload: T): R {
        val byteArray = operation.build(this, payload)
        val resp = ssoContext.sendPacket(operation.command, byteArray)
        if (resp.retCode != 0) {
            throw OperationCallException(
                operation.command,
                resp.retCode,
                resp.extra ?: ""
            )
        }
        return operation.parse(this, resp.response)
    }

    suspend fun <R> callOperation(operation: NoInputOperation<R>): R {
        return callOperation(operation, Unit)
    }
}