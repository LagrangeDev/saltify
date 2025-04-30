package org.ntqqrev.saltify.lagrange.packet.common

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DeviceInfo(
    @ProtoField(1) var user: String,
    @ProtoField(2) var os: String,
    @ProtoField(3) var osVer: String,
    @ProtoField(4) var vendorName: String? = null,
    @ProtoField(5) var osLower: String,
) : ProtoMessage()