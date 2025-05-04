package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.lagrange.packet.message.element.*
import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MessageElement(
    @ProtoField(1) var text: TextElement? = null,
    @ProtoField(2) var face: FaceElement? = null,
    @ProtoField(3) var onlineImage: OnlineImageElement? = null,
    @ProtoField(4) var notOnlineImage: NotOnlineImageElement? = null,
    @ProtoField(5) var trans: TransElement? = null,
    @ProtoField(6) var marketFace: MarketFaceElement? = null,
    @ProtoField(8) var customFace: CustomFaceElement? = null,
    @ProtoField(9) var elemFlags2: ElemFlags2? = null,
    @ProtoField(12) var richMsg: RichMsgElement? = null,
    @ProtoField(13) var groupFile: GroupFileElement? = null,
    @ProtoField(16) var extraInfo: ExtraInfo? = null,
    @ProtoField(19) var videoFile: VideoFileElement? = null,
    @ProtoField(21) var anonGroupMsg: AnonymousGroupMessageElement? = null,
    @ProtoField(24) var qqWalletMsg: QQWalletMsgElement? = null,
    @ProtoField(31) var custom: CustomElement? = null,
    @ProtoField(37) var generalFlags: GeneralFlagsElement? = null,
    @ProtoField(45) var srcMsg: SrcMsgElement? = null,
    @ProtoField(51) var lightApp: LightAppElement? = null,
    @ProtoField(53) var common: CommonElement? = null,
) : ProtoMessage()