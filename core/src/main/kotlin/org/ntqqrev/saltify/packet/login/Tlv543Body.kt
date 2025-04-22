package org.ntqqrev.saltify.packet.login

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class Tlv543Body(
    @ProtoNumber(9) val layer1: Layer1,
) {
    @Serializable
    class Layer1(
        @ProtoNumber(11) val layer2: Layer2,
    ) {
        @Serializable
        class Layer2(
            @ProtoNumber(1) val uid: String,
        )
    }
}
