package org.ntqqrev.saltify.lagrange.operation

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.exception.OidbCallException
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbRequest
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbResponse
import org.ntqqrev.saltify.lagrange.util.binary.pb
import org.ntqqrev.saltify.lagrange.util.binary.toHex

abstract class OidbOperation<T, R>(
    val cmd: Int,
    val subCmd: Int,
    val reserve: Boolean = false
) : Operation<T, R> {
    override val command: String = "OidbSvcTrpcTcp.0x${cmd.toString(16)}_$subCmd"

    abstract fun buildOidb(bot: BotContext, payload: T): ByteArray
    abstract fun parseOidb(bot: BotContext, payload: ByteArray): R

    override fun build(bot: BotContext, payload: T): ByteArray =
        OidbRequest(cmd, subCmd, buildOidb(bot, payload), reserve).pb()

    override fun parse(bot: BotContext, payload: ByteArray): R {
        val oidbResponse = payload.pb<OidbResponse>()
        if (oidbResponse.retCode != 0) {
            throw OidbCallException(cmd, subCmd, oidbResponse.retCode, oidbResponse.errorMsg ?: "")
        }
        return parseOidb(bot, oidbResponse.payload!!)
    }
}