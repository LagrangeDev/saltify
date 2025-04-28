package org.ntqqrev.saltify.lagrange.packet.oidb

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class OidbFetchGroupsRequest(
    @ProtoNumber(1) val config: Config,
) {
    @Serializable
    class Config(
        @ProtoNumber(1) val config1: Config1,
        @ProtoNumber(2) val config2: Config2,
        @ProtoNumber(3) val config3: Config3,
    ) {
        @Serializable
        class Config1(
            @ProtoNumber(1) val groupOwner: Boolean,
            @ProtoNumber(2) val field2: Boolean,
            @ProtoNumber(3) val memberMax: Boolean,
            @ProtoNumber(4) val memberCount: Boolean,
            @ProtoNumber(5) val groupName: Boolean,
            @ProtoNumber(8) val field8: Boolean,
            @ProtoNumber(9) val field9: Boolean,
            @ProtoNumber(10) val field10: Boolean,
            @ProtoNumber(11) val field11: Boolean,
            @ProtoNumber(12) val field12: Boolean,
            @ProtoNumber(13) val field13: Boolean,
            @ProtoNumber(14) val field14: Boolean,
            @ProtoNumber(15) val field15: Boolean,
            @ProtoNumber(16) val field16: Boolean,
            @ProtoNumber(17) val field17: Boolean,
            @ProtoNumber(18) val field18: Boolean,
            @ProtoNumber(19) val question: Boolean,
            @ProtoNumber(20) val field20: Boolean,
            @ProtoNumber(22) val field22: Boolean,
            @ProtoNumber(23) val field23: Boolean,
            @ProtoNumber(24) val field24: Boolean,
            @ProtoNumber(25) val field25: Boolean,
            @ProtoNumber(26) val field26: Boolean,
            @ProtoNumber(27) val field27: Boolean,
            @ProtoNumber(28) val field28: Boolean,
            @ProtoNumber(29) val field29: Boolean,
            @ProtoNumber(30) val field30: Boolean,
            @ProtoNumber(31) val field31: Boolean,
            @ProtoNumber(32) val field32: Boolean,
            @ProtoNumber(5001) val field5001: Boolean,
            @ProtoNumber(5002) val field5002: Boolean,
            @ProtoNumber(5003) val field5003: Boolean,
        )

        @Serializable
        class Config2(
            @ProtoNumber(1) val field1: Boolean,
            @ProtoNumber(2) val field2: Boolean,
            @ProtoNumber(3) val field3: Boolean,
            @ProtoNumber(4) val field4: Boolean,
            @ProtoNumber(5) val field5: Boolean,
            @ProtoNumber(6) val field6: Boolean,
            @ProtoNumber(7) val field7: Boolean,
            @ProtoNumber(8) val field8: Boolean,
        )

        @Serializable
        class Config3(
            @ProtoNumber(5) val field5: Boolean,
            @ProtoNumber(6) val field6: Boolean,
        )
    }
}

@Serializable
class OidbFetchGroupsResponse(
    @ProtoNumber(2) val entries: List<Entry>,
) {
    @Serializable
    class Entry(
        @ProtoNumber(3) val groupUin: Long,
        @ProtoNumber(4) val info: Info,
        @ProtoNumber(5) val customInfo: CustomInfo?,
    ) {
        @Serializable
        class Info(
            @ProtoNumber(1) val groupOwner: Member?,
            @ProtoNumber(2) val createdTime: Long,
            @ProtoNumber(3) val memberMax: Int,
            @ProtoNumber(4) val memberCount: Int,
            @ProtoNumber(5) val groupName: String?,
            @ProtoNumber(18) val description: String?,
            @ProtoNumber(19) val question: String?,
            @ProtoNumber(30) val announcement: String?,
        ) {
            @Serializable
            class Member(
                @ProtoNumber(2) val uid: String?,
            )
        }

        @Serializable
        class CustomInfo(
            @ProtoNumber(3) val remark: String?,
        )
    }
}
