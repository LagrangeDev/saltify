package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class QSmallFaceExtra(
    @ProtoField(1) var faceId: Long,
    @ProtoField(2) var text: String?,
    @ProtoField(3) var compatText: String?,
) : ProtoMessage()