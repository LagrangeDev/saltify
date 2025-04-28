package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class CustomElement(
    @ProtoNumber(1) val desc: ByteArray?,
    @ProtoNumber(2) val data: ByteArray?,
    @ProtoNumber(3) val enumType: Int,
    @ProtoNumber(4) val ext: ByteArray?,
    @ProtoNumber(5) val sound: ByteArray?,
) : ElementType