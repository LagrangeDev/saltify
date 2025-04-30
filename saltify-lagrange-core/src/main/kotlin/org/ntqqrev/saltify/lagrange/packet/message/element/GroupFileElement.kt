package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class GroupFileElement(
    @ProtoField(1) var filename: ByteArray?,
    @ProtoField(2) var fileSize: Long,
    @ProtoField(3) var fileId: ByteArray?,
    @ProtoField(4) var batchId: ByteArray?,
    @ProtoField(5) var fileKey: ByteArray?,
    @ProtoField(6) var mark: ByteArray?,
    @ProtoField(7) var sequence: Long,
    @ProtoField(8) var batchItemId: ByteArray?,
    @ProtoField(9) var feedMsgTime: Int,
    @ProtoField(10) var pbReserve: ByteArray?,
) : ProtoMessage()