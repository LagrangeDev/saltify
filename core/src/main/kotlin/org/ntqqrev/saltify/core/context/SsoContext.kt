package org.ntqqrev.saltify.core.context

import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.network.selector.*
import io.ktor.network.sockets.*
import io.ktor.utils.io.*
import io.ktor.utils.io.core.writeFully
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.io.Buffer
import kotlinx.io.readByteArray
import kotlinx.io.readUInt
import kotlinx.serialization.ExperimentalSerializationApi
import org.ntqqrev.saltify.core.BotContext
import org.ntqqrev.saltify.core.common.SignResult
import org.ntqqrev.saltify.core.packet.SsoResponse
import org.ntqqrev.saltify.core.packet.common.SsoReservedFields
import org.ntqqrev.saltify.core.packet.common.SsoSecureInfo
import org.ntqqrev.saltify.core.util.binary.*
import org.ntqqrev.saltify.core.util.crypto.TEA
import org.ntqqrev.saltify.core.util.generateTrace
import java.util.concurrent.ConcurrentHashMap
import java.util.zip.InflaterInputStream
import kotlin.io.use
import kotlin.random.Random

internal class SsoContext(bot: BotContext) : Context(bot) {
    private var sequence = Random.nextInt(0x10000, 0x20000)
    private val host = "msfwifi.3g.qq.com"
    private val port = 8080

    private val selectorManager = ActorSelectorManager(Dispatchers.IO)
    private val socket = aSocket(selectorManager).tcp()
    private lateinit var input: ByteReadChannel
    private lateinit var output: ByteWriteChannel
    private val pending = ConcurrentHashMap<Int, CompletableDeferred<SsoResponse>>()
    private val headerLength = 4
    var connected = false

    val signRequiredCommand = setOf(
        "trpc.o3.ecdh_access.EcdhAccess.SsoEstablishShareKey",
        "trpc.o3.ecdh_access.EcdhAccess.SsoSecureAccess",
        "trpc.o3.report.Report.SsoReport",
        "MessageSvc.PbSendMsg",
        "wtlogin.trans_emp",
        "wtlogin.login",
        "trpc.login.ecdh.EcdhService.SsoKeyExchange",
        "trpc.login.ecdh.EcdhService.SsoNTLoginPasswordLogin",
        "trpc.login.ecdh.EcdhService.SsoNTLoginEasyLogin",
        "trpc.login.ecdh.EcdhService.SsoNTLoginPasswordLoginNewDevice",
        "trpc.login.ecdh.EcdhService.SsoNTLoginEasyLoginUnusualDevice",
        "trpc.login.ecdh.EcdhService.SsoNTLoginPasswordLoginUnusualDevice",
        "OidbSvcTrpcTcp.0x11ec_1",
        "OidbSvcTrpcTcp.0x758_1", // create a group
        "OidbSvcTrpcTcp.0x7c1_1",
        "OidbSvcTrpcTcp.0x7c2_5", // request friend
        "OidbSvcTrpcTcp.0x10db_1",
        "OidbSvcTrpcTcp.0x8a1_7", // request group
        "OidbSvcTrpcTcp.0x89a_0",
        "OidbSvcTrpcTcp.0x89a_15",
        "OidbSvcTrpcTcp.0x88d_0", // fetch group detail
        "OidbSvcTrpcTcp.0x88d_14",
        "OidbSvcTrpcTcp.0x112a_1",
        "OidbSvcTrpcTcp.0x587_74",
        "OidbSvcTrpcTcp.0x1100_1",
        "OidbSvcTrpcTcp.0x1102_1",
        "OidbSvcTrpcTcp.0x1103_1",
        "OidbSvcTrpcTcp.0x1107_1",
        "OidbSvcTrpcTcp.0x1105_1",
        "OidbSvcTrpcTcp.0xf88_1",
        "OidbSvcTrpcTcp.0xf89_1",
        "OidbSvcTrpcTcp.0xf57_1",
        "OidbSvcTrpcTcp.0xf57_106",
        "OidbSvcTrpcTcp.0xf57_9",
        "OidbSvcTrpcTcp.0xf55_1",
        "OidbSvcTrpcTcp.0xf67_1",
        "OidbSvcTrpcTcp.0xf67_5",
        "OidbSvcTrpcTcp.0x6d9_4"
    )

    private val logger = KotlinLogging.logger { }

    suspend fun connect() {
        val s = socket.connect(host, port)
        input = s.openReadChannel()
        output = s.openWriteChannel(autoFlush = true)
        logger.info { "Connected to $host:$port" }
        connected = true

        CoroutineScope(Dispatchers.IO).launch {
            handleReceiveLoop()
        }
    }

    suspend fun disconnect() {
        input.cancel()
        output.flushAndClose()
        connected = false
    }

    suspend fun sendPacket(cmd: String, payload: ByteArray): SsoResponse {
        val sequence = this.sequence++
        val sso = buildSso(cmd, payload, sequence)
        val service = buildService(sso)

        val deferred = CompletableDeferred<SsoResponse>()
        pending[sequence] = deferred

        output.writePacket(service)
        logger.debug { "Sent packet '$cmd' with sequence $sequence" }

        return deferred.await()
    }

    private suspend fun handleReceiveLoop() {
        while (connected) {
            try {
                val header = input.readByteArray(headerLength)
                val packetLength = header.readUInt32BE(0)
                val packet = input.readByteArray(packetLength.toInt() - 4)
                val service = parseService(packet)
                val sso = parseSso(service)
                logger.debug { "Received packet '${sso.command}' with sequence ${sso.sequence} (retcode=${sso.retCode})" }
                pending.remove(sso.sequence).also {
                    if (it != null) {
                        it.complete(sso)
                    } else {
                        // Handle incoming packets
                    }
                }
            } catch (e: Exception) {
                logger.error(e) { "Error receiving packet" }
            }
        }
    }

    private fun buildService(sso: ByteArray): Buffer {
        val packet = Buffer()

        packet.barrier(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX) {
            writeInt(12)
            writeByte(if (bot.keystore.d2.isEmpty()) 2 else 1)
            writeBytes(bot.keystore.d2, Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
            writeByte(0) // unknown
            writeString(bot.keystore.uin.toString(), Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
            writeBytes(TEA.encrypt(sso, bot.keystore.d2Key))
        }

        return packet
    }

    private suspend fun buildSso(command: String, payload: ByteArray, sequence: Int): ByteArray {
        val packet = Buffer()
        val ssoReserved = buildSsoReserved(command, payload, sequence)

        packet.barrier(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX) {
            writeInt(sequence)
            writeInt(bot.appInfo.subAppId)
            writeInt(2052)  // locale id
            writeFully("020000000000000000000000".fromHex())
            writeBytes(bot.keystore.a2, Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
            writeString(command, Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
            writeBytes(ByteArray(0), Prefix.UINT_32 or Prefix.INCLUDE_PREFIX) // unknown
            writeString(bot.keystore.guid.toHex(), Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
            writeBytes(ByteArray(0), Prefix.UINT_32 or Prefix.INCLUDE_PREFIX) // unknown
            writeString(bot.appInfo.currentVersion, Prefix.UINT_16 or Prefix.INCLUDE_PREFIX)
            writeBytes(ssoReserved, Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
        }

        packet.writeBytes(payload, Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)

        return packet.readByteArray()
    }

    @OptIn(ExperimentalSerializationApi::class)
    private suspend fun buildSsoReserved(command: String, payload: ByteArray, sequence: Int): ByteArray {
        var signResult: SignResult? = null

        if (signRequiredCommand.contains(command)) {
            signResult = bot.signProvider.sign(command, sequence, payload)
        }

        return SsoReservedFields(
            trace = generateTrace(),
            uid = bot.keystore.uid,
            secureInfo = if (signResult != null) SsoSecureInfo(
                sign = signResult.sign,
                token = signResult.token,
                extra = signResult.extra
            ) else null
        ).pb()
    }

    private fun parseSso(packet: ByteArray): SsoResponse {
        val reader = Buffer().apply {
            write(packet, endIndex = 0 + packet.size)
        }
        /* val headLen = */ reader.readUInt()
        val sequence = reader.readUInt()
        val retCode = reader.readInt()
        val extra = reader.readPrefixedString(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
        val command = reader.readPrefixedString(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
        /* val msgCookie = */ reader.readPrefixedBytes(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)
        val isCompressed = reader.readInt() == 1
        /* val reserveField = */ reader.readPrefixedBytes(Prefix.UINT_32)
        var payload = reader.readPrefixedBytes(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)

        if (isCompressed) {
            InflaterInputStream(payload.inputStream()).use {
                payload = it.readBytes()
            }
        }

        return if (retCode == 0) {
            SsoResponse(retCode, command, payload, sequence.toInt())
        } else {
            SsoResponse(retCode, command, payload, sequence.toInt(), extra)
        }
    }

    private fun parseService(raw: ByteArray): ByteArray {
        val reader = Buffer().apply {
            write(raw, endIndex = 0 + raw.size)
        }

        val protocol = reader.readUInt()
        val authFlag = reader.readByte()
        /* val flag = */ reader.readByte()
        /* val uin = */ reader.readPrefixedString(Prefix.UINT_32 or Prefix.INCLUDE_PREFIX)

        if (protocol != 12u && protocol != 13u) throw Exception("Unrecognized protocol: $protocol")

        val encrypted = reader.readByteArray()
        return when (authFlag) {
            0.toByte() -> encrypted
            1.toByte() -> TEA.decrypt(encrypted, bot.keystore.d2Key)
            2.toByte() -> TEA.decrypt(encrypted, ByteArray(16))
            else -> throw Exception("Unrecognized auth flag: $authFlag")
        }
    }
}