package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.lagrange.packet.message.element.*
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MessageElement(
    @ProtoField(1) var text: TextElement?,
    @ProtoField(2) var face: FaceElement?,
    @ProtoField(3) var onlineImage: OnlineImageElement?,
    @ProtoField(4) var notOnlineImage: NotOnlineImageElement?,
    @ProtoField(5) var trans: TransElement?,
    @ProtoField(6) var marketFace: MarketFaceElement?,
    @ProtoField(8) var customFace: CustomFaceElement?,
    @ProtoField(9) var elemFlags2: ElemFlags2?,
    @ProtoField(12) var richMsg: RichMsgElement?,
    @ProtoField(13) var groupFile: GroupFileElement?,
    @ProtoField(16) var extraInfo: ExtraInfo?,
    @ProtoField(19) var videoFile: VideoFileElement?,
    @ProtoField(21) var anonGroupMsg: AnonymousGroupMessageElement?,
    @ProtoField(24) var qqWalletMsg: QQWalletMsgElement?,
    @ProtoField(31) var custom: CustomElement?,
    @ProtoField(37) var generalFlags: GeneralFlagsElement?,
    @ProtoField(45) var srcMsg: SrcMsgElement?,
    @ProtoField(51) var lightApp: LightAppElement?,
    @ProtoField(53) var common: CommonElement?,
) : ProtoMessage()