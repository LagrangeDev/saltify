package org.ntqqrev.saltify.lagrange.packet.oidb

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class OidbFetchGroupsRequest(
    @ProtoField(1) var config: Config,
) : ProtoMessage() {

    class Config(
        @ProtoField(1) var config1: Config1,
        @ProtoField(2) var config2: Config2,
        @ProtoField(3) var config3: Config3,
    ) : ProtoMessage() {

        class Config1(
            @ProtoField(1) var groupOwner: Boolean,
            @ProtoField(2) var field2: Boolean,
            @ProtoField(3) var memberMax: Boolean,
            @ProtoField(4) var memberCount: Boolean,
            @ProtoField(5) var groupName: Boolean,
            @ProtoField(8) var field8: Boolean,
            @ProtoField(9) var field9: Boolean,
            @ProtoField(10) var field10: Boolean,
            @ProtoField(11) var field11: Boolean,
            @ProtoField(12) var field12: Boolean,
            @ProtoField(13) var field13: Boolean,
            @ProtoField(14) var field14: Boolean,
            @ProtoField(15) var field15: Boolean,
            @ProtoField(16) var field16: Boolean,
            @ProtoField(17) var field17: Boolean,
            @ProtoField(18) var field18: Boolean,
            @ProtoField(19) var question: Boolean,
            @ProtoField(20) var field20: Boolean,
            @ProtoField(22) var field22: Boolean,
            @ProtoField(23) var field23: Boolean,
            @ProtoField(24) var field24: Boolean,
            @ProtoField(25) var field25: Boolean,
            @ProtoField(26) var field26: Boolean,
            @ProtoField(27) var field27: Boolean,
            @ProtoField(28) var field28: Boolean,
            @ProtoField(29) var field29: Boolean,
            @ProtoField(30) var field30: Boolean,
            @ProtoField(31) var field31: Boolean,
            @ProtoField(32) var field32: Boolean,
            @ProtoField(5001) var field5001: Boolean,
            @ProtoField(5002) var field5002: Boolean,
            @ProtoField(5003) var field5003: Boolean,
        ) : ProtoMessage()

        class Config2(
            @ProtoField(1) var field1: Boolean,
            @ProtoField(2) var field2: Boolean,
            @ProtoField(3) var field3: Boolean,
            @ProtoField(4) var field4: Boolean,
            @ProtoField(5) var field5: Boolean,
            @ProtoField(6) var field6: Boolean,
            @ProtoField(7) var field7: Boolean,
            @ProtoField(8) var field8: Boolean,
        ) : ProtoMessage()

        class Config3(
            @ProtoField(5) var field5: Boolean,
            @ProtoField(6) var field6: Boolean,
        ) : ProtoMessage()
    }
}


class OidbFetchGroupsResponse(
    @ProtoField(2) var entries: List<Entry>,
) : ProtoMessage() {

    class Entry(
        @ProtoField(3) var groupUin: Long,
        @ProtoField(4) var info: Info,
        @ProtoField(5) var customInfo: CustomInfo?,
    ) : ProtoMessage() {

        class Info(
            @ProtoField(1) var groupOwner: Member?,
            @ProtoField(2) var createdTime: Long,
            @ProtoField(3) var memberMax: Int,
            @ProtoField(4) var memberCount: Int,
            @ProtoField(5) var groupName: String?,
            @ProtoField(18) var description: String?,
            @ProtoField(19) var question: String?,
            @ProtoField(30) var announcement: String?,
        ) : ProtoMessage() {

            class Member(
                @ProtoField(2) var uid: String?,
            ) : ProtoMessage()
        }

        class CustomInfo(
            @ProtoField(3) var remark: String?,
        ) : ProtoMessage()
    }
}
