package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.lagrange.packet.message.MessageElement
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class SrcMsgElement(
    @ProtoField(1) var origSeqs: List<Long>,
    @ProtoField(2) var senderUin: Long,
    @ProtoField(3) var time: Int?,
    @ProtoField(4) var flag: Int?,
    @ProtoField(5) var elements: List<MessageElement>,
    @ProtoField(6) var type: Int?,
    @ProtoField(7) var richMsg: ByteArray?,
    @ProtoField(8) var pbReserve: ByteArray?,
    @ProtoField(9) var sourceMsg: ByteArray?,
    @ProtoField(10) var toUin: Long?,
    @ProtoField(11) var troopName: ByteArray?,
) : ProtoMessage()