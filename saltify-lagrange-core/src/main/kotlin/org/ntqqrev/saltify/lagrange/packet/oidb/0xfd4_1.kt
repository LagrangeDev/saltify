package org.ntqqrev.saltify.lagrange.packet.oidb

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class OidbFetchFriendsRequest(
    @ProtoField(2) var friendCount: Int,
    @ProtoField(5) var nextUin: UinBody,
    @ProtoField(10001) var body: Map<Int, NumberList>,
) : ProtoMessage() {
    class NumberList(
        @ProtoField(1) var numbers: List<Int>,
    ) : ProtoMessage()
}


class OidbFetchFriendsResponse(
    @ProtoField(2) var next: UinBody?,
    @ProtoField(3) var displayFriendCount: Long,
    @ProtoField(6) var timestamp: Long,
    @ProtoField(7) var selfUin: Long,
    @ProtoField(101) var friends: List<Entry>,
    @ProtoField(102) var categories: List<Category>,
) : ProtoMessage() {
    class Entry(
        @ProtoField(1) var uid: String,
        @ProtoField(2) var category: Int?,
        @ProtoField(3) var uin: Long,
        @ProtoField(10001) var additional: Map<Int, Properties>,
    ) : ProtoMessage() {
        class Properties(
            @ProtoField(2) var properties: Map<Int, String>,
        ) : ProtoMessage()
    }

    class Category(
        @ProtoField(2) var name: String,
        @ProtoField(3) var id: Int,
    ) : ProtoMessage()
}

class UinBody(
    @ProtoField(1) var uin: Long?,
) : ProtoMessage()