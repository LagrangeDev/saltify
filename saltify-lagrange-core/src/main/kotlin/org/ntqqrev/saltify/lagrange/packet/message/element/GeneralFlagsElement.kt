package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class GeneralFlagsElement(
    @ProtoField(1) var bubbleDiyTextId: Long,
    @ProtoField(2) var groupFlagNew: Int,
    @ProtoField(3) var uin: Long,
    @ProtoField(4) var rpId: ByteArray?,
    @ProtoField(5) var prpFold: Int,
    @ProtoField(6) var longTextFlag: Int,
    @ProtoField(7) var longTextResId: String?,
    @ProtoField(8) var groupType: Int,
    @ProtoField(9) var toUinFlag: Int,
    @ProtoField(10) var glamourLevel: Int,
    @ProtoField(11) var memberLevel: Int,
    @ProtoField(12) var groupRankSeq: Long,
    @ProtoField(13) var olympicTorch: Int,
    @ProtoField(14) var babyQGuideMsgCookie: ByteArray?,
    @ProtoField(15) var uin32ExpertFlag: Int,
    @ProtoField(16) var bubbleSubId: Int,
    @ProtoField(17) var pendantId: Long,
    @ProtoField(18) var rpIndex: ByteArray?,
    @ProtoField(19) var pbReserve: ByteArray?,
) : ProtoMessage()