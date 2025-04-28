package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class TransElement(
    @ProtoNumber(1) val elemType: Int,
    @ProtoNumber(2) val elemValue: ByteArray?,
) : ElementType