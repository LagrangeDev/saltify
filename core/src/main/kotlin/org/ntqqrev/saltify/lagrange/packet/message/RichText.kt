package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class RichText(
    val attributes: Attributes?,
    val elements: List<ByteArray>,
    val notOnlineFile: NotOnlineFile?,
    val ptt: Ptt?,
)