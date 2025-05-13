package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class RoutingHead(
    @ProtoField(1) var c2c: C2C? = null,
    @ProtoField(2) var grp: Grp? = null,
    @ProtoField(3) var grpTmp: GrpTmp? = null,
    @ProtoField(6) var wpaTmp: WPATmp? = null,
    @ProtoField(15) var trans0X211: Trans0X211? = null,
) : ProtoMessage() {
    class C2C(
        @ProtoField(1) var uin: Long? = null,
        @ProtoField(2) var uid: String? = null,
        @ProtoField(3) var field3: Long? = null,
        @ProtoField(4) var sig: Long? = null,
        @ProtoField(5) var receiverUin: Long? = null,
        @ProtoField(6) var receiverUid: String? = null,
    ) : ProtoMessage()

    class Grp(
        @ProtoField(1) var groupUin: Long? = null,
    ) : ProtoMessage()

    class GrpTmp(
        @ProtoField(1) var groupUin: Long? = null,
        @ProtoField(2) var toUin: Long? = null,
    ) : ProtoMessage()


    class WPATmp(
        @ProtoField(1) var toUin: Long,
        @ProtoField(2) var sig: ByteArray? = null,
    ) : ProtoMessage()

    class Trans0X211(
        @ProtoField(1) var toUin: Long? = null,
        @ProtoField(2) var ccCmd: Long? = null,
        @ProtoField(8) var uid: String? = null,
    ) : ProtoMessage()
}