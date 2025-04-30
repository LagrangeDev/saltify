package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class QBigFaceExtra(
    @ProtoField(1) var aniStickerPackId: String,
    @ProtoField(2) var aniStickerId: String,
    @ProtoField(3) var faceId: Int,
    @ProtoField(4) var field4: Int,
    @ProtoField(5) var aniStickerType: Int,
    @ProtoField(6) var field6: String,
    @ProtoField(7) var preview: String,
    @ProtoField(9) var field9: Int,
) : ProtoMessage()

