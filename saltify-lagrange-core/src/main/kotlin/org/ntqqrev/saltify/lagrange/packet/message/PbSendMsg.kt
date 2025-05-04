package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbSendMsg(
    @ProtoField(1) var routingHead: RoutingHead?,
    @ProtoField(2) var contentHead: ContentHead?,
    @ProtoField(3) var body: MessageBody?,
    @ProtoField(4) var clientSequence: Long?,
    @ProtoField(5) var random: Long?,
    @ProtoField(6) var syncCookie: ByteArray?,
    @ProtoField(8) var via: Long?,
    @ProtoField(9) var dataStatist: Long?,
    @ProtoField(12) var ctrl: MessageControl?,
    @ProtoField(14) var multiSendSeq: Long,
) : ProtoMessage()