package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.outgoing.feature.*

interface PrivateMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ForwardFeature