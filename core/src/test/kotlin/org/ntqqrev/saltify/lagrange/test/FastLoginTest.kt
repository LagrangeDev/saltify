package org.ntqqrev.saltify.lagrange.test

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.common.Keystore
import org.ntqqrev.saltify.lagrange.operation.system.BotOnline

private val logger = KotlinLogging.logger {  }

suspend fun main() = coroutineScope {
    val appInfo = urlSignProvider.getAppInfo()
    val keystoreFile = keystorePath.toFile()
    if (!keystoreFile.exists()) {
        logger.error { "Keystore file not found, please run QrCodeLoginTest first" }
        return@coroutineScope
    }

    val keystore = Json.decodeFromStream<Keystore>(keystoreFile.inputStream())
    val bot = BotContext(appInfo!!, keystore, urlSignProvider)
    bot.ssoContext.connect()

    val onlineResult = bot.callOperation(BotOnline)
    if (!onlineResult) {
        logger.error { "Login failed" }
        return@coroutineScope
    }
    logger.info { "Login successful" }

    delay(Long.MAX_VALUE)
}