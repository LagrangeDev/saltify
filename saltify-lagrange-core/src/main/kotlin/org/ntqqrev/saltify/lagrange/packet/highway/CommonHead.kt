package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class CommonHead(
    @ProtoField(1) var requestId: Long,
    @ProtoField(2) var command: Long,
) : ProtoMessage()