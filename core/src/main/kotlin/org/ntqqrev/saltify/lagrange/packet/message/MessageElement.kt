package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber
import kotlinx.serialization.protobuf.ProtoOneOf
import org.ntqqrev.saltify.lagrange.packet.message.element.*

@Serializable
class MessageElement(
    @ProtoOneOf @ProtoNumber(1) val text: TextElement?,
    @ProtoOneOf @ProtoNumber(2) val face: FaceElement?,
    @ProtoOneOf @ProtoNumber(3) val onlineImage: OnlineImageElement?,
    @ProtoOneOf @ProtoNumber(4) val notOnlineImage: NotOnlineImageElement?,
    @ProtoOneOf @ProtoNumber(5) val trans: TransElement?,
    @ProtoOneOf @ProtoNumber(6) val marketFace: MarketFaceElement?,
    @ProtoOneOf @ProtoNumber(8) val customFace: CustomFaceElement?,
    @ProtoOneOf @ProtoNumber(9) val elemFlags2: ElemFlags2?,
    @ProtoOneOf @ProtoNumber(12) val richMsg: RichMsgElement?,
    @ProtoOneOf @ProtoNumber(13) val groupFile: GroupFileElement?,
    @ProtoOneOf @ProtoNumber(16) val extraInfo: ExtraInfo?,
    @ProtoOneOf @ProtoNumber(19) val videoFile: VideoFileElement?,
    @ProtoOneOf @ProtoNumber(21) val anonGroupMsg: AnonymousGroupMessageElement?,
    @ProtoOneOf @ProtoNumber(24) val qqWalletMsg: QQWalletMsgElement?,
    @ProtoOneOf @ProtoNumber(31) val custom: CustomElement?,
    @ProtoOneOf @ProtoNumber(37) val generalFlags: GeneralFlagsElement?,
    @ProtoOneOf @ProtoNumber(45) val srcMsg: SrcMsgElement?,
    @ProtoOneOf @ProtoNumber(51) val lightApp: LightAppElement?,
    @ProtoOneOf @ProtoNumber(53) val common: CommonElement?,
)