package org.ntqqrev.saltify.lagrange.packet.common

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class SsoReservedFields(
    @ProtoField(15) var trace: String,
    @ProtoField(16) var uid: String?,
    @ProtoField(24) var secureInfo: SsoSecureInfo?,
) : ProtoMessage()