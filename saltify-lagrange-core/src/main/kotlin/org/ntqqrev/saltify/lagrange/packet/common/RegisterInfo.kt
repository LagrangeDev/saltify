package org.ntqqrev.saltify.lagrange.packet.common

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class RegisterInfo(
    @ProtoField(1) var guid: String,
    @ProtoField(3) var currentVersion: String,
    @ProtoField(6) var device: DeviceInfo,
    @ProtoField(10) var businessInfo: BusinessInfo = BusinessInfo(
        notifySwitch = 1,
        bindUinNotifySwitch = 1,
    ),
) : ProtoMessage()

