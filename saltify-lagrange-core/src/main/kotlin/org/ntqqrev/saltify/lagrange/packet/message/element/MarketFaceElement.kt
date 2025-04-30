package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MarketFaceElement(
    @ProtoField(1) var summary: String?,
    @ProtoField(2) var itemType: Int,
    @ProtoField(3) var info: Int,
    @ProtoField(4) var faceId: ByteArray?,
    @ProtoField(5) var tabId: Int,
    @ProtoField(6) var subType: Int,
    @ProtoField(7) var key: String?,
    @ProtoField(10) var width: Int,
    @ProtoField(11) var height: Int,
    @ProtoField(13) var pbReserve: Reserve?,
) : ProtoMessage() {
    class Reserve(
        @ProtoField(8) var field8: Int,
    ) : ProtoMessage()
}