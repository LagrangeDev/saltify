package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DeleteReq(
    @ProtoField(1) var index: List<IndexNode>,
    @ProtoField(2) var needRecallMsg: Boolean,
    @ProtoField(3) var msgSeq: Long,
    @ProtoField(4) var msgRandom: Long,
    @ProtoField(5) var msgTime: Long,
) : ProtoMessage()