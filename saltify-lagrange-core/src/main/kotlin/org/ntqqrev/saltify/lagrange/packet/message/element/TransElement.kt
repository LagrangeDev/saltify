package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class TransElement(
    @ProtoField(1) var elemType: Int,
    @ProtoField(2) var elemValue: ByteArray?,
) : ProtoMessage()