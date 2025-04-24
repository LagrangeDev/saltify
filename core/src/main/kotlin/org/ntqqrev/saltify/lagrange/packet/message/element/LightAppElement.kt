package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class LightAppElement(
    @ProtoNumber(1) val data: ByteArray?,
    @ProtoNumber(2) val msgResId: ByteArray?,
) : ElementType