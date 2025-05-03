package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.VideoSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfo
import org.ntqqrev.saltify.lagrange.util.binary.pb

class LagrangeVideoSegment(message: IncomingMessage, resourceId: String) : VideoSegment(message, resourceId) {
    companion object : LagrangeSegmentFactory<VideoSegment> {
        override fun tryParse(reader: ElementReader): VideoSegment? {
            val common = reader.next()?.common?.takeIf {
                it.serviceType == 48 && (it.businessType == 21 || it.businessType == 11)
            } ?: return reader.pushBackAndReturnNull()
            val msgInfo = common.pbElem.pb<MsgInfo>()
            val uuid = msgInfo.msgInfoBody.getOrNull(0)?.index?.fileUuid
                ?: return reader.pushBackAndReturnNull()
            return LagrangeVideoSegment(reader.message, uuid)
        }
    }
}