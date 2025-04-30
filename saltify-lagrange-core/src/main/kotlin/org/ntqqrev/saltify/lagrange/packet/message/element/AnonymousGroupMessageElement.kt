package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class AnonymousGroupMessageElement(
    @ProtoField(1) var flags: Int,
    @ProtoField(2) var anonId: ByteArray?,
    @ProtoField(3) var anonNick: ByteArray?,
    @ProtoField(4) var headPortrait: Int,
    @ProtoField(5) var expireTime: Int,
    @ProtoField(6) var bubbleId: Int,
    @ProtoField(7) var rankColor: ByteArray?,
) : ProtoMessage()