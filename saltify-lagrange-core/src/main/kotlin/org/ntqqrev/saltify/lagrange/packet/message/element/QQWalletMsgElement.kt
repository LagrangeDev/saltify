package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class QQWalletMsgElement(
    @ProtoField(1) var body: AioBody,
) : ProtoMessage() {
    class AioBody(
        @ProtoField(1) var sendUin: Long,
        @ProtoField(2) var sender: AioElem?,
        @ProtoField(3) var receiver: AioElem?,
        @ProtoField(4) var channelId: Int,
        @ProtoField(5) var templateId: Int,
        @ProtoField(6) var resend: Long,
        @ProtoField(7) var msgPriority: Long,
        @ProtoField(8) var redType: Int,
        @ProtoField(9) var billNo: ByteArray?,
        @ProtoField(10) var authKey: ByteArray?,
        @ProtoField(11) var sessionType: Int,
        @ProtoField(12) var msgType: Int,
        @ProtoField(13) var envelopeId: Int,
        @ProtoField(14) var name: ByteArray?,
        @ProtoField(15) var confType: Int,
        @ProtoField(16) var msgFrom: Int,
        @ProtoField(17) var pcBody: ByteArray?,
        @ProtoField(18) var index: ByteArray?,
        @ProtoField(19) var redChannel: Long,
        @ProtoField(20) var grapUin: List<Long>,
        @ProtoField(21) var pbReserve: ByteArray?,
    ) : ProtoMessage()

    class AioElem(
        @ProtoField(1) var background: Long,
        @ProtoField(2) var icon: Long,
        @ProtoField(3) var title: String?,
        @ProtoField(4) var subtitle: String?,
        @ProtoField(5) var content: String?,
        @ProtoField(6) var linkUrl: ByteArray?,
        @ProtoField(7) var blackStripe: ByteArray?,
        @ProtoField(8) var notice: ByteArray?,
        @ProtoField(9) var titleColor: Long,
        @ProtoField(10) var subtitleColor: Long,
        @ProtoField(11) var actionsPriority: ByteArray?,
        @ProtoField(12) var jumpUrl: ByteArray?,
        @ProtoField(13) var nativeIos: ByteArray?,
        @ProtoField(14) var nativeAndroid: ByteArray?,
        @ProtoField(15) var iconUrl: ByteArray?,
        @ProtoField(16) var contentColor: Long,
        @ProtoField(17) var contentBgColor: Long,
        @ProtoField(18) var aioImageLeft: ByteArray?,
        @ProtoField(19) var aioImageRight: ByteArray?,
        @ProtoField(20) var cftImage: ByteArray?,
        @ProtoField(21) var pbReserve: ByteArray?,
    ) : ProtoMessage()
}