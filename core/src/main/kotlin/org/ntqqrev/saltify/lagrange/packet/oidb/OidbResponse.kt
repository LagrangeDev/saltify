package org.ntqqrev.saltify.lagrange.packet.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class OidbResponse (
    @ProtoNumber(3) val retCode: Int,
    @ProtoNumber(4) val payload: ByteArray?,
    @ProtoNumber(5) val errorMsg: String?,
)