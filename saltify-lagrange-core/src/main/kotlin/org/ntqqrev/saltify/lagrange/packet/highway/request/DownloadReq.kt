package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DownloadReq(
    @ProtoField(1) var node: IndexNode?,
    @ProtoField(2) var ext: Ext? = null,
) : ProtoMessage() {
    class Ext(
        @ProtoField(1) var pic: Pic?,
        @ProtoField(2) var video: Video?,
        @ProtoField(3) var ptt: Ptt?,
    ) : ProtoMessage() {
        class Pic() : ProtoMessage()

        class Video(
            @ProtoField(1) var busiType: Long,
            @ProtoField(2) var sceneType: Long,
            @ProtoField(3) var subBusiType: Long,
        ) : ProtoMessage()

        class Ptt() : ProtoMessage()
    }
}