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
            field2 = 5,
            field3 = 2,
            body = OidbFetchGroupMembersRequest.Body(
                memberName = true,
                memberCard = true,
                level = true,
                field13 = true,
                field16 = true,
                specialTitle = true,
                field18 = true,
                field20 = true,
                field21 = true,
                joinTimestamp = true,
                lastMsgTimestamp = true,
                shutUpTimestamp = true,
                field103 = true,
                field104 = true,
                field105 = true,
                field106 = true,
                permission = true,
                field200 = true,
                field201 = true,
            ),
            token = payload.token,
        ).pb()

    override fun parseOidb(bot: BotContext, payload: ByteArray) =
        payload.pb<OidbFetchGroupMembersResponse>()

    class Req(
        val groupUin: Long,
        val token: String?
    )
}