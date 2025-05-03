package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.RecordSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.ElementReader
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.highway.MsgInfo
import org.ntqqrev.saltify.lagrange.util.binary.pb

class LagrangeRecordSegment(message: IncomingMessage, resourceId: String, duration: Int) :
    RecordSegment(message, resourceId, duration) {
    companion object : LagrangeSegmentFactory<RecordSegment> {
        override fun tryParse(reader: ElementReader): RecordSegment? {
            val common = reader.next()?.common?.takeIf {
                it.serviceType == 48 && (it.businessType == 22 || it.businessType == 12)
            } ?: return reader.pushBackAndReturnNull()

            val msgInfo = common.pbElem.pb<MsgInfo>()
            val indexNode = msgInfo.msgInfoBody.getOrNull(0)?.index
                ?: return reader.pushBackAndReturnNull()
            return LagrangeRecordSegment(
                reader.message,
                indexNode.fileUuid,
                indexNode.info?.time?.toInt() ?: 0
            )
        }
    }

    override fun toString() = "[语音 ${duration}s]"
}