package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class PushMsgBody(
    @ProtoField(1) var responseHead: ResponseHead,
    @ProtoField(2) var contentHead: ContentHead,
    @ProtoField(3) var body: MessageBody?,
) : ProtoMessage()