package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class FileInfo(
    @ProtoField(1) var fileSize: Long,
    @ProtoField(2) var fileHash: String?,
    @ProtoField(3) var fileSha1: String?,
    @ProtoField(4) var fileName: String?,
    @ProtoField(5) var type: Type?,
    @ProtoField(6) var width: Long,
    @ProtoField(7) var height: Long,
    @ProtoField(8) var time: Long,
    @ProtoField(9) var original: Long,
) : ProtoMessage() {
    class Type(
        @ProtoField(1) var type: Long,
        @ProtoField(2) var picFormat: Long,
        @ProtoField(3) var videoFormat: Long,
        @ProtoField(4) var voiceFormat: Long,
    ) : ProtoMessage()
}