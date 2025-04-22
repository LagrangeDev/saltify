package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable

@Serializable
internal class PushMsgBody(
    val responseHead: ResponseHead,
    val contentHead: ContentHead,
    val body: MessageBody?,
)