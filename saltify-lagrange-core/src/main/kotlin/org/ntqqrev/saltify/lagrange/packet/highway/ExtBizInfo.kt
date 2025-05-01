package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class ExtBizInfo(
    @ProtoField(1) var pic: Pic?,
    @ProtoField(2) var video: Video?,
    @ProtoField(3) var ptt: Ptt?,
    @ProtoField(10) var busiType: Long,
) : ProtoMessage() {
    class Pic(
        @ProtoField(1) var bizType: Long,
        @ProtoField(2) var textSummary: String?,
        @ProtoField(11) var bytesPbReserveC2c: ByteArray?,
        @ProtoField(12) var bytesPbReserveTroop: ByteArray?,
        @ProtoField(1001) var fromScene: Long,
        @ProtoField(1002) var toScene: Long,
        @ProtoField(1003) var oldFileId: Long,
    ) : ProtoMessage()

    class Video(
        @ProtoField(1) var fromScene: Long,
        @ProtoField(2) var toScene: Long,
        @ProtoField(3) var bytesPbReserve: ByteArray?,
    ) : ProtoMessage()

    class Ptt(
        @ProtoField(1) var srcUin: Long,
        @ProtoField(2) var pttScene: Long,
        @ProtoField(3) var pttType: Long,
        @ProtoField(4) var changeVoice: Long,
        @ProtoField(5) var waveform: ByteArray?,
        @ProtoField(6) var autoConvertText: Long,
        @ProtoField(11) var bytesReserve: ByteArray?,
        @ProtoField(12) var bytesPbReserve: ByteArray?,
        @ProtoField(13) var bytesGeneralFlags: ByteArray?,
    ) : ProtoMessage()
}