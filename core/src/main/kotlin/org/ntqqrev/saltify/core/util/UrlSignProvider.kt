package org.ntqqrev.saltify.core.util

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.ntqqrev.saltify.core.common.AppInfo
import org.ntqqrev.saltify.core.common.SignProvider
import org.ntqqrev.saltify.core.common.SignResult
import org.ntqqrev.saltify.core.util.binary.fromHex
import org.ntqqrev.saltify.core.util.binary.toHex

class UrlSignProvider(val url: String) : SignProvider {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun sign(cmd: String, seq: Int, src: ByteArray): SignResult {
        val value = runBlocking {
            client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(UrlSignRequest(cmd, seq, src.toHex()))
            }.body<UrlSignResponse>()
        }.value
        return SignResult(value.sign.fromHex(), value.token.fromHex(), value.extra.fromHex())
    }

    fun getAppInfo(): AppInfo? {
        return runBlocking {
            val response = client.get("$url/appinfo")
            if (response.status == HttpStatusCode.OK) {
                return@runBlocking response.body<AppInfo>()
            } else {
                return@runBlocking null
            }
        }
    }
}

@Serializable
private data class UrlSignRequest(
    @SerialName("cmd") val cmd: String,
    @SerialName("seq") val seq: Int,
    @SerialName("src") val srcHex: String
)

@Serializable
private data class UrlSignResponse(
    val platform: String,
    val version: String,
    val value: UrlSignValue
)

@Serializable
private data class UrlSignValue(
    val sign: String,
    val token: String,
    val extra: String
)