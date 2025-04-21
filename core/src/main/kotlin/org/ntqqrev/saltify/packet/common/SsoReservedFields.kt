package org.ntqqrev.saltify.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class SsoReservedFields(
    @ProtoNumber(15) val trace: String,
    @ProtoNumber(16) val uid: String?,
    @ProtoNumber(24) val secureInfo: SsoSecureInfo?,
)

@Serializable
internal class SsoSecureInfo(
    @ProtoNumber(1) val sign: ByteArray,
    @ProtoNumber(2) val token: ByteArray,
    @ProtoNumber(3) val extra: ByteArray,
)