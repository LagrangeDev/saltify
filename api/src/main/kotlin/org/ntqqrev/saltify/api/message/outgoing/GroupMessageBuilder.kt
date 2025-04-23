package org.ntqqrev.saltify.api.message.outgoing

import org.ntqqrev.saltify.api.Entity
import org.ntqqrev.saltify.api.message.outgoing.feature.*

interface GroupMessageBuilder :
    Entity,
    TextFeature,
    MentionFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ForwardFeature