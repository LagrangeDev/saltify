package org.ntqqrev.saltify.lagrange.packet.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class OidbFetchGroupMembersRequest(
    @ProtoNumber(1) val groupUin: Long,
    @ProtoNumber(2) val field2: Int,
    @ProtoNumber(3) val field3: Int,
    @ProtoNumber(4) val body: Body,
    @ProtoNumber(15) val token: String?,
) {
    @Serializable
    class Body(
        @ProtoNumber(10) val memberName: Boolean,
        @ProtoNumber(11) val memberCard: Boolean,
        @ProtoNumber(12) val level: Boolean,
        @ProtoNumber(13) val field13: Boolean,
        @ProtoNumber(16) val field16: Boolean,
        @ProtoNumber(17) val specialTitle: Boolean,
        @ProtoNumber(18) val field18: Boolean,
        @ProtoNumber(20) val field20: Boolean,
        @ProtoNumber(21) val field21: Boolean,
        @ProtoNumber(100) val joinTimestamp: Boolean,
        @ProtoNumber(101) val lastMsgTimestamp: Boolean,
        @ProtoNumber(102) val shutUpTimestamp: Boolean,
        @ProtoNumber(103) val field103: Boolean,
        @ProtoNumber(104) val field104: Boolean,
        @ProtoNumber(105) val field105: Boolean,
        @ProtoNumber(106) val field106: Boolean,
        @ProtoNumber(107) val permission: Boolean,
        @ProtoNumber(200) val field200: Boolean,
        @ProtoNumber(201) val field201: Boolean,
    )
}

@Serializable
class OidbFetchGroupMembersResponse(
    @ProtoNumber(1) val groupUin: Long,
    @ProtoNumber(2) val entries: List<Entry>,
    @ProtoNumber(3) val field3: Long,
    @ProtoNumber(5) val memberChangeSeq: Long,
    @ProtoNumber(6) val memberCardChangeSeq: Long,
    @ProtoNumber(15) val token: String?,
) {
    @Serializable
    class Entry(
        @ProtoNumber(1) val identity: Identity,
        @ProtoNumber(10) val memberName: String?,
        @ProtoNumber(17) val specialTitle: String?,
        @ProtoNumber(11) val memberCard: Card?,
        @ProtoNumber(12) val level: Level?,
        @ProtoNumber(100) val joinTimestamp: Long,
        @ProtoNumber(101) val lastMsgTimestamp: Long,
        @ProtoNumber(102) val shutUpTimestamp: Long?,
        @ProtoNumber(107) val permission: Int = 0,
    ) {
        @Serializable
        class Identity(
            @ProtoNumber(2) val uid: String,
            @ProtoNumber(4) val uin: Long,
        )

        @Serializable
        class Card(
            @ProtoNumber(2) val memberCard: String?,
        )

        @Serializable
        class Level(
            @ProtoNumber(1) val infos: List<Int>,
            @ProtoNumber(2) val level: Int,
        )

    }
}