package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class GeneralFlagsElement(
    @ProtoNumber(1) val bubbleDiyTextId: Long,
    @ProtoNumber(2) val groupFlagNew: Int,
    @ProtoNumber(3) val uin: Long,
    @ProtoNumber(4) val rpId: ByteArray?,
    @ProtoNumber(5) val prpFold: Int,
    @ProtoNumber(6) val longTextFlag: Int,
    @ProtoNumber(7) val longTextResId: String?,
    @ProtoNumber(8) val groupType: Int,
    @ProtoNumber(9) val toUinFlag: Int,
    @ProtoNumber(10) val glamourLevel: Int,
    @ProtoNumber(11) val memberLevel: Int,
    @ProtoNumber(12) val groupRankSeq: Long,
    @ProtoNumber(13) val olympicTorch: Int,
    @ProtoNumber(14) val babyQGuideMsgCookie: ByteArray?,
    @ProtoNumber(15) val uin32ExpertFlag: Int,
    @ProtoNumber(16) val bubbleSubId: Int,
    @ProtoNumber(17) val pendantId: Long,
    @ProtoNumber(18) val rpIndex: ByteArray?,
    @ProtoNumber(19) val pbReserve: ByteArray?,
) : ElementType