package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class MarketFaceElement(
    @ProtoNumber(1) val summary: String?,
    @ProtoNumber(2) val itemType: Int,
    @ProtoNumber(3) val info: Int,
    @ProtoNumber(4) val faceId: ByteArray?,
    @ProtoNumber(5) val tabId: Int,
    @ProtoNumber(6) val subType: Int,
    @ProtoNumber(7) val key: String?,
    @ProtoNumber(10) val width: Int,
    @ProtoNumber(11) val height: Int,
    @ProtoNumber(13) val pbReserve: Reserve?,
) : ElementType {
    @Serializable
    class Reserve(
        @ProtoNumber(8) val field8: Int,
    )
}