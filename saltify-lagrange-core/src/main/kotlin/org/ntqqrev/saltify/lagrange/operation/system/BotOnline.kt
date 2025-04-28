package org.ntqqrev.saltify.lagrange.operation.system

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.NoInputOperation
import org.ntqqrev.saltify.lagrange.packet.common.DeviceInfo
import org.ntqqrev.saltify.lagrange.packet.common.RegisterInfo
import org.ntqqrev.saltify.lagrange.packet.common.RegisterInfoResponse
import org.ntqqrev.saltify.lagrange.util.binary.pb
import org.ntqqrev.saltify.lagrange.util.binary.toHex

object BotOnline : NoInputOperation<Boolean> {
    override val command = "trpc.qq_new_tech.status_svc.StatusService.Register"

    override fun build(bot: BotContext, payload: Unit): ByteArray = RegisterInfo(
        guid = bot.keystore.guid.toHex(),
        currentVersion = bot.appInfo.currentVersion,
        device = DeviceInfo(
            user = bot.keystore.deviceName,
            os = bot.appInfo.kernel,
            osVer = "Windows 10.0.19042",
            osLower = bot.appInfo.vendorOs,
        )
    ).pb()

    override fun parse(bot: BotContext, payload: ByteArray): Boolean
        = payload.pb<RegisterInfoResponse>().message.contains("register success")
}