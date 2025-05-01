package org.ntqqrev.saltify.lagrange.packet.highway

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class MsgInfo(
    @ProtoField(1) var msgInfoBody: List<MsgInfoBody>,
    @ProtoField(2) var extBizInfo: ExtBizInfo?,
) : ProtoMessage()