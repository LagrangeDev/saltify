package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class FaceElement(
    @ProtoField(1) var index: Int?,
    @ProtoField(2) var old: ByteArray?,
    @ProtoField(11) var buf: ByteArray?,
) : ProtoMessage()