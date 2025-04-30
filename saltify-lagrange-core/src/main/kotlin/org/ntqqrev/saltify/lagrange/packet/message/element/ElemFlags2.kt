package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class ElemFlags2(
    @ProtoField(1) var colorTextId: Long,
    @ProtoField(2) var msgId: Long,
    @ProtoField(3) var whisperSessionId: Long,
    @ProtoField(4) var pttChangeBit: Long,
    @ProtoField(5) var vipStatus: Long,
    @ProtoField(6) var compatibleId: Long,
    @ProtoField(7) var instances: List<Instance>,
    @ProtoField(8) var msgRptCnt: Long,
    @ProtoField(9) var srcInst: Instance?,
    @ProtoField(10) var longitude: Long,
    @ProtoField(11) var latitude: Long,
    @ProtoField(12) var customFont: Long,
    @ProtoField(13) var pcSupportDef: PcSupportDef?,
    @ProtoField(14) var crmFlags: Long?,
) : ProtoMessage() {

    class Instance(
        @ProtoField(1) var appId: Long,
        @ProtoField(2) var instId: Long,
    ) : ProtoMessage()

    class PcSupportDef(
        @ProtoField(1) var pcPtlBegin: Long,
        @ProtoField(2) var pcPtlEnd: Long,
        @ProtoField(3) var macPtlBegin: Long,
        @ProtoField(4) var macPtlEnd: Long,
        @ProtoField(5) var ptlsSupport: List<Long>,
        @ProtoField(6) var ptlsNotSupport: List<Long>,
    ) : ProtoMessage()
}