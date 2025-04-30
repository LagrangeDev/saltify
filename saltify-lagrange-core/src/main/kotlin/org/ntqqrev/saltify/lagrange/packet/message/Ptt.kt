package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class Ptt(
    @ProtoField(1) var fileType: Int? = null,
    @ProtoField(2) var srcUin: Long? = null,
    @ProtoField(3) var fileUuid: String? = null,
    @ProtoField(4) var fileMd5: ByteArray? = null,
    @ProtoField(5) var fileName: String? = null,
    @ProtoField(6) var fileSize: Int? = null,
    @ProtoField(7) var reserve: ByteArray? = null,
    @ProtoField(8) var fileId: Int? = null,
    @ProtoField(9) var serverIp: Int? = null,
    @ProtoField(10) var serverPort: Int? = null,
    @ProtoField(11) var boolValid: Boolean? = null,
    @ProtoField(12) var signature: ByteArray? = null,
    @ProtoField(13) var shortcut: ByteArray? = null,
    @ProtoField(14) var fileKey: ByteArray? = null,
    @ProtoField(15) var magicPttIndex: Int? = null,
    @ProtoField(16) var voiceSwitch: Int? = null,
    @ProtoField(17) var pttUrl: ByteArray? = null,
    @ProtoField(18) var groupFileKey: String? = null,
    @ProtoField(19) var time: Int? = null,
    @ProtoField(20) var downPara: ByteArray? = null,
    @ProtoField(29) var format: Int? = null,
    @ProtoField(30) var pbReserve: ByteArray? = null,
    @ProtoField(31) var bytesPttUrls: List<ByteArray>? = null,
    @ProtoField(32) var downloadFlag: Int? = null
) : ProtoMessage()