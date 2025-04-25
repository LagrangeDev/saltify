package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.MentionExtra

@Serializable
class TextElement(
    @ProtoNumber(1) val str: String?,
    @ProtoNumber(2) val link: String?,
    @ProtoNumber(3) val attr6Buf: ByteArray?,
    @ProtoNumber(4) val attr7Buf: ByteArray?,
    @ProtoNumber(11) val buf: ByteArray?,
    @ProtoNumber(12) val mentionExtra: MentionExtra?,
) : ElementType