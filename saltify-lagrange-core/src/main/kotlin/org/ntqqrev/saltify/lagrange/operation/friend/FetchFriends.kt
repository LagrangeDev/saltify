package org.ntqqrev.saltify.lagrange.operation.friend

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.OidbOperation
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchFriendsRequest
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchFriendsResponse
import org.ntqqrev.saltify.lagrange.packet.oidb.QueryKey
import org.ntqqrev.saltify.lagrange.packet.oidb.UinBody
import org.ntqqrev.saltify.lagrange.util.binary.pb

object FetchFriends : OidbOperation<FetchFriends.Req, FetchFriends.Resp>(0xfd4, 1) {
    override fun buildOidb(bot: BotContext, payload: Req): ByteArray =
        OidbFetchFriendsRequest(
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