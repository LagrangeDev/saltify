package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfo
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadCompletedReq(
    @ProtoField(1) var srvSendMsg: Boolean,
    @ProtoField(2) var clientRandomId: Long,
    @ProtoField(3) var msgInfo: MsgInfo?,
    @ProtoField(4) var clientSeq: Long,
) : ProtoMessage()