package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class VideoFileElement(
    @ProtoNumber(1) val fileUuid: String?,
    @ProtoNumber(2) val fileMd5: ByteArray?,
    @ProtoNumber(3) val fileName: String?,
    @ProtoNumber(4) val fileFormat: Int,
    @ProtoNumber(5) val fileTime: Int,
    @ProtoNumber(6) val fileSize: Int,
    @ProtoNumber(7) val thumbWidth: Int,
    @ProtoNumber(8) val thumbHeight: Int,
    @ProtoNumber(9) val thumbFileMd5: ByteArray?,
    @ProtoNumber(10) val source: ByteArray?,
    @ProtoNumber(11) val thumbFileSize: Int,
    @ProtoNumber(12) val bizType: Int,
    @ProtoNumber(13) val fromChatType: Int,
    @ProtoNumber(14) val toChatType: Int,
    @ProtoNumber(15) val boolSupportProgressive: Boolean,
    @ProtoNumber(16) val fileWidth: Int,
    @ProtoNumber(17) val fileHeight: Int,
    @ProtoNumber(18) val subBizType: Int,
    @ProtoNumber(19) val videoAttr: Int,
    @ProtoNumber(20) val bytesThumbFileUrls: List<ByteArray>,
    @ProtoNumber(21) val bytesVideoFileUrls: List<ByteArray>,
    @ProtoNumber(22) val thumbDownloadFlag: Int,
    @ProtoNumber(23) val videoDownloadFlag: Int,
    @ProtoNumber(24) val pbReserve: ByteArray?,
) : ElementType