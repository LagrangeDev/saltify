package org.ntqqrev.saltify.core.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class RegisterInfoResponse(
    @ProtoNumber(2) val message: String
)