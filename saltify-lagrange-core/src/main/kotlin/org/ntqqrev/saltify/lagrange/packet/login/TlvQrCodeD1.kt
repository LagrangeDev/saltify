package org.ntqqrev.saltify.lagrange.packet.login

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class TlvQrCodeD1Body(
    @ProtoField(1) var system: System,
    @ProtoField(4) var typeBuf: ByteArray,
) : ProtoMessage() {
    class System(
        @ProtoField(1) var os: String,
        @ProtoField(2) var deviceName: String,
    ) : ProtoMessage()
}

class TlvQrCodeD1ResponseBody(
    @ProtoField(2) var qrCodeUrl: String,
    @ProtoField(3) var qrSig: String,
) : ProtoMessage()