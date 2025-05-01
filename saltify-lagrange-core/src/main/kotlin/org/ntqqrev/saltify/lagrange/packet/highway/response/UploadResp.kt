package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.lagrange.packet.highway.IPv4
import org.ntqqrev.saltify.lagrange.packet.highway.IPv6
import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfo
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadResp(
    @ProtoField(1) var uKey: String?,
    @ProtoField(2) var uKeyTtlSecond: Long,
    @ProtoField(3) var iPv4s: List<IPv4>,
    @ProtoField(4) var iPv6s: List<IPv6>,
    @ProtoField(5) var msgSeq: Long,
    @ProtoField(6) var msgInfo: MsgInfo?,
    @ProtoField(7) var ext: List<RichMediaStorageTransInfo>,
    @ProtoField(8) var compatQMsg: ByteArray?,
    @ProtoField(10) var subFileInfos: List<SubFileInfo>,
) : ProtoMessage() {
    class RichMediaStorageTransInfo(
        @ProtoField(1) var subType: Long,
        @ProtoField(2) var extType: Long,
        @ProtoField(3) var extValue: ByteArray?,
    ) : ProtoMessage()

    class SubFileInfo(
        @ProtoField(1) var subType: Long,
        @ProtoField(2) var uKey: String?,
        @ProtoField(3) var uKeyTtlSecond: Long,
        @ProtoField(4) var ipv4s: List<IPv4>,
        @ProtoField(5) var ipv6s: List<IPv6>,
    ) : ProtoMessage()
}