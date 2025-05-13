package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbSendMsgResponse(
    @ProtoField(1) var result: Int,
    @ProtoField(2) var errorMsg: String,
    @ProtoField(3) var timestamp: Long,
    @ProtoField(10) var msgInfoFlag: Int,
    @ProtoField(11) var sequence: Long,
    @ProtoField(14) var clientSequence: Long,
) : ProtoMessage()