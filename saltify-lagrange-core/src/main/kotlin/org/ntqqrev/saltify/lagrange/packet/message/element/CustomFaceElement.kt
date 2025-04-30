package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.PbReserve1
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class CustomFaceElement(
    @ProtoField(1) var guid: ByteArray?,
    @ProtoField(2) var filePath: String?,
    @ProtoField(3) var shortcut: String?,
    @ProtoField(4) var buffer: ByteArray?,
    @ProtoField(5) var flag: ByteArray?,
    @ProtoField(6) var oldData: ByteArray?,
    @ProtoField(7) var fileId: Long,
    @ProtoField(8) var serverIp: Int?,
    @ProtoField(9) var serverPort: Int?,
    @ProtoField(10) var fileType: Int,
    @ProtoField(11) var signature: ByteArray?,
    @ProtoField(12) var useful: Int,
    @ProtoField(13) var md5: ByteArray?,
    @ProtoField(14) var thumbUrl: String?,
    @ProtoField(15) var bigUrl: String?,
    @ProtoField(16) var origUrl: String?,
    @ProtoField(17) var bizType: Int,
    @ProtoField(18) var repeatIndex: Int,
    @ProtoField(19) var repeatImage: Int,
    @ProtoField(20) var imageType: Int,
    @ProtoField(21) var index: Int,
    @ProtoField(22) var width: Int,
    @ProtoField(23) var height: Int,
    @ProtoField(24) var source: Int,
    @ProtoField(25) var size: Long,
    @ProtoField(26) var origin: Int,
    @ProtoField(27) var thumbWidth: Int?,
    @ProtoField(28) var thumbHeight: Int?,
    @ProtoField(29) var showLen: Int,
    @ProtoField(30) var downloadLen: Int,
    @ProtoField(31) var x400Url: String?,
    @ProtoField(32) var x400Width: Int,
    @ProtoField(33) var x400Height: Int,
    @ProtoField(34) var pbReserve: PbReserve1?,
) : ProtoMessage()