package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DownloadRKeyReq(
    @ProtoField(1) var types: List<Int>,
) : ProtoMessage()