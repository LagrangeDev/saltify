package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NTSysEvent(
    @ProtoField(1) var ip: String,
    @ProtoField(2) var sid: Long,
    @ProtoField(3) var sub: Sub
) : ProtoMessage() {
    class Sub(
        @ProtoField(2) var state: Long,
        @ProtoField(3) var field3: Int,
        @ProtoField(4) var field4: Long,
        @ProtoField(5) var uin: Long,
        @ProtoField(6) var flag: Int,
        @ProtoField(7) var on: Int,
        @ProtoField(8) var groupUin: Long
    ) : ProtoMessage()
}