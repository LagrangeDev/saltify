package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.CommonHead
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MultiMediaReqHead(
    @ProtoField(1) var common: CommonHead?,
    @ProtoField(2) var scene: SceneInfo?,
    @ProtoField(3) var client: ClientMeta = ClientMeta(2),
) : ProtoMessage() {
    class SceneInfo(
        @ProtoField(101) var requestType: Int,
        @ProtoField(102) var businessType: Int,
        @ProtoField(103) var field103: Int = 0,
        @ProtoField(200) var sceneType: Int,
        @ProtoField(201) var c2c: C2C? = null,
        @ProtoField(202) var group: Group? = null,
    ) : ProtoMessage() {
        class C2C(
            @ProtoField(1) var accountType: Int,
            @ProtoField(2) var targetUid: String?,
        ) : ProtoMessage()

        class Group(
            @ProtoField(1) var groupUin: Long = 0L,
        ) : ProtoMessage()
    }

    class ClientMeta(
        @ProtoField(1) var agentType: Int = 2,
    ) : ProtoMessage()
}