package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class IndexNode(
    @ProtoField(1) var info: FileInfo?,
    @ProtoField(2) var fileUuid: String?,
    @ProtoField(3) var storeId: Long,
    @ProtoField(4) var uploadTime: Long,
    @ProtoField(5) var ttl: Long,
    @ProtoField(6) var subType: Long,
) : ProtoMessage()