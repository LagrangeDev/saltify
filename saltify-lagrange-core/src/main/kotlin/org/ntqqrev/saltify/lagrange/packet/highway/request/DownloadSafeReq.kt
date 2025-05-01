package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.IndexNode
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DownloadSafeReq(
    @ProtoField(1) var index: IndexNode?,
) : ProtoMessage()