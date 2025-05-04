package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MessageControl(
    @ProtoField(1) var msgFlag: Int,
) : ProtoMessage()