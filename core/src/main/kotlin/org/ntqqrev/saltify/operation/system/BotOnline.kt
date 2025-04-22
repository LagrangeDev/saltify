package org.ntqqrev.saltify.operation.system

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.packet.common.DeviceInfo
import org.ntqqrev.saltify.packet.common.RegisterInfo
import org.ntqqrev.saltify.packet.common.RegisterInfoResponse
import org.ntqqrev.saltify.util.binary.pb
import org.ntqqrev.saltify.util.binary.toHex

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