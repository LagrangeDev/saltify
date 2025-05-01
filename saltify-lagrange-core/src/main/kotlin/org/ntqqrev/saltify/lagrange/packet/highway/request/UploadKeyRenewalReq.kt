package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadKeyRenewalReq(
    @ProtoField(1) var oldUKey: String?,
    @ProtoField(2) var subType: Long,
) : ProtoMessage()