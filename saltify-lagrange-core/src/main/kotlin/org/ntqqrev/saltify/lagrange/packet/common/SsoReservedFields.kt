package org.ntqqrev.saltify.lagrange.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class SsoReservedFields(
    @ProtoNumber(15) val trace: String,
    @ProtoNumber(16) val uid: String?,
    @ProtoNumber(24) val secureInfo: SsoSecureInfo?,
)