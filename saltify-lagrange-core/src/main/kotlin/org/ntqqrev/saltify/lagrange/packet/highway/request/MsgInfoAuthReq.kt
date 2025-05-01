package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MsgInfoAuthReq(
    @ProtoField(1) var msg: ByteArray?,
    @ProtoField(2) var authTime: Long,
) : ProtoMessage()