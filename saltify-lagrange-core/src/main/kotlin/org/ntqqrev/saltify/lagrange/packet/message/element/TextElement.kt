package org.ntqqrev.saltify.lagrange.packet.message.element

import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.MentionExtra
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class TextElement(
    @ProtoField(1) var str: String?,
    @ProtoField(2) var link: String?,
    @ProtoField(3) var attr6Buf: ByteArray?,
    @ProtoField(4) var attr7Buf: ByteArray?,
    @ProtoField(11) var buf: ByteArray?,
    @ProtoField(12) var mentionExtra: MentionExtra?,
) : ProtoMessage()