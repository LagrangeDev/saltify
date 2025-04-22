package org.ntqqrev.saltify.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class PushMsgBody(
    val responseHead: ResponseHead,
    val contentHead: ContentHead,
    val body: MessageBody?,
)