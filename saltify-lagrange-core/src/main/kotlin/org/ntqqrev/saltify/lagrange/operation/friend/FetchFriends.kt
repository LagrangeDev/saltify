package org.ntqqrev.saltify.lagrange.operation.friend

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.OidbOperation
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchFriendsRequest
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchFriendsResponse
import org.ntqqrev.saltify.lagrange.packet.oidb.UinBody
import org.ntqqrev.saltify.lagrange.util.binary.pb

object FetchFriends : OidbOperation<FetchFriends.Req, FetchFriends.Resp>(0xfd4, 1) {
    override fun buildOidb(bot: BotContext, payload: Req): ByteArray =
        OidbFetchFriendsRequest(
            friendCount = 300,
            body = mapOf(
                1 to OidbFetchFriendsRequest.NumberList(
                    numbers = listOf(
                        QueryKey.SIGNATURE.value,
                        QueryKey.REMARK.value,
                        QueryKey.NICKNAME.value,
                        QueryKey.QID.value,
                    )
                ),
                4 to OidbFetchFriendsRequest.NumberList(
                    numbers = listOf(
                        QueryKey.UNKNOWN_100.value,
                        QueryKey.UNKNOWN_101.value,
                        QueryKey.SIGNATURE.value,
                    )
                )
            ),
            nextUin = UinBody(payload.nextUin)
        ).pb()

    override fun parseOidb(bot: BotContext, payload: ByteArray): Resp {
        val rawResp = payload.pb<OidbFetchFriendsResponse>()
        return Resp(
            entries = rawResp.friends.map { entry ->
                val properties = entry.additional[1]?.properties ?: emptyMap()
                Entry(
                    uin = entry.uin,
                    uid = entry.uid,
                    nickname = properties[QueryKey.NICKNAME.value],
                    remark = properties[QueryKey.REMARK.value],
                    signature = properties[QueryKey.SIGNATURE.value],
                    qid = properties[QueryKey.QID.value],
                    category = entry.category ?: 0,
                )
            },
            categories = rawResp.categories.associate { it.id to it.name },
            nextUin = rawResp.next?.uin,
        )
    }

    @JvmInline
    value class QueryKey(val value: Int) {
        companion object {
            val UNKNOWN_100 = QueryKey(100)
            val UNKNOWN_101 = QueryKey(101)
            val SIGNATURE = QueryKey(102)
            val REMARK = QueryKey(103)
            val NICKNAME = QueryKey(20002)
            val QID = QueryKey(27394)
        }
    }

    class Req(
        val nextUin: Long?,
    )

    class Resp(
        val entries: List<Entry>,
        val categories: Map<Int, String>,
        val nextUin: Long?
    )

    class Entry(
        val uin: Long,
        val uid: String,
        val nickname: String?,
        val remark: String?,
        val signature: String?,
        val qid: String?,
        val category: Int,
    )
}