package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class SrcReserve(
    @ProtoField(3) var messageUid: Long,
    @ProtoField(6) var fromUid: String,
    @ProtoField(7) var toUid: String,
    @ProtoField(8) var friendSequence: Long?,
) : ProtoMessage()