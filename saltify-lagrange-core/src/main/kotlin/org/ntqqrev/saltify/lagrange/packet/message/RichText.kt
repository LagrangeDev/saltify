package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable

@Serializable
class RichText(
    val attr: Attr?,
    val elements: List<ByteArray>,
    val notOnlineFile: NotOnlineFile?,
    val ptt: Ptt?,
)