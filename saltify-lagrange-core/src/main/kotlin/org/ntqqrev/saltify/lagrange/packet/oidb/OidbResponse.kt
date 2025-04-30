package org.ntqqrev.saltify.lagrange.packet.oidb

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class OidbResponse(
    @ProtoField(3) var retCode: Int,
    @ProtoField(4) var payload: ByteArray?,
    @ProtoField(5) var errorMsg: String?,
) : ProtoMessage()