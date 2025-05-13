package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MessageBody(
    @ProtoField(1) var richText: RichText,
    @ProtoField(2) var msgContent: ByteArray? = null,
    @ProtoField(3) var msgEncryptContent: ByteArray? = null,
) : ProtoMessage()