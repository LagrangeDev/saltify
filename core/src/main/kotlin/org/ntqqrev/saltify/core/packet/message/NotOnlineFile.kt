package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class NotOnlineFile(
    @ProtoNumber(1) val fileType: Int?,
    @ProtoNumber(2) val sig: ByteArray?,
    @ProtoNumber(3) val fileUuid: String?,
    @ProtoNumber(4) val fileMd5: ByteArray?,
    @ProtoNumber(5) val fileName: String?,
    @ProtoNumber(6) val fileSize: Long?,
    @ProtoNumber(7) val note: ByteArray?,
    @ProtoNumber(8) val reserved: Int?,
    @ProtoNumber(9) val subCmd: Int?,
    @ProtoNumber(10) val microCloud: Int?,
    @ProtoNumber(11) val bytesFileUrls: List<ByteArray>?,
    @ProtoNumber(12) val downloadFlag: Int?,
    @ProtoNumber(50) val dangerLevel: Int?,
    @ProtoNumber(51) val lifeTime: Int?,
    @ProtoNumber(52) val uploadTime: Int?,
    @ProtoNumber(53) val absFileType: Int?,
    @ProtoNumber(54) val clientType: Int?,
    @ProtoNumber(55) val expireTime: Int?,
    @ProtoNumber(56) val pbReserve: ByteArray?,
    @ProtoNumber(57) val fileHash: String?,
)