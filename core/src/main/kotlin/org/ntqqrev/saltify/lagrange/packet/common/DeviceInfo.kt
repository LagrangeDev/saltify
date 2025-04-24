package org.ntqqrev.saltify.lagrange.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class DeviceInfo(
    val user: String,
    val os: String,
    val osVer: String,
    val vendorName: String? = null,
    val osLower: String,
)