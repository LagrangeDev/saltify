package org.ntqqrev.saltify.operation.system

import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.operation.NoInputOperation
import org.ntqqrev.saltify.packet.common.DeviceInfo
import org.ntqqrev.saltify.packet.common.RegisterInfo
import org.ntqqrev.saltify.packet.common.RegisterInfoResponse
import org.ntqqrev.saltify.util.binary.toHex

object BotOnline : NoInputOperation<Boolean> {
    override val command = "trpc.qq_new_tech.status_svc.StatusService.Register"

    override fun build(bot: BotContext, payload: Unit): ByteArray = ProtoBuf.encodeToByteArray(
        RegisterInfo(
            guid = bot.keystore.guid.toHex(),
            currentVersion = bot.appInfo.currentVersion,
            device = DeviceInfo(
                user = bot.keystore.deviceName,
                os = bot.appInfo.kernel,
                osVer = "Windows 10.0.19042",
                osLower = bot.appInfo.vendorOs,
            )
        )
    )

    override fun parse(bot: BotContext, payload: ByteArray): Boolean
        = ProtoBuf.decodeFromByteArray<RegisterInfoResponse>(payload).message.contains("register success")
}