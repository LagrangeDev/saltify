package org.ntqqrev.saltify.lagrange.operation.highway

import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.OidbOperation
import org.ntqqrev.saltify.lagrange.packet.highway.CommonHead
import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.lagrange.packet.highway.request.DownloadReq
import org.ntqqrev.saltify.lagrange.packet.highway.request.MultiMediaReqHead
import org.ntqqrev.saltify.lagrange.packet.highway.request.NTV2RichMediaReq
import org.ntqqrev.saltify.lagrange.packet.highway.response.NTV2RichMediaResp
import org.ntqqrev.saltify.lagrange.util.binary.pb

object GetPrivateVideoUrl : OidbOperation<IndexNode, String>(0x11e9, 200) {
    override fun buildOidb(bot: BotContext, payload: IndexNode): ByteArray =
        NTV2RichMediaReq(
            reqHead = MultiMediaReqHead(
                common = CommonHead(
                    requestId = 1,
                    command = 200,
                ),
                scene = MultiMediaReqHead.SceneInfo(
                    requestType = 2,
                    businessType = 2,
                    sceneType = 1,
                    c2c = MultiMediaReqHead.SceneInfo.C2C(
                        accountType = 2,
                        targetUid = bot.keystore.uid,
                    ),
                ),
            ),
            download = DownloadReq(payload)
        ).pb()

    override fun parseOidb(bot: BotContext, payload: ByteArray): String =
        payload.pb<NTV2RichMediaResp>().download
            ?.let {
                "https://${it.info!!.domain}${it.info!!.urlPath}${it.rKeyParam!!}"
            }
            ?: throw IllegalStateException("Failed to parse group image URL")
}