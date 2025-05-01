package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.CommonHead
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MultiMediaReqHead(
    @ProtoField(1) var common: CommonHead?,
    @ProtoField(2) var scene: SceneInfo?,
    @ProtoField(3) var client: ClientMeta?,
) : ProtoMessage() {
    class SceneInfo(
        @ProtoField(101) var requestType: Long,
        @ProtoField(102) var businessType: Long,
        @ProtoField(103) var field103: Long,
        @ProtoField(200) var sceneType: Long,
        @ProtoField(201) var c2c: C2C?,
        @ProtoField(202) var group: Group?,
    ) : ProtoMessage() {
        class C2C(
            @ProtoField(1) var accountType: Long,
            @ProtoField(2) var targetUid: String?,
        ) : ProtoMessage()

        class Group(
            @ProtoField(1) var groupUin: Long,
        ) : ProtoMessage()
    }

    class ClientMeta(
        @ProtoField(1) var agentType: Long,
    ) : ProtoMessage()
}