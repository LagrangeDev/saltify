package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class RoutingHead(
    @ProtoField(1) var c2c: C2C?,
    @ProtoField(2) var grp: Grp?,
    @ProtoField(3) var grpTmp: GrpTmp?,
    @ProtoField(6) var wpaTmp: WPATmp?,
    @ProtoField(15) var trans0X211: Trans0X211?,
) : ProtoMessage() {
    class C2C(
        @ProtoField(1) var uin: Long?,
        @ProtoField(2) var uid: String?,
        @ProtoField(3) var field3: Long?,
        @ProtoField(4) var sig: Long?,
        @ProtoField(5) var receiverUin: Long?,
        @ProtoField(6) var receiverUid: String?,
    ) : ProtoMessage()

    class Grp(
        @ProtoField(1) var groupUin: Long?,
    ) : ProtoMessage()

    class GrpTmp(
        @ProtoField(1) var groupUin: Long?,
        @ProtoField(2) var toUin: Long?,
    ) : ProtoMessage()


    class WPATmp(
        @ProtoField(1) var toUin: Long,
        @ProtoField(2) var sig: ByteArray?,
    ) : ProtoMessage()

    class Trans0X211(
        @ProtoField(1) var toUin: Long?,
        @ProtoField(2) var ccCmd: Long?,
        @ProtoField(8) var uid: String?,
    ) : ProtoMessage()
}