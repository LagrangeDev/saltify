package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class VideoFileElement(
    @ProtoField(1) var fileUuid: String?,
    @ProtoField(2) var fileMd5: ByteArray?,
    @ProtoField(3) var fileName: String?,
    @ProtoField(4) var fileFormat: Int,
    @ProtoField(5) var fileTime: Int,
    @ProtoField(6) var fileSize: Int,
    @ProtoField(7) var thumbWidth: Int,
    @ProtoField(8) var thumbHeight: Int,
    @ProtoField(9) var thumbFileMd5: ByteArray?,
    @ProtoField(10) var source: ByteArray?,
    @ProtoField(11) var thumbFileSize: Int,
    @ProtoField(12) var bizType: Int,
    @ProtoField(13) var fromChatType: Int,
    @ProtoField(14) var toChatType: Int,
    @ProtoField(15) var boolSupportProgressive: Boolean,
    @ProtoField(16) var fileWidth: Int,
    @ProtoField(17) var fileHeight: Int,
    @ProtoField(18) var subBizType: Int,
    @ProtoField(19) var videoAttr: Int,
    @ProtoField(20) var bytesThumbFileUrls: List<ByteArray>,
    @ProtoField(21) var bytesVideoFileUrls: List<ByteArray>,
    @ProtoField(22) var thumbDownloadFlag: Int,
    @ProtoField(23) var videoDownloadFlag: Int,
    @ProtoField(24) var pbReserve: ByteArray?,
) : ProtoMessage()