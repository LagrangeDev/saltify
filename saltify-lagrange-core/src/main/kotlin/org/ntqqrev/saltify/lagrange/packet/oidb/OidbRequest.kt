package org.ntqqrev.saltify.lagrange.packet.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class OidbRequest (
    @ProtoNumber(1) val cmd: Int,
    @ProtoNumber(2) val subCmd: Int,
    @ProtoNumber(4) val payload: ByteArray,
    @ProtoNumber(12) val reserve: Boolean = false,
)