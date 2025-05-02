package org.ntqqrev.saltify.lagrange.packet.highway.request

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class NTV2RichMediaReq(
    @ProtoField(1) var reqHead: MultiMediaReqHead?,
    @ProtoField(2) var upload: UploadReq? = null,
    @ProtoField(3) var download: DownloadReq? = null,
    @ProtoField(4) var downloadRKey: DownloadRKeyReq? = null,
    @ProtoField(5) var delete: DeleteReq? = null,
    @ProtoField(6) var uploadCompleted: UploadCompletedReq? = null,
    @ProtoField(7) var msgInfoAuth: MsgInfoAuthReq? = null,
    @ProtoField(8) var uploadKeyRenewal: UploadKeyRenewalReq? = null,
    @ProtoField(9) var downloadSafe: DownloadSafeReq? = null,
    @ProtoField(99) var extension: ByteArray? = null,
) : ProtoMessage()