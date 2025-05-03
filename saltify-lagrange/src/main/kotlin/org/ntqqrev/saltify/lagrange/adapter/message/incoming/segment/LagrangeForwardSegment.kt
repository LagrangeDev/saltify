package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import io.github.oshai.kotlinlogging.KotlinLogging
import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.ForwardSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import java.util.zip.InflaterInputStream
import javax.xml.stream.XMLInputFactory

private val logger = KotlinLogging.logger { }

class LagrangeForwardSegment(message: IncomingMessage, forwardId: String) : ForwardSegment(message, forwardId) {
    companion object : LagrangeSegmentFactory<ForwardSegment> {
        private val xmlInputFactory = XMLInputFactory.newInstance()

        override fun tryParse(reader: ElementReader): ForwardSegment? {
            var template = reader.next()?.richMsg?.takeIf { it.serviceId == 35 }?.template1
                ?: return reader.pushBackAndReturnNull()
            val inputStream = template.inputStream()
            inputStream.skip(1)
            InflaterInputStream(inputStream).use {
                template = it.readBytes()
            }
            val xml = xmlInputFactory.createXMLStreamReader(template.inputStream())
            while (xml.hasNext()) {
                xml.next()
                if (xml.isStartElement && xml.localName == "msg") {
                    val resId = xml.getAttributeValue(null, "m_resid")
                    return resId?.let { LagrangeForwardSegment(reader.message, it) }
                }
            }
            return null
        }
    }

    override fun toString(): String = "[聊天记录]"
}