package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class NTSysEvent(
    val ip: String,
    val sid: Long,
    val sub: Sub
) {
    @Serializable
    class Sub(
        @ProtoNumber(2) val state: Long,
        @ProtoNumber(3) val field3: Int,
        @ProtoNumber(4) val field4: Long,
        @ProtoNumber(5) val uin: Long,
        @ProtoNumber(6) val flag: Int,
        @ProtoNumber(7) val on: Int,
        @ProtoNumber(8) val groupUin: Long
    )
}