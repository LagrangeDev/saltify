package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class CommonElement(
    @ProtoField(1) var serviceType: Int,
    @ProtoField(2) var pbElem: ByteArray,
    @ProtoField(3) var businessType: Long,
) : ProtoMessage()