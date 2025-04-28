package org.ntqqrev.saltify.lagrange.packet.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class RegisterInfo(
    @ProtoNumber(1) val guid: String,
    @ProtoNumber(3) val currentVersion: String,
    @ProtoNumber(6) val device: DeviceInfo,
    @ProtoNumber(10) val businessInfo: BusinessInfo = BusinessInfo(
        notifySwitch = 1,
        bindUinNotifySwitch = 1,
    ),
)

