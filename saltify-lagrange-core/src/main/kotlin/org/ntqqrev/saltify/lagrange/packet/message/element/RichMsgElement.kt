package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class RichMsgElement(
    @ProtoField(1) var template1: ByteArray?,
    @ProtoField(2) var serviceId: Int?,
    @ProtoField(3) var msgResId: ByteArray?,
    @ProtoField(4) var rand: Int?,
    @ProtoField(5) var seq: Int?,
) : ProtoMessage()