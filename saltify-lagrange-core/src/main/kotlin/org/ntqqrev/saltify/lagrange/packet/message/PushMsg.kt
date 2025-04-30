package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PushMsg(
    @ProtoField(1) var message: PushMsgBody,
    @ProtoField(3) var status: Int?,
    @ProtoField(4) var ntEvent: NTSysEvent?,
    @ProtoField(5) var pingFlag: Int?,
    @ProtoField(9) var generalFlag: Int?
) : ProtoMessage()