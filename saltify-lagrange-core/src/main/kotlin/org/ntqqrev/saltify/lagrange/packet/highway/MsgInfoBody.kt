package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MsgInfoBody(
    @ProtoField(1) var index: IndexNode?,
    @ProtoField(2) var picture: Picture?,
    @ProtoField(3) var video: Video?,
    @ProtoField(4) var audio: Audio?,
    @ProtoField(5) var fileExist: Boolean,
    @ProtoField(6) var hashSum: HashSum?,
) : ProtoMessage() {
    class Picture(
        @ProtoField(1) var urlPath: String?,
        @ProtoField(2) var ext: Ext?,
        @ProtoField(3) var domain: String?,
    ) : ProtoMessage() {
        class Ext(
            @ProtoField(1) var originalParameter: String?,
            @ProtoField(2) var bigParameter: String?,
            @ProtoField(3) var thumbParameter: String?,
        ) : ProtoMessage()
    }

    class Video() : ProtoMessage() {
        class Ext(
            @ProtoField(1) var videoCodecFormat: Long,
        ) : ProtoMessage()
    }

    class Audio() : ProtoMessage()

    class HashSum() : ProtoMessage()
}