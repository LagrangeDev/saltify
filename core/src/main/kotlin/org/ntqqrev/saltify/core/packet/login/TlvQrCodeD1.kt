package org.ntqqrev.saltify.core.packet.login

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class TlvQrCodeD1Body(
    @ProtoNumber(1) val system: System,
    @ProtoNumber(4) val typeBuf: ByteArray,
) {
    @Serializable
    class System(
        val os: String,
        val deviceName: String,
    )
}

@Serializable
class TlvQrCodeD1ResponseBody(
    @ProtoNumber(2) val qrCodeUrl: String,
    @ProtoNumber(3) val qrSig: String,
)