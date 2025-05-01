package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DownloadRKeyResp(
    @ProtoField(1) var rkeys: List<RKeyInfo>,
) : ProtoMessage() {
    class RKeyInfo(
        @ProtoField(1) var rkey: String?,
        @ProtoField(2) var rkeyTtlSec: Long,
        @ProtoField(3) var storeId: Long,
        @ProtoField(4) var rkeyCreateTime: Long?,
        @ProtoField(5) var type: Long?,
    ) : ProtoMessage()
}