package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class OnlineImageElement(
    @ProtoField(1) var guid: ByteArray?,
    @ProtoField(2) var filePath: ByteArray?,
    @ProtoField(3) var oldVerSendFile: ByteArray?,
) : ProtoMessage()