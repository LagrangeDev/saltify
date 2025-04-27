package org.ntqqrev.saltify.lagrange.adapter

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.action.*
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.api.context.model.Friend
import org.ntqqrev.saltify.api.context.model.Group
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.adapter.cache.FriendCacheService
import org.ntqqrev.saltify.lagrange.adapter.cache.GroupCacheService
import org.ntqqrev.saltify.lagrange.operation.system.BotOnline
import org.ntqqrev.saltify.lagrange.operation.system.DoWtLogin
import org.ntqqrev.saltify.lagrange.operation.system.FetchQrCode
import org.ntqqrev.saltify.lagrange.operation.system.QueryQrCodeState
import org.ntqqrev.saltify.lagrange.packet.login.QrCodeState
import kotlin.io.path.writeBytes

private val logger = KotlinLogging.logger {  }

class LagrangeContext(
    val lagrange: BotContext,
    val init: LagrangeInit,
    val env: Environment,
    val channel: MutableSharedFlow<Event>,
    messageActionImpl: MessageAction,
    userActionImpl: UserAction,
    groupActionImpl: GroupAction,
    requestActionImpl: RequestAction,
    fileActionImpl: FileAction
) : Context, MessageAction by messageActionImpl, UserAction by userActionImpl, GroupAction by groupActionImpl,
    RequestAction by requestActionImpl, FileAction by fileActionImpl {

    private var instanceUin = 0L
    private var instanceState = Context.State.NEWLY_CREATED

    override val uin: Long
        get() = instanceUin
    override val state: Context.State
        get() = instanceState

    private val friendCacheService = FriendCacheService(this)
    private val groupCacheService = GroupCacheService(this)

    suspend fun qrCodeLogin() {
        logger.info { "Session is empty, using QR code login" }

        lagrange.keystore.clear()

        val fetchQrCodeResult = lagrange.callOperation(FetchQrCode)
        logger.info { "QR code URL: ${fetchQrCodeResult.qrCodeUrl}" }
        env.rootDataPath.resolve(qrCodeFileName).writeBytes(fetchQrCodeResult.qrCodePng)
        logger.info { "QR code saved to data/qrcode.png" }

        while (true) {
            val qrCodeState = lagrange.callOperation(QueryQrCodeState)
            logger.debug { "QrCodeState: ${qrCodeState.value}" }
            if (qrCodeState == QrCodeState.WaitingForConfirm) {
                logger.info { "User scanned the QR code" }
            } else if (qrCodeState.value == QrCodeState.Confirmed.value) {
                break
            }
            delay(3000)
        }
        logger.info { "QR code has been confirmed" }

        val loginSuccess = lagrange.callOperation(DoWtLogin)
        if (!loginSuccess)
            throw RuntimeException("QR code login failed")

        logger.info { "Credentials retrieved, trying online" }
        val onlineResult = lagrange.callOperation(BotOnline)
        if (!onlineResult) {
            instanceState = Context.State.ERROR_TERMINATED
            throw RuntimeException("Login failed")
        }
        // TODO: set instanceUin
    }

    suspend fun fastLogin() {
        logger.info { "Login with existing session" }
        val onlineResult = lagrange.callOperation(BotOnline)
        if (!onlineResult) {
            instanceState = Context.State.ERROR_TERMINATED
            throw RuntimeException("Login failed")
            // TODO: key exchange if session is expired
        }
    }

    override suspend fun start() {
        if (lagrange.keystore.d2.isEmpty())
            qrCodeLogin()
        else
            fastLogin()
        logger.info { "Logging in success" }
        instanceState = Context.State.RUNNING
    }

    override suspend fun getAllFriends(cacheFirst: Boolean): Iterable<Friend>
        = friendCacheService.getAll(cacheFirst)

    override suspend fun getFriend(friendUin: Long, cacheFirst: Boolean): Friend?
        = friendCacheService.get(friendUin, cacheFirst)

    override suspend fun getAllGroups(cacheFirst: Boolean): Iterable<Group>
        = groupCacheService.getAll(cacheFirst)

    override suspend fun getGroup(groupUin: Long, cacheFirst: Boolean): Group?
        = groupCacheService.get(groupUin, cacheFirst)

    override suspend fun stop() {
        lagrange.ssoContext.disconnect()
        instanceState = Context.State.DISPOSED
    }
}