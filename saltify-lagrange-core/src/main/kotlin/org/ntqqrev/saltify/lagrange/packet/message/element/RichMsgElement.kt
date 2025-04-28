package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class RichMsgElement(
    @ProtoNumber(1) val template1: ByteArray?,
    @ProtoNumber(2) val serviceId: Int?,
    @ProtoNumber(3) val msgResId: ByteArray?,
    @ProtoNumber(4) val rand: Int?,
    @ProtoNumber(5) val seq: Int?,
) : ElementType