package org.ntqqrev.saltify.lagrange.adapter.message.incoming.segment

import org.ntqqrev.saltify.api.context.message.incoming.IncomingMessage
import org.ntqqrev.saltify.api.context.message.incoming.segment.FaceSegment
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeIncomingMessage
import org.ntqqrev.saltify.lagrange.adapter.message.incoming.LagrangeSegmentFactory
import org.ntqqrev.saltify.lagrange.packet.message.MessageElement
import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.QBigFaceExtra
import org.ntqqrev.saltify.lagrange.packet.message.element.reserve.QSmallFaceExtra
import org.ntqqrev.saltify.lagrange.util.binary.pb

class LagrangeFaceSegment(
    message: IncomingMessage,
    id: String,
    val summary: String,
) : FaceSegment(message, id) {
    companion object : LagrangeSegmentFactory<FaceSegment> {
        override fun tryParse(
            element: MessageElement,
            message: LagrangeIncomingMessage
        ): FaceSegment? = when {
            element.face?.old != null -> {
                LagrangeFaceSegment(message, element.face!!.index.toString(), "[表情]")
            }

            element.common?.serviceType == 37 -> {
                element.common!!.pbElem.pb<QBigFaceExtra>().let {
                    LagrangeFaceSegment(message, it.faceId.toString(), it.preview)
                }
            }

            element.common?.serviceType == 33 -> {
                element.common!!.pbElem.pb<QSmallFaceExtra>().let {
                    LagrangeFaceSegment(
                        message,
                        it.faceId.toString(),
                        it.text ?: it.compatText ?: "[表情]" // fallback
                    )
                }
            }

            else -> null
        }
    }

    override fun toString(): String = summary // TODO: get face
}