package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement

@Serializable
class SrcMsgElement(
    @ProtoNumber(1) val origSeqs: List<Long>,
    @ProtoNumber(2) val senderUin: Long,
    @ProtoNumber(3) val time: Int?,
    @ProtoNumber(4) val flag: Int?,
    @ProtoNumber(5) val elements: List<MessageElement>,
    @ProtoNumber(6) val type: Int?,
    @ProtoNumber(7) val richMsg: ByteArray?,
    @ProtoNumber(8) val pbReserve: ByteArray?,
    @ProtoNumber(9) val sourceMsg: ByteArray?,
    @ProtoNumber(10) val toUin: Long?,
    @ProtoNumber(11) val troopName: ByteArray?,
) : ElementType