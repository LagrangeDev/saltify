package org.ntqqrev.saltify.api.context.message.outgoing

import org.ntqqrev.saltify.api.context.Entity
import org.ntqqrev.saltify.api.context.message.outgoing.feature.FaceFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.ForwardFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.ImageFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.MentionFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.RecordFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.TextFeature
import org.ntqqrev.saltify.api.context.message.outgoing.feature.VideoFeature

interface GroupMessageBuilder :
    Entity,
    TextFeature,
    MentionFeature,
    FaceFeature,
    ImageFeature,
    RecordFeature,
    VideoFeature,
    ForwardFeature