package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class CustomElement(
    @ProtoField(1) var desc: ByteArray?,
    @ProtoField(2) var data: ByteArray?,
    @ProtoField(3) var enumType: Int,
    @ProtoField(4) var ext: ByteArray?,
    @ProtoField(5) var sound: ByteArray?,
) : ProtoMessage()