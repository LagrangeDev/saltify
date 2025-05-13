package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PbSendMsg(
    @ProtoField(1) var routingHead: RoutingHead? = null,
    @ProtoField(2) var contentHead: ContentHead? = null,
    @ProtoField(3) var body: MessageBody? = null,
    @ProtoField(4) var clientSequence: Long? = null,
    @ProtoField(5) var random: Long? = null,
    @ProtoField(6) var syncCookie: ByteArray? = null,
    @ProtoField(8) var via: Long? = null,
    @ProtoField(9) var dataStatist: Long? = null,
    @ProtoField(12) var ctrl: MessageControl? = null,
    @ProtoField(14) var multiSendSeq: Long? = null,
) : ProtoMessage()