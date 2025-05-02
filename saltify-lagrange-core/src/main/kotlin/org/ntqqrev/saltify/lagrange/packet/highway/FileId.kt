package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class FileId(
    @ProtoField(4) var appId: Int,
    @ProtoField(10) var ttl: Long,
) : ProtoMessage()