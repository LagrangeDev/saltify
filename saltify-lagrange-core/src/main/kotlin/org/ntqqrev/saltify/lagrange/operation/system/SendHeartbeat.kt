package org.ntqqrev.saltify.lagrange.operation.system

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.NoInputOperation
import org.ntqqrev.saltify.lagrange.packet.common.SsoHeartbeat
import org.ntqqrev.saltify.lagrange.util.binary.pb

object SendHeartbeat : NoInputOperation<Unit> {
    override val command = "trpc.qq_new_tech.status_svc.StatusService.SsoHeartBeat"

    override fun build(bot: BotContext, payload: Unit) = SsoHeartbeat().pb()

    override fun parse(bot: BotContext, payload: ByteArray) = Unit
}