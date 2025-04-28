package org.ntqqrev.saltify.lagrange.test

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.common.Keystore
import org.ntqqrev.saltify.lagrange.operation.system.BotOnline
import org.ntqqrev.saltify.lagrange.operation.system.DoWtLogin
import org.ntqqrev.saltify.lagrange.operation.system.FetchQrCode
import org.ntqqrev.saltify.lagrange.operation.system.QueryQrCodeState
import org.ntqqrev.saltify.lagrange.packet.login.QrCodeState
import kotlin.io.path.writeBytes

private val logger = KotlinLogging.logger {  }

fun main() = runBlocking(testContext) {
    val appInfo = urlSignProvider.getAppInfo()
    val bot = BotContext(
        appInfo!!,
        Keystore.generateEmptyKeystore(),
        urlSignProvider,
        coroutineContext
    )
    bot.ssoContext.connect()

    if (!dataPath.toFile().exists()) {
        dataPath.toFile().mkdirs()
    }

    val fetchQrCodeResult = bot.callOperation(FetchQrCode)
    logger.info { "QR code URL: ${fetchQrCodeResult.qrCodeUrl}" }
    launch {
        dataPath.resolve("qrcode.png").writeBytes(fetchQrCodeResult.qrCodePng)
        logger.info { "QR code saved to data/qrcode.png" }
    }

    while (true) {
        val qrCodeState = bot.callOperation(QueryQrCodeState)
        logger.info { "QrCodeState: ${qrCodeState.value}" }
        if (qrCodeState == QrCodeState.WaitingForConfirm) {
            logger.info { "User scanned the QR code" }
        } else if (qrCodeState.value == QrCodeState.Confirmed.value) {
            break
        }
        delay(3000)
    }
    logger.info { "QR code has been confirmed" }

    val loginSuccess = bot.callOperation(DoWtLogin)
    if (!loginSuccess) {
        logger.error { "Login failed" }
        return@runBlocking
    }
    launch {
        keystorePath.writeBytes(Json.encodeToString(bot.keystore).toByteArray())
        logger.info { "Keystore saved to data/keystore.json" }
    }
    logger.info { "Credentials retrieved, trying online" }

    val onlineResult = bot.callOperation(BotOnline)
    if (!onlineResult) {
        logger.error { "Login failed" }
        return@runBlocking
    }
    logger.info { "Login successful" }
    delay(Long.MAX_VALUE)
}