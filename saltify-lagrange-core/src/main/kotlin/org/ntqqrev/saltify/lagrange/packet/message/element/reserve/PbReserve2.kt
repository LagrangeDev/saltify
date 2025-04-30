package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbReserve2(
    @ProtoField(1) var field1: Int,
    @ProtoField(2) var field2: String?,
    @ProtoField(3) var field3: Int,
    @ProtoField(4) var field4: Int,
    @ProtoField(5) var field5: Int,
    @ProtoField(7) var md5Str: String?,
) : ProtoMessage()