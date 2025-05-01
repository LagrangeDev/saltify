package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.lagrange.packet.highway.ExtBizInfo
import org.ntqqrev.saltify.lagrange.packet.highway.FileInfo
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class UploadReq(
    @ProtoField(1) var info: List<Info>,
    @ProtoField(2) var tryFastUploadCompleted: Boolean,
    @ProtoField(3) var srvSendMsg: Boolean,
    @ProtoField(4) var clientRandomId: Long,
    @ProtoField(5) var compatQMsgSceneType: Long,
    @ProtoField(6) var extBizInfo: ExtBizInfo?,
    @ProtoField(7) var clientSeq: Long,
    @ProtoField(8) var noNeedCompatMsg: Boolean,
) : ProtoMessage() {
    class Info(
        @ProtoField(1) var fileInfo: FileInfo?,
        @ProtoField(2) var subFileType: Long,
    ) : ProtoMessage()
}