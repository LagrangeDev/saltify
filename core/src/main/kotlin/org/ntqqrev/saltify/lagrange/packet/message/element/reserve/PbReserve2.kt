package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class PbReserve2(
    @ProtoNumber(1) val field1: Int,
    @ProtoNumber(2) val field2: String?,
    @ProtoNumber(3) val field3: Int,
    @ProtoNumber(4) val field4: Int,
    @ProtoNumber(5) val field5: Int,
    @ProtoNumber(7) val md5Str: String?,
)