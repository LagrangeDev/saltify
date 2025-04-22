package org.ntqqrev.saltify.core.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class RegisterInfo(
    val guid: String,
    val kickPC: Int = 0,
    val currentVersion: String,
    val isFirstRegisterProxyOnline: Int = 0,
    val localeId: Int = 2052,
    val device: DeviceInfo,
    val setMute: Int = 0,
    val registerVendorType: Int = 6,
    val regType: Int = 0,
    val businessInfo: BusinessInfo = BusinessInfo(
        notifySwitch = 1,
        bindUinNotifySwitch = 1,
    ),
    val batteryStatus: Int = 0,
    val field12: Int = 0,
)

