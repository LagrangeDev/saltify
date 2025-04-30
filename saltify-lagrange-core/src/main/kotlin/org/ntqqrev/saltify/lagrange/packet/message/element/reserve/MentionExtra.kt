package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MentionExtra(
    @ProtoField(3) var type: Int,
    @ProtoField(4) var uin: Long,
    @ProtoField(9) var uidOrAll: String,
) : ProtoMessage()