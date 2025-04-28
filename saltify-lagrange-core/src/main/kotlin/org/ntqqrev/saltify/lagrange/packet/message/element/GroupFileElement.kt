package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class GroupFileElement(
    @ProtoNumber(1) val filename: ByteArray?,
    @ProtoNumber(2) val fileSize: Long,
    @ProtoNumber(3) val fileId: ByteArray?,
    @ProtoNumber(4) val batchId: ByteArray?,
    @ProtoNumber(5) val fileKey: ByteArray?,
    @ProtoNumber(6) val mark: ByteArray?,
    @ProtoNumber(7) val sequence: Long,
    @ProtoNumber(8) val batchItemId: ByteArray?,
    @ProtoNumber(9) val feedMsgTime: Int,
    @ProtoNumber(10) val pbReserve: ByteArray?,
) : ElementType