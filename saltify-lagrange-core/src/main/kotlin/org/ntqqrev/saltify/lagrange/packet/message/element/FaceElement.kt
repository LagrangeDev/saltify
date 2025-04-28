package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class FaceElement(
    @ProtoNumber(1) val index: Int?,
    @ProtoNumber(2) val old: ByteArray?,
    @ProtoNumber(11) val buf: ByteArray?,
) : ElementType