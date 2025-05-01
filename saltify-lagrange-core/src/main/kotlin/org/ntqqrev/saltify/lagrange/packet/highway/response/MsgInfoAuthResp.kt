package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MsgInfoAuthResp(
    @ProtoField(1) var authCode: Long,
    @ProtoField(2) var msg: ByteArray?,
    @ProtoField(3) var resultTime: Long,
) : ProtoMessage()