package org.ntqqrev.saltify.lagrange.packet.login

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class Tlv543Body(
    @ProtoField(9) var layer1: Layer1,
) : ProtoMessage() {
    class Layer1(
        @ProtoField(11) var layer2: Layer2,
    ) : ProtoMessage() {
        class Layer2(
            @ProtoField(1) var uid: String,
        ) : ProtoMessage()
    }
}
