package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbReserve(
    @ProtoField(1) var subType: Int,
    @ProtoField(3) var field3: Int,
    @ProtoField(4) var field4: Int,
    @ProtoField(8) var summary: String?,
    @ProtoField(10) var field10: Int,
    @ProtoField(20) var field20: PbReserve2?,
    @ProtoField(30) var url: String?,
    @ProtoField(31) var md5Str: String?,
) : ProtoMessage()