package org.ntqqrev.saltify.test

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.common.Keystore
import org.ntqqrev.saltify.operation.system.FetchQrCode
import org.ntqqrev.saltify.operation.system.QueryQrCodeState
import org.ntqqrev.saltify.packet.login.QrCodeState
import org.ntqqrev.saltify.util.UrlSignProvider
import org.slf4j.LoggerFactory
import kotlin.io.path.Path
import kotlin.io.path.writeBytes

val logger = LoggerFactory.getLogger("Test")

suspend fun main() = coroutineScope {
    val signApiUrl = "https://sign.lagrangecore.org/api/sign/30366"
    val urlSignProvider = UrlSignProvider(signApiUrl)
    val appInfo = urlSignProvider.getAppInfo()
    val bot = BotContext(appInfo!!, Keystore.generateEmptyKeystore(), urlSignProvider)
    bot.ssoContext.connect()

    val dataPath = Path("data")
    if (!dataPath.toFile().exists()) {
        dataPath.toFile().mkdirs()
    }

    val fetchQrCodeResult = bot.callOperation(FetchQrCode)
    logger.info("QR code URL: ${fetchQrCodeResult.qrCodeUrl}")
    launch {
        dataPath.resolve("qrcode.png").writeBytes(fetchQrCodeResult.qrCodePng)
        logger.info("QR code saved to data/qrcode.png")
    }

    while (true) {
        val qrCodeState = bot.callOperation(QueryQrCodeState)
        logger.info("QrCodeState: ${qrCodeState.value}")
        if (qrCodeState == QrCodeState.WaitingForConfirm) {
            logger.info("User scanned the QR code")
        } else if (qrCodeState.value == QrCodeState.Confirmed.value) {
            break
        }
        delay(3000)
    }
    logger.info("QR code has been confirmed")
}