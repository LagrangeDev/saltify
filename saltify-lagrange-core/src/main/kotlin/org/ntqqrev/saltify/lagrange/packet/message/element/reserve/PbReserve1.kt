package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbReserve1(
    @ProtoField(1) var subType: Int,
    @ProtoField(3) var field3: Int,
    @ProtoField(4) var field4: Int,
    @ProtoField(9) var summary: String?,
    @ProtoField(10) var field10: Int,
    @ProtoField(21) var field21: PbReserve2?,
    @ProtoField(31) var field31: String?,
) : ProtoMessage()