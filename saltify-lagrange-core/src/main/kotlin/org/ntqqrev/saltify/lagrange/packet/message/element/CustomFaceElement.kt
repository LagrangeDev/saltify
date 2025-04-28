package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.PbReserve1

@Serializable
class CustomFaceElement(
    @ProtoNumber(1) val guid: ByteArray?,
    @ProtoNumber(2) val filePath: String?,
    @ProtoNumber(3) val shortcut: String?,
    @ProtoNumber(4) val buffer: ByteArray?,
    @ProtoNumber(5) val flag: ByteArray?,
    @ProtoNumber(6) val oldData: ByteArray?,
    @ProtoNumber(7) val fileId: Long,
    @ProtoNumber(8) val serverIp: Int?,
    @ProtoNumber(9) val serverPort: Int?,
    @ProtoNumber(10) val fileType: Int,
    @ProtoNumber(11) val signature: ByteArray?,
    @ProtoNumber(12) val useful: Int,
    @ProtoNumber(13) val md5: ByteArray?,
    @ProtoNumber(14) val thumbUrl: String?,
    @ProtoNumber(15) val bigUrl: String?,
    @ProtoNumber(16) val origUrl: String?,
    @ProtoNumber(17) val bizType: Int,
    @ProtoNumber(18) val repeatIndex: Int,
    @ProtoNumber(19) val repeatImage: Int,
    @ProtoNumber(20) val imageType: Int,
    @ProtoNumber(21) val index: Int,
    @ProtoNumber(22) val width: Int,
    @ProtoNumber(23) val height: Int,
    @ProtoNumber(24) val source: Int,
    @ProtoNumber(25) val size: Long,
    @ProtoNumber(26) val origin: Int,
    @ProtoNumber(27) val thumbWidth: Int?,
    @ProtoNumber(28) val thumbHeight: Int?,
    @ProtoNumber(29) val showLen: Int,
    @ProtoNumber(30) val downloadLen: Int,
    @ProtoNumber(31) val x400Url: String?,
    @ProtoNumber(32) val x400Width: Int,
    @ProtoNumber(33) val x400Height: Int,
    @ProtoNumber(34) val pbReserve: PbReserve1?,
) : ElementType