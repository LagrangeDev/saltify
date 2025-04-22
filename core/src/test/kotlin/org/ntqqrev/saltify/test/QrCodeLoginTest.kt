package org.ntqqrev.saltify.test

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.common.Keystore
import org.ntqqrev.saltify.operation.system.FetchQrCode
import org.ntqqrev.saltify.operation.system.QueryQrCodeState
import org.ntqqrev.saltify.packet.login.QrCodeState
import org.ntqqrev.saltify.util.UrlSignProvider
import java.lang.Thread.sleep

suspend fun main() {
    val signApiUrl = "https://sign.lagrangecore.org/api/sign/30366"
    val urlSignProvider = UrlSignProvider(signApiUrl)
    val appInfo = urlSignProvider.getAppInfo()
    val bot = BotContext(appInfo!!, Keystore.generateEmptyKeystore(), urlSignProvider)
    bot.ssoContext.connect()

    val fetchQrCodeResult = bot.callOperation(FetchQrCode)
    println("QR code URL: ${fetchQrCodeResult.qrCodeUrl}")

    while (true) {
        val qrCodeState = bot.callOperation(QueryQrCodeState)
        if (qrCodeState == QrCodeState.WaitingForConfirm) {
            println("User scanned the QR code")
        } else if (qrCodeState == QrCodeState.Confirmed) {
            break
        }
        sleep(3000)
    }
    println("QR code has been confirmed")
}