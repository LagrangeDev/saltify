package org.ntqqrev.saltify.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class SsoSecureInfo(
    @ProtoNumber(1) val sign: ByteArray,
    @ProtoNumber(2) val token: ByteArray,
    @ProtoNumber(3) val extra: ByteArray,
)