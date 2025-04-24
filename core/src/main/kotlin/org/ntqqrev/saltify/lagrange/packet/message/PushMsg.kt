package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class PushMsg(
    @ProtoNumber(1) val message: ByteArray,
    @ProtoNumber(3) val status: Int?,
    @ProtoNumber(4) val ntEvent: NTSysEvent?,
    @ProtoNumber(5) val pingFlag: Int?,
    @ProtoNumber(9) val generalFlag: Int?
)