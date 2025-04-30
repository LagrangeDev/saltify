package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class ExtraInfo(
    @ProtoField(1) var nick: ByteArray?,
    @ProtoField(2) var groupCard: ByteArray?,
    @ProtoField(3) var level: Int,
    @ProtoField(4) var flags: Int,
    @ProtoField(5) var groupMask: Int,
    @ProtoField(6) var msgTailId: Int,
    @ProtoField(7) var senderTitle: ByteArray?,
    @ProtoField(8) var apnsTips: ByteArray?,
    @ProtoField(9) var uin: Long,
    @ProtoField(10) var msgStateFlag: Int,
    @ProtoField(11) var apnsSoundType: Int,
    @ProtoField(12) var newGroupFlag: Int,
) : ProtoMessage()