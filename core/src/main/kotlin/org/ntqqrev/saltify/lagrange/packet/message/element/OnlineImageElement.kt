package org.ntqqrev.saltify.lagrange.packet.message.element

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class OnlineImageElement(
    @ProtoNumber(1) val guid: ByteArray?,
    @ProtoNumber(2) val filePath: ByteArray?,
    @ProtoNumber(3) val oldVerSendFile: ByteArray?,
) : ElementType