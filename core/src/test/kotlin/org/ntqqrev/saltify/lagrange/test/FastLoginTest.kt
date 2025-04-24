package org.ntqqrev.saltify.lagrange.test

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.common.Keystore
import org.ntqqrev.saltify.lagrange.operation.system.BotOnline

private val logger = KotlinLogging.logger {  }

fun main() = runBlocking(testContext) {
    val appInfo = urlSignProvider.getAppInfo()
    val keystoreFile = keystorePath.toFile()
    if (!keystoreFile.exists()) {
        logger.error { "Keystore file not found, please run QrCodeLoginTest first" }
        return@runBlocking
    }

    val keystore = Json.decodeFromStream<Keystore>(keystoreFile.inputStream())
    val bot = BotContext(
        appInfo!!,
        keystore,
        urlSignProvider,
        Dispatchers.IO + CoroutineName("FastLoginTest")
    )
    bot.ssoContext.connect()

    val onlineResult = bot.callOperation(BotOnline)
    if (!onlineResult) {
        logger.error { "Login failed" }
        return@runBlocking
    }
    logger.info { "Login successful" }

    delay(Long.MAX_VALUE)
}