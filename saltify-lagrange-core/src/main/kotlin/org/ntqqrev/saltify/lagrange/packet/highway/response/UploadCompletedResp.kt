package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadCompletedResp(
    @ProtoField(1) var msgSeq: Long,
) : ProtoMessage()