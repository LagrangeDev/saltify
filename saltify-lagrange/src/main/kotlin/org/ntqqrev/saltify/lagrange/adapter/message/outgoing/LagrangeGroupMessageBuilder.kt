package org.ntqqrev.saltify.lagrange.adapter.message.outgoing

import org.ntqqrev.saltify.api.context.message.ImageSubType
import org.ntqqrev.saltify.api.context.message.outgoing.GroupMessageBuilder
import org.ntqqrev.saltify.api.context.message.outgoing.feature.ForwardFeature
import org.ntqqrev.saltify.lagrange.adapter.LagrangeContext
import org.ntqqrev.saltify.lagrange.packet.message.*
import org.ntqqrev.saltify.lagrange.util.binary.pb
import java.io.InputStream

class LagrangeGroupMessageBuilder(
    ctx: LagrangeContext,
    val groupUin: Long,
    clientSequence: Int,
    random: Int
) : LagrangeMessageBuilder(ctx, clientSequence, random), GroupMessageBuilder {
    override fun mention(uin: Long) {
        TODO("Not yet implemented")
    }

    override fun mentionAll() {
        TODO("Not yet implemented")
    }

    override fun face(id: String) {
        TODO("Not yet implemented")
    }

    override fun image(
        raw: InputStream,
        subType: ImageSubType,
        summary: String?
    ) {
        TODO("Not yet implemented")
    }

    override fun record(raw: InputStream) {
        TODO("Not yet implemented")
    }

    override fun video(raw: InputStream, cover: InputStream?) {
        TODO("Not yet implemented")
    }

    override fun reply(messageId: String) {
        TODO("Not yet implemented")
    }

    override fun forward(packer: ForwardFeature.Packer.() -> Unit) {
        TODO("Not yet implemented")
    }

    override fun buildActual(elements: List<MessageElement>) = PbSendMsg(
        routingHead = RoutingHead(
            grp = RoutingHead.Grp(
                groupUin = groupUin,
            ),
        ),
        contentHead = ContentHead(
            type = 1
        ),
        body = MessageBody(
            richText = RichText(
                elements = elements.map { it.pb() }
            )
        ),
        clientSequence = clientSequence.toLong(),
        random = random.toLong(),
    )
}