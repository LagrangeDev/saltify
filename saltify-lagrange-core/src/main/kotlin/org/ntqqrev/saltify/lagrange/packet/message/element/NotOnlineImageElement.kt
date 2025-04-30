package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.PbReserve
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NotOnlineImageElement(
    @ProtoField(1) var filePath: String?,
    @ProtoField(2) var fileLen: Long,
    @ProtoField(3) var downloadPath: String?,
    @ProtoField(4) var oldVerSendFile: ByteArray?,
    @ProtoField(5) var imgType: Int,
    @ProtoField(6) var previewsImage: ByteArray?,
    @ProtoField(7) var picMd5: ByteArray?,
    @ProtoField(8) var picHeight: Long,
    @ProtoField(9) var picWidth: Long,
    @ProtoField(10) var resId: String?,
    @ProtoField(11) var flag: ByteArray?,
    @ProtoField(12) var thumbUrl: String?,
    @ProtoField(13) var original: Int,
    @ProtoField(14) var bigUrl: String?,
    @ProtoField(15) var origUrl: String?,
    @ProtoField(16) var bizType: Int,
    @ProtoField(17) var result: Int,
    @ProtoField(18) var index: Int,
    @ProtoField(19) var opFaceBuf: ByteArray?,
    @ProtoField(20) var oldPicMd5: Boolean,
    @ProtoField(21) var thumbWidth: Int,
    @ProtoField(22) var thumbHeight: Int,
    @ProtoField(23) var fileId: Int,
    @ProtoField(24) var showLen: Long,
    @ProtoField(25) var downloadLen: Long,
    @ProtoField(26) var x400Url: String?,
    @ProtoField(27) var x400Width: Long,
    @ProtoField(28) var x400Height: Long,
    @ProtoField(29) var pbRes: PbReserve?,
) : ProtoMessage()