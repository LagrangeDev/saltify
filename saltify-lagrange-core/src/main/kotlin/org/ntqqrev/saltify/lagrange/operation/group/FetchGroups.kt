package org.ntqqrev.saltify.lagrange.operation.group

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.NoInputOidbOperation
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupsRequest
import org.ntqqrev.saltify.lagrange.packet.oidb.OidbFetchGroupsResponse
import org.ntqqrev.saltify.lagrange.util.binary.pb

object FetchGroups : NoInputOidbOperation<OidbFetchGroupsResponse>(0xfe5, 2) {
    override fun buildOidb(bot: BotContext, payload: Unit): ByteArray =
        OidbFetchGroupsRequest().pb()

    override fun parseOidb(bot: BotContext, payload: ByteArray): OidbFetchGroupsResponse =
        payload.pb<OidbFetchGroupsResponse>()
}