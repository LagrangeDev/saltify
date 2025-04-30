package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NotOnlineFile(
    @ProtoField(1) var fileType: Int?,
    @ProtoField(2) var sig: ByteArray?,
    @ProtoField(3) var fileUuid: String?,
    @ProtoField(4) var fileMd5: ByteArray?,
    @ProtoField(5) var fileName: String?,
    @ProtoField(6) var fileSize: Long?,
    @ProtoField(7) var note: ByteArray?,
    @ProtoField(8) var reserved: Int?,
    @ProtoField(9) var subCmd: Int?,
    @ProtoField(10) var microCloud: Int?,
    @ProtoField(11) var bytesFileUrls: List<ByteArray>?,
    @ProtoField(12) var downloadFlag: Int?,
    @ProtoField(50) var dangerLevel: Int?,
    @ProtoField(51) var lifeTime: Int?,
    @ProtoField(52) var uploadTime: Int?,
    @ProtoField(53) var absFileType: Int?,
    @ProtoField(54) var clientType: Int?,
    @ProtoField(55) var expireTime: Int?,
    @ProtoField(56) var pbReserve: ByteArray?,
    @ProtoField(57) var fileHash: String?,
) : ProtoMessage()