package org.ntqqrev.saltify.lagrange.adapter

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.ntqqrev.saltify.api.Environment
import org.ntqqrev.saltify.api.context.Context
import org.ntqqrev.saltify.api.context.action.*
import org.ntqqrev.saltify.api.context.event.Event
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.adapter.action.*
import org.ntqqrev.saltify.lagrange.adapter.cache.FriendCacheService
import org.ntqqrev.saltify.lagrange.adapter.cache.GroupCacheService
import org.ntqqrev.saltify.lagrange.adapter.event.MessagePushEventProcessor
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeFriend
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroup
import org.ntqqrev.saltify.lagrange.adapter.model.LagrangeGroupMember
import org.ntqqrev.saltify.lagrange.event.MessagePushEvent
import org.ntqqrev.saltify.lagrange.operation.system.BotOnline
import org.ntqqrev.saltify.lagrange.operation.system.DoWtLogin
import org.ntqqrev.saltify.lagrange.operation.system.FetchQrCode
import org.ntqqrev.saltify.lagrange.operation.system.QueryQrCodeState
import org.ntqqrev.saltify.lagrange.packet.login.QrCodeState
import kotlin.io.path.writeBytes
import kotlin.io.path.writeText

private val logger = KotlinLogging.logger { }

class LagrangeContext(
    val lagrange: BotContext,
    val init: LagrangeInit,
    val env: Environment,
    val channel: MutableSharedFlow<Event>,
    messageActionImpl: MessageActionImpl,
    userActionImpl: UserActionImpl,
    groupActionImpl: GroupActionImpl,
    requestActionImpl: RequestActionImpl,
    fileActionImpl: FileActionImpl
) : Context, MessageAction by messageActionImpl, UserAction by userActionImpl, GroupAction by groupActionImpl,
    RequestAction by requestActionImpl, FileAction by fileActionImpl {

    init {
        messageActionImpl.outerContext = this
        userActionImpl.outerContext = this
        groupActionImpl.outerContext = this
        requestActionImpl.outerContext = this
        fileActionImpl.outerContext = this
    }
    private var instanceUin = 0L
    private var instanceState = Context.State.NEWLY_CREATED

    override val uin: Long
        get() = instanceUin
    override val state: Context.State
        get() = instanceState

    private val friendCacheService = FriendCacheService(this)
    private val groupCacheService = GroupCacheService(this)

    private val messagePushEventProcessor = MessagePushEventProcessor(this)

    suspend fun qrCodeLogin() {
        logger.info { "Session is empty, using QR code login" }

        lagrange.keystore.clear()

        val fetchQrCodeResult = lagrange.callOperation(FetchQrCode)
        logger.info { "QR code URL: ${fetchQrCodeResult.qrCodeUrl}" }
        env.scope.launch {
            env.rootDataPath.resolve(qrCodeFileName).writeBytes(fetchQrCodeResult.qrCodePng)
            logger.info { "QR code saved to data/qrcode.png" }
        }

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
        if (!loginSuccess) {
            instanceState = Context.State.ERROR_TERMINATED
            throw RuntimeException("QR code login failed")
        }

        logger.info { "Credentials retrieved, trying online" }
        env.scope.launch {
            env.rootDataPath.resolve(keystoreFileName)
                .writeText(Json.encodeToString(lagrange.keystore))
        }

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

        env.scope.launch {
            lagrange.eventFlow.collect { event ->
                when (event) {
                    is MessagePushEvent -> messagePushEventProcessor.process(event)
                }
            }
        }
    }

    override suspend fun getLoginInfo(): Pair<Long, String> = Pair(uin, "" /* TODO */)

    override suspend fun getAllFriends(cacheFirst: Boolean): Iterable<LagrangeFriend> =
        friendCacheService.getAll(cacheFirst)

    override suspend fun getFriend(friendUin: Long, cacheFirst: Boolean): LagrangeFriend? =
        friendCacheService.get(friendUin, cacheFirst)

    override suspend fun getAllGroups(cacheFirst: Boolean): Iterable<LagrangeGroup> =
        groupCacheService.getAll(cacheFirst)

    override suspend fun getGroup(groupUin: Long, cacheFirst: Boolean): LagrangeGroup? =
        groupCacheService.get(groupUin, cacheFirst)

    override suspend fun getAllGroupMembers(groupUin: Long, cacheFirst: Boolean): Iterable<LagrangeGroupMember> =
        getGroup(groupUin)?.groupMemberCacheService?.getAll(cacheFirst) ?: emptyList()

    override suspend fun getGroupMember(groupUin: Long, memberUin: Long, cacheFirst: Boolean): LagrangeGroupMember? =
        getGroup(groupUin)?.groupMemberCacheService?.get(memberUin, cacheFirst)

    override suspend fun stop() {
        lagrange.ssoContext.disconnect()
        instanceState = Context.State.DISPOSED
    }
}