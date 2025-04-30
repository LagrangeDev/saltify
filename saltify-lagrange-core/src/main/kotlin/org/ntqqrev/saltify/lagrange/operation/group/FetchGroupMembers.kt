package org.ntqqrev.saltify.lagrange.operation.group

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.OidbOperation
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupMembersRequest
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupMembersResponse
import org.ntqqrev.saltify.lagrange.util.binary.pb

object FetchGroupMembers :
    OidbOperation<FetchGroupMembers.Req, OidbFetchGroupMembersResponse>(0xfe7, 3) {
    override fun buildOidb(bot: BotContext, payload: Req): ByteArray =
        OidbFetchGroupMembersRequest(
            groupUin = payload.groupUin,
            token = payload.token,
        ).pb()

    override fun parseOidb(bot: BotContext, payload: ByteArray) =
        payload.pb<OidbFetchGroupMembersResponse>()

    class Req(
        val groupUin: Long,
        val token: String?
    )
}