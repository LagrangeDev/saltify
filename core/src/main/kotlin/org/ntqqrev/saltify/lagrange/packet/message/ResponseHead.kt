package org.ntqqrev.saltify.lagrange.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
class ResponseHead(
    val fromUin: Long,
    val fromUid: String?,
    val type: Long,
    val sigMap: Long,
    val toUin: Long,
    val toUid: String?,
    val friendExt: FriendExt?,
    val groupExt: GroupExt?,
) {
    @Serializable
    class FriendExt(
        @ProtoNumber(6) val friendName: String?,
    )

    @Serializable
    class GroupExt(
        @ProtoNumber(1) val groupUin: Long,
        @ProtoNumber(4) val memberName: String?,
        @ProtoNumber(5) val unknown5: Long,
        @ProtoNumber(7) val groupName: String,
    )
}