package org.ntqqrev.saltify.core.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class SsoReservedFields(
    @ProtoNumber(15) val trace: String,
    @ProtoNumber(16) val uid: String?,
    @ProtoNumber(24) val secureInfo: SsoSecureInfo?,
)