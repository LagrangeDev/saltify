package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class RichText(
    @ProtoField(1) var attr: Attr? = null,
    @ProtoField(2) var elements: List<ByteArray>,
    @ProtoField(3) var notOnlineFile: NotOnlineFile? = null,
    @ProtoField(4) var ptt: Ptt? = null,
) : ProtoMessage()