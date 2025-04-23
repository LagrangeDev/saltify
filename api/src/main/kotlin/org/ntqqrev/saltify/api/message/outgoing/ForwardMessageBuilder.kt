package org.ntqqrev.saltify.api.message.outgoing

import org.ntqqrev.saltify.api.Entity
import org.ntqqrev.saltify.api.message.outgoing.feature.*

interface ForwardMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    VideoFeature,
    ForwardFeature