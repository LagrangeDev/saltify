package org.ntqqrev.saltify.lagrange.packet.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class FetchFriendsRequest(
    @ProtoNumber(2) val friendCount: Int,
    @ProtoNumber(5) val nextUin: UinBody,
    @ProtoNumber(10001) val body: Map<Int, NumberList>,
) {
    @Serializable
    class NumberList(
        @ProtoNumber(1) val numbers: List<Int>,
    )
}

@Serializable
class FetchFriendsResponse(
    @ProtoNumber(2) val next: UinBody?,
    @ProtoNumber(3) val displayFriendCount: Long,
    @ProtoNumber(6) val timestamp: Long,
    @ProtoNumber(7) val selfUin: Long,
    @ProtoNumber(101) val friends: List<Entry>,
    @ProtoNumber(102) val categories: List<Category>,
) {
    @Serializable
    class Entry(
        @ProtoNumber(1) val uid: String,
        @ProtoNumber(2) val category: Int?,
        @ProtoNumber(3) val uin: Long,
        @ProtoNumber(10001) val additional: Map<Int, Properties>,
    ) {
        @Serializable
        class Properties(
            @ProtoNumber(2) val properties: Map<Int, String>,
        )
    }

    @Serializable
    class Category(
        @ProtoNumber(2) val name: String,
        @ProtoNumber(3) val id: Int,
    )
}

@Serializable
class UinBody(
    @ProtoNumber(1) val uin: Long?,
)