package org.ntqqrev.saltify.test

import org.ntqqrev.saltify.BotContext
import org.ntqqrev.saltify.common.Keystore
import org.ntqqrev.saltify.operation.system.FetchQrCode
import org.ntqqrev.saltify.util.UrlSignProvider

suspend fun main() {
    val signApiUrl = "https://sign.lagrangecore.org/api/sign/30366"
    val urlSignProvider = UrlSignProvider(signApiUrl)
    val appInfo = urlSignProvider.getAppInfo()
    val bot = BotContext(appInfo!!, Keystore.generateEmptyKeystore(), urlSignProvider)
    bot.ssoContext.connect()
    val fetchQrCodeResult = bot.callOperation(FetchQrCode)
    println("QR code URL: ${fetchQrCodeResult.qrCodeUrl}")
}