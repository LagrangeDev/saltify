package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class LightAppElement(
    @ProtoField(1) var data: ByteArray?,
    @ProtoField(2) var msgResId: ByteArray?,
) : ProtoMessage()