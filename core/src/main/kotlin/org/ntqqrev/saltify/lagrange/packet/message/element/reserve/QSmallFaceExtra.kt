package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class QSmallFaceExtra(
    @ProtoNumber(1) val faceId: Long,
    @ProtoNumber(2) val text: String?,
    @ProtoNumber(3) val compatText: String?,
)