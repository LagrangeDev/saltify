package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class RichText(
    val attributes: Attributes?,
    val elements: List<ByteArray>,
    val notOnlineFile: NotOnlineFile?,
    val ptt: Ptt?,
)