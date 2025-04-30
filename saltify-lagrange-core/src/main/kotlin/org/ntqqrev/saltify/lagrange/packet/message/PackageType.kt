package org.ntqqrev.saltify.lagrange.packet.message

enum class PackageType(var value: Int) {
    PRIVATE_MESSAGE(166),
    GROUP_MESSAGE(82),
    TEMP_MESSAGE(141),
    EVENT_0X210(528), // friend related event
    EVENT_0X2DC(732), // group related event
    PRIVATE_RECORD_MESSAGE(208),
    PRIVATE_FILE_MESSAGE(529),
    GROUP_INVITED_JOIN_REQUEST(525), // from group member invitation
    GROUP_JOIN_REQUEST(84), // directly entered
    GROUP_INVITATION(87), // the bot self is being invited
    GROUP_ADMIN_CHANGED(44), // admin change, both on and off
    GROUP_MEMBER_INCREASE(33),
    GROUP_MEMBER_DECREASE(34),
}