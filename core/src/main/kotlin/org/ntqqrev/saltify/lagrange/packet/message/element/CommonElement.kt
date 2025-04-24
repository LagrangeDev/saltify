package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class CommonElement(
    @ProtoNumber(1) val serviceType: Int,
    @ProtoNumber(2) val pbElem: ByteArray?,
    @ProtoNumber(3) val businessType: Long,
) : ElementType