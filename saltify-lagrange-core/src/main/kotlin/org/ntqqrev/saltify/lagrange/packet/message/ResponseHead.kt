package org.ntqqrev.saltify.lagrange.packet.message


import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField


class ResponseHead(
    @ProtoField(1) var fromUin: Long,
    @ProtoField(2) var fromUid: String?,
    @ProtoField(3) var type: Long,
    @ProtoField(4) var sigMap: Long,
    @ProtoField(5) var toUin: Long,
    @ProtoField(6) var toUid: String?,
    @ProtoField(7) var friendExt: FriendExt?,
    @ProtoField(8) var groupExt: GroupExt?,
) : ProtoMessage() {
    class FriendExt(
        @ProtoField(6) var friendName: String?,
    ) : ProtoMessage()

    class GroupExt(
        @ProtoField(1) var groupUin: Long,
        @ProtoField(4) var memberName: String?,
        @ProtoField(5) var unknown5: Long,
        @ProtoField(7) var groupName: String,
    ) : ProtoMessage()
}