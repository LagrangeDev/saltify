package org.ntqqrev.saltify.lagrange.packet.common

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class BusinessInfo(
    @ProtoField(1) var notifySwitch: Int,
    @ProtoField(2) var bindUinNotifySwitch: Int,
) : ProtoMessage()