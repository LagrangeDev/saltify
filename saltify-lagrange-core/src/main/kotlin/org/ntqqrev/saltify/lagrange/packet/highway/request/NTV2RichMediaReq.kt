package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NTV2RichMediaReq(
    @ProtoField(1) var reqHead: MultiMediaReqHead?,
    @ProtoField(2) var upload: UploadReq?,
    @ProtoField(3) var download: DownloadReq?,
    @ProtoField(4) var downloadRKey: DownloadRKeyReq?,
    @ProtoField(5) var delete: DeleteReq?,
    @ProtoField(6) var uploadCompleted: UploadCompletedReq?,
    @ProtoField(7) var msgInfoAuth: MsgInfoAuthReq?,
    @ProtoField(8) var uploadKeyRenewal: UploadKeyRenewalReq?,
    @ProtoField(9) var downloadSafe: DownloadSafeReq?,
    @ProtoField(99) var extension: ByteArray?,
) : ProtoMessage()