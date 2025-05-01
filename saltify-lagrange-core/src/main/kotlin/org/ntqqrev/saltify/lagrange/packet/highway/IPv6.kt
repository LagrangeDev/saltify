package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class IPv6(
    @ProtoField(1) var outIP: ByteArray?,
    @ProtoField(2) var outPort: Long,
    @ProtoField(3) var iniP: ByteArray?,
    @ProtoField(4) var inPort: Long,
    @ProtoField(5) var ipType: Long,
) : ProtoMessage()