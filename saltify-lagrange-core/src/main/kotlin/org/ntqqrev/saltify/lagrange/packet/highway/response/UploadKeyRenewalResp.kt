package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadKeyRenewalResp(
    @ProtoField(1) var ukey: String?,
    @ProtoField(2) var ukeyTtlSec: Long,
) : ProtoMessage()