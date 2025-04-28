package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.PbReserve

@Serializable
class NotOnlineImageElement(
    @ProtoNumber(1) val filePath: String?,
    @ProtoNumber(2) val fileLen: Long,
    @ProtoNumber(3) val downloadPath: String?,
    @ProtoNumber(4) val oldVerSendFile: ByteArray?,
    @ProtoNumber(5) val imgType: Int,
    @ProtoNumber(6) val previewsImage: ByteArray?,
    @ProtoNumber(7) val picMd5: ByteArray?,
    @ProtoNumber(8) val picHeight: Long,
    @ProtoNumber(9) val picWidth: Long,
    @ProtoNumber(10) val resId: String?,
    @ProtoNumber(11) val flag: ByteArray?,
    @ProtoNumber(12) val thumbUrl: String?,
    @ProtoNumber(13) val original: Int,
    @ProtoNumber(14) val bigUrl: String?,
    @ProtoNumber(15) val origUrl: String?,
    @ProtoNumber(16) val bizType: Int,
    @ProtoNumber(17) val result: Int,
    @ProtoNumber(18) val index: Int,
    @ProtoNumber(19) val opFaceBuf: ByteArray?,
    @ProtoNumber(20) val oldPicMd5: Boolean,
    @ProtoNumber(21) val thumbWidth: Int,
    @ProtoNumber(22) val thumbHeight: Int,
    @ProtoNumber(23) val fileId: Int,
    @ProtoNumber(24) val showLen: Long,
    @ProtoNumber(25) val downloadLen: Long,
    @ProtoNumber(26) val x400Url: String?,
    @ProtoNumber(27) val x400Width: Long,
    @ProtoNumber(28) val x400Height: Long,
    @ProtoNumber(29) val pbRes: PbReserve?,
)