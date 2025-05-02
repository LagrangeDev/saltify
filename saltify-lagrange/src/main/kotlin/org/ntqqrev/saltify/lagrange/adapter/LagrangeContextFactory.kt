package org.ntqqrev.saltify.lagrange.adapter

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.serialization.json.Json
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.ContextFactory
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.adapter.action.*
import org.ntqqrev.saltify.lagrange.common.AppInfo
import org.ntqqrev.saltify.lagrange.common.Keystore
import org.ntqqrev.saltify.lagrange.util.UrlSignProvider
import kotlin.io.path.exists
import kotlin.io.path.readText
import kotlin.io.path.writeText

private val logger = KotlinLogging.logger { }

object LagrangeContextFactory : ContextFactory<LagrangeInit> {
    val fallbackAppInfo = AppInfo(
        os = "Linux",
        kernel = "Linux",
        vendorOs = "linux",
        currentVersion = "3.2.15-30366",
        miscBitmap = 32764,
        ptVersion = "2.0.0",
        ssoVersion = 19,
        packageName = "com.tencent.qq",
        wtLoginSdk = "nt.wtlogin.0.0.1",
        appId = 1600001615,
        subAppId = 537258424,
        appClientVersion = 30366,
        mainSigMap = 169742560,
        subSigMap = 0,
        ntLoginType = 1
    )

    override suspend fun createContext(
        init: LagrangeInit,
        env: Environment,
        flow: MutableSharedFlow<Event>
    ): LagrangeContext {
        val signProvider = UrlSignProvider(init.signApiUrl)
        val appInfo = signProvider.getAppInfo() ?: {
            logger.warn { "Failed to get app info from sign API, using fallback app info" }
            fallbackAppInfo
        }()

        var keystore: Keystore
        val keystorePath = env.rootDataPath.resolve(keystoreFileName)
        if (!keystorePath.exists()) {
            logger.debug { "Generating new keystore" }
            keystore = Keystore.generateEmptyKeystore()
            keystorePath.writeText(Json.encodeToString(keystore))
        } else {
            logger.debug { "Using existing session" }
            keystore = Json.decodeFromString(keystorePath.readText())
        }

        val lagrange = BotContext(appInfo, keystore, signProvider, env.scope)
        lagrange.ssoContext.connect()

        return LagrangeContext(
            lagrange,
            init,
            env,
            flow,
            MessageActionImpl(lagrange),
            UserActionImpl(lagrange),
            GroupActionImpl(lagrange),
            RequestActionImpl(lagrange),
            FileActionImpl(lagrange)
        )
    }
}