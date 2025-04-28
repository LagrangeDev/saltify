package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class Ptt(
    @ProtoNumber(1) val fileType: Int? = null,
    @ProtoNumber(2) val srcUin: Long? = null,
    @ProtoNumber(3) val fileUuid: String? = null,
    @ProtoNumber(4) val fileMd5: ByteArray? = null,
    @ProtoNumber(5) val fileName: String? = null,
    @ProtoNumber(6) val fileSize: Int? = null,
    @ProtoNumber(7) val reserve: ByteArray? = null,
    @ProtoNumber(8) val fileId: Int? = null,
    @ProtoNumber(9) val serverIp: Int? = null,
    @ProtoNumber(10) val serverPort: Int? = null,
    @ProtoNumber(11) val boolValid: Boolean? = null,
    @ProtoNumber(12) val signature: ByteArray? = null,
    @ProtoNumber(13) val shortcut: ByteArray? = null,
    @ProtoNumber(14) val fileKey: ByteArray? = null,
    @ProtoNumber(15) val magicPttIndex: Int? = null,
    @ProtoNumber(16) val voiceSwitch: Int? = null,
    @ProtoNumber(17) val pttUrl: ByteArray? = null,
    @ProtoNumber(18) val groupFileKey: String? = null,
    @ProtoNumber(19) val time: Int? = null,
    @ProtoNumber(20) val downPara: ByteArray? = null,
    @ProtoNumber(29) val format: Int? = null,
    @ProtoNumber(30) val pbReserve: ByteArray? = null,
    @ProtoNumber(31) val bytesPttUrls: List<ByteArray>? = null,
    @ProtoNumber(32) val downloadFlag: Int? = null
)