package org.ntqqrev.saltify.lagrange.packet.common

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class SsoSecureInfo(
    @ProtoField(1) var sign: ByteArray,
    @ProtoField(2) var token: ByteArray,
    @ProtoField(3) var extra: ByteArray,
) : ProtoMessage()