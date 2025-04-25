package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class MentionExtra(
    @ProtoNumber(3) val type: Int,
    @ProtoNumber(4) val uin: Long,
    @ProtoNumber(9) val uidOrAll: String,
)