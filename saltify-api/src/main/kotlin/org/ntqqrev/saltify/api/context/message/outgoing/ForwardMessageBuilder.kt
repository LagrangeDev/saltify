package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.outgoing.feature.*

interface ForwardMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    VideoFeature,
    ForwardFeature