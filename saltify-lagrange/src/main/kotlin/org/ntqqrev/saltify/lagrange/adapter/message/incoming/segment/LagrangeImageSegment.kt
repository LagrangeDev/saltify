package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.ImageSubType
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.ImageSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfo
import org.ntqqrev.saltify.lagrange.util.binary.pb

// resource ID has two formats:
// 1) IndexNode.fileUuid
// 2) url:(baseUrl + origUrl)
class LagrangeImageSegment(message: IncomingMessage, resourceId: String, subType: ImageSubType, summary: String) :
    ImageSegment(message, resourceId, subType, summary) {
    companion object : LagrangeSegmentFactory<ImageSegment> {
        val ntBaseUrl = "https://multimedia.nt.qq.com.cn"
        val legacyBaseUrl = "http://gchat.qpic.cn"

        override fun tryParse(reader: ElementReader): ImageSegment? {
            val element = reader.next()
            return when {
                element?.common?.let {
                    it.serviceType == 48 && (it.businessType == 20 || it.businessType == 10)
                } ?: false -> {
                    val msgInfo = element.common!!.pbElem.pb<MsgInfo>()
                    val uuid =
                        msgInfo.msgInfoBody.getOrNull(0)?.index?.fileUuid ?: return reader.pushBackAndReturnNull()
                    val subType = when (msgInfo.extBizInfo?.pic?.bizType) {
                        1 -> ImageSubType.STICKER
                        else -> ImageSubType.NORMAL
                    }
                    LagrangeImageSegment(
                        reader.message, uuid, subType, msgInfo.extBizInfo?.pic?.textSummary ?: when (subType) {
                            ImageSubType.NORMAL -> "[图片]"
                            ImageSubType.STICKER -> "[动画表情]"
                        }
                    )
                }

                element?.notOnlineImage != null -> {
                    val notOnlineImage = element.notOnlineImage!!
                    val subType = when (notOnlineImage.pbRes?.subType) {
                        1 -> ImageSubType.STICKER
                        else -> ImageSubType.NORMAL
                    }
                    LagrangeImageSegment(
                        reader.message,
                        "url:" + (if (notOnlineImage.origUrl?.contains("&fileid=") ?: false) ntBaseUrl
                        else legacyBaseUrl) + notOnlineImage.origUrl!!,
                        subType,
                        notOnlineImage.pbRes?.summary ?: when (subType) {
                            ImageSubType.NORMAL -> "[图片]"
                            ImageSubType.STICKER -> "[动画表情]"
                        }
                    )
                }

                element?.customFace != null -> {
                    val customFace = element.customFace!!
                    val subType = when (customFace.pbReserve?.subType) {
                        1 -> ImageSubType.STICKER
                        else -> ImageSubType.NORMAL
                    }
                    LagrangeImageSegment(
                        reader.message,
                        "url:" + (if (customFace.origUrl?.contains("&fileid=") ?: false) ntBaseUrl
                        else legacyBaseUrl) + customFace.origUrl!!,
                        subType,
                        customFace.pbReserve?.summary ?: when (subType) {
                            ImageSubType.NORMAL -> "[图片]"
                            ImageSubType.STICKER -> "[动画表情]"
                        }
                    )
                }

                else -> reader.pushBackAndReturnNull()
            }
        }
    }

    override fun toString(): String = summary
}