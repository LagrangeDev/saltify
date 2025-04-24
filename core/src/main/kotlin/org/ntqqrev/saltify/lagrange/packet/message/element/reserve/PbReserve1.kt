package org.ntqqrev.saltify.lagrange.packet.message.element.reserve

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class PbReserve1(
    @ProtoNumber(1) val subType: Int,
    @ProtoNumber(3) val field3: Int,
    @ProtoNumber(4) val field4: Int,
    @ProtoNumber(9) val summary: String?,
    @ProtoNumber(10) val field10: Int,
    @ProtoNumber(21) val field21: PbReserve2?,
    @ProtoNumber(31) val field31: String?,
)