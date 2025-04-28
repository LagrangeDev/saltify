package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class ExtraInfo(
    @ProtoNumber(1) val nick: ByteArray?,
    @ProtoNumber(2) val groupCard: ByteArray?,
    @ProtoNumber(3) val level: Int,
    @ProtoNumber(4) val flags: Int,
    @ProtoNumber(5) val groupMask: Int,
    @ProtoNumber(6) val msgTailId: Int,
    @ProtoNumber(7) val senderTitle: ByteArray?,
    @ProtoNumber(8) val apnsTips: ByteArray?,
    @ProtoNumber(9) val uin: Long,
    @ProtoNumber(10) val msgStateFlag: Int,
    @ProtoNumber(11) val apnsSoundType: Int,
    @ProtoNumber(12) val newGroupFlag: Int,
) : ElementType