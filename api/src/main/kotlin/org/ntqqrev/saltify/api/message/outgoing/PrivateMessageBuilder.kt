package org.ntqqrev.saltify.api.message.outgoing

import org.ntqqrev.saltify.api.Entity
import org.ntqqrev.saltify.api.message.outgoing.feature.*

interface PrivateMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ForwardFeature