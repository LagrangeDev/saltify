package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.outgoing.feature.FaceFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.ForwardFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.ImageFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.TextFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.VideoFeature

interface ForwardMessageBuilder :
    Entity,
    TextFeature,
    FaceFeature,
    ImageFeature,
    VideoFeature,
    ForwardFeature