package org.ntqqrev.saltify.core.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class DeviceInfo(
    val user: String,
    val os: String,
    val osVer: String,
    val vendorName: String? = null,
    val osLower: String,
)