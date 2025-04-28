package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class QQWalletMsgElement(
    @ProtoNumber(1) val body: AioBody,
) : ElementType {
    @Serializable
    class AioBody(
        @ProtoNumber(1) val sendUin: Long,
        @ProtoNumber(2) val sender: AioElem?,
        @ProtoNumber(3) val receiver: AioElem?,
        @ProtoNumber(4) val channelId: Int,
        @ProtoNumber(5) val templateId: Int,
        @ProtoNumber(6) val resend: Long,
        @ProtoNumber(7) val msgPriority: Long,
        @ProtoNumber(8) val redType: Int,
        @ProtoNumber(9) val billNo: ByteArray?,
        @ProtoNumber(10) val authKey: ByteArray?,
        @ProtoNumber(11) val sessionType: Int,
        @ProtoNumber(12) val msgType: Int,
        @ProtoNumber(13) val envelopeId: Int,
        @ProtoNumber(14) val name: ByteArray?,
        @ProtoNumber(15) val confType: Int,
        @ProtoNumber(16) val msgFrom: Int,
        @ProtoNumber(17) val pcBody: ByteArray?,
        @ProtoNumber(18) val index: ByteArray?,
        @ProtoNumber(19) val redChannel: Long,
        @ProtoNumber(20) val grapUin: List<Long>,
        @ProtoNumber(21) val pbReserve: ByteArray?,
    )

    @Serializable
    class AioElem(
        @ProtoNumber(1) val background: Long,
        @ProtoNumber(2) val icon: Long,
        @ProtoNumber(3) val title: String?,
        @ProtoNumber(4) val subtitle: String?,
        @ProtoNumber(5) val content: String?,
        @ProtoNumber(6) val linkUrl: ByteArray?,
        @ProtoNumber(7) val blackStripe: ByteArray?,
        @ProtoNumber(8) val notice: ByteArray?,
        @ProtoNumber(9) val titleColor: Long,
        @ProtoNumber(10) val subtitleColor: Long,
        @ProtoNumber(11) val actionsPriority: ByteArray?,
        @ProtoNumber(12) val jumpUrl: ByteArray?,
        @ProtoNumber(13) val nativeIos: ByteArray?,
        @ProtoNumber(14) val nativeAndroid: ByteArray?,
        @ProtoNumber(15) val iconUrl: ByteArray?,
        @ProtoNumber(16) val contentColor: Long,
        @ProtoNumber(17) val contentBgColor: Long,
        @ProtoNumber(18) val aioImageLeft: ByteArray?,
        @ProtoNumber(19) val aioImageRight: ByteArray?,
        @ProtoNumber(20) val cftImage: ByteArray?,
        @ProtoNumber(21) val pbReserve: ByteArray?,
    )
}