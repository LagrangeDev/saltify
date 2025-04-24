package org.ntqqrev.saltify.lagrange.packet.common

import kotlinx.serialization.Serializable

@Serializable
internal class BusinessInfo(
    val notifySwitch: Int,
    val bindUinNotifySwitch: Int,
)