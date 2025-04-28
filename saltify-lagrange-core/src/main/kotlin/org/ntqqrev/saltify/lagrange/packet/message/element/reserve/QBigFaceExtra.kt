package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class QBigFaceExtra(
    @ProtoNumber(1) val aniStickerPackId: String,
    @ProtoNumber(2) val aniStickerId: String,
    @ProtoNumber(3) val faceId: Int,
    @ProtoNumber(4) val field4: Int,
    @ProtoNumber(5) val aniStickerType: Int,
    @ProtoNumber(6) val field6: String,
    @ProtoNumber(7) val preview: String,
    @ProtoNumber(9) val field9: Int,
)

