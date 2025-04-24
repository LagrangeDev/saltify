package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class PbReserve(
    @ProtoNumber(1) val subType: Int,
    @ProtoNumber(3) val field3: Int,
    @ProtoNumber(4) val field4: Int,
    @ProtoNumber(8) val summary: String?,
    @ProtoNumber(10) val field10: Int,
    @ProtoNumber(20) val field20: PbReserve2?,
    @ProtoNumber(30) val url: String?,
    @ProtoNumber(31) val md5Str: String?,
)