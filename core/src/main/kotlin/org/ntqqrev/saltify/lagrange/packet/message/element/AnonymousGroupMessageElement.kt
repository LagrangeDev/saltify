package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class AnonymousGroupMessageElement(
    @ProtoNumber(1) val flags: Int,
    @ProtoNumber(2) val anonId: ByteArray?,
    @ProtoNumber(3) val anonNick: ByteArray?,
    @ProtoNumber(4) val headPortrait: Int,
    @ProtoNumber(5) val expireTime: Int,
    @ProtoNumber(6) val bubbleId: Int,
    @ProtoNumber(7) val rankColor: ByteArray?,
) : ElementType