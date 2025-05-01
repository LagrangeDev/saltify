package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.lagrange.packet.highway.CommonHead
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MultiMediaRespHead(
    @ProtoField(1) var common: CommonHead?,
    @ProtoField(2) var retCode: Long,
    @ProtoField(3) var message: String?,
) : ProtoMessage()