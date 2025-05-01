package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.lagrange.packet.highway.IPv4
import org.ntqqrev.saltify.lagrange.packet.highway.IPv6
import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfoBody
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class DownloadResp(
    @ProtoField(1) var rKeyParam: String?,
    @ProtoField(2) var rKeyTtlSecond: Long,
    @ProtoField(3) var info: Info?,
    @ProtoField(4) var rKeyCreateTime: Long,
) : ProtoMessage() {
    class Info(
        @ProtoField(1) var domain: String?,
        @ProtoField(2) var urlPath: String?,
        @ProtoField(3) var httpsPort: Long,
        @ProtoField(4) var ipv4s: List<IPv4>,
        @ProtoField(5) var ipv6s: List<IPv6>,
        @ProtoField(6) var picUrlExtInfo: MsgInfoBody.Picture.Ext?,
        @ProtoField(7) var videoExtInfo: MsgInfoBody.Video.Ext?,
    ) : ProtoMessage()
}