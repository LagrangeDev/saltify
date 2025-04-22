package org.ntqqrev.saltify.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class BusinessInfo(
    val notifySwitch: Int,
    val bindUinNotifySwitch: Int,
)