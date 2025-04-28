package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class ElemFlags2(
    @ProtoNumber(1) val colorTextId: Long,
    @ProtoNumber(2) val msgId: Long,
    @ProtoNumber(3) val whisperSessionId: Long,
    @ProtoNumber(4) val pttChangeBit: Long,
    @ProtoNumber(5) val vipStatus: Long,
    @ProtoNumber(6) val compatibleId: Long,
    @ProtoNumber(7) val instances: List<Instance>,
    @ProtoNumber(8) val msgRptCnt: Long,
    @ProtoNumber(9) val srcInst: Instance?,
    @ProtoNumber(10) val longitude: Long,
    @ProtoNumber(11) val latitude: Long,
    @ProtoNumber(12) val customFont: Long,
    @ProtoNumber(13) val pcSupportDef: PcSupportDef?,
    @ProtoNumber(14) val crmFlags: Long?,
) : ElementType {
    @Serializable
    class Instance(
        @ProtoNumber(1) val appId: Long,
        @ProtoNumber(2) val instId: Long,
    )

    @Serializable
    class PcSupportDef(
        @ProtoNumber(1) val pcPtlBegin: Long,
        @ProtoNumber(2) val pcPtlEnd: Long,
        @ProtoNumber(3) val macPtlBegin: Long,
        @ProtoNumber(4) val macPtlEnd: Long,
        @ProtoNumber(5) val ptlsSupport: List<Long>,
        @ProtoNumber(6) val ptlsNotSupport: List<Long>,
    )
}