package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class Attr(
    @ProtoField(1) var codePage: Int,
    @ProtoField(2) var time: Int,
    @ProtoField(3) var random: Int,
    @ProtoField(4) var color: Int,
    @ProtoField(5) var size: Int,
    @ProtoField(6) var effect: Int,
    @ProtoField(7) var charSet: Int,
    @ProtoField(8) var pitchAndFamily: Int,
    @ProtoField(9) var fontName: String,
    @ProtoField(10) var reserveData: ByteArray
) : ProtoMessage()