package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable

@Serializable
class Attributes(
    val codePage: Int,
    val time: Int,
    val random: Int,
    val color: Int,
    val size: Int,
    val effect: Int,
    val charSet: Int,
    val pitchAndFamily: Int,
    val fontName: String,
    val reserveData: ByteArray
)