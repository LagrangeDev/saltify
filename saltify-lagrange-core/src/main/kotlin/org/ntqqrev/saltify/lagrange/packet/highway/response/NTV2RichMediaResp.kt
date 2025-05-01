package org.ntqqrev.saltify.lagrange.packet.highway.response

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NTV2RichMediaResp(
    @ProtoField(1) var respHead: MultiMediaRespHead?,
    @ProtoField(2) var upload: UploadResp?,
    @ProtoField(3) var download: DownloadResp?,
    @ProtoField(4) var downloadRKey: DownloadRKeyResp?,
    @ProtoField(5) var delete: DeleteResp?,
    @ProtoField(6) var uploadCompleted: UploadCompletedResp?,
    @ProtoField(7) var msgInfoAuth: MsgInfoAuthResp?,
    @ProtoField(8) var uploadKeyRenewal: UploadKeyRenewalResp?,
    @ProtoField(9) var downloadSafe: DownloadSafeResp?,
    @ProtoField(99) var extension: ByteArray?,
) : ProtoMessage()