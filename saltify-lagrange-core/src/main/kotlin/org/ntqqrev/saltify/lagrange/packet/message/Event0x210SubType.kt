package org.ntqqrev.saltify.lagrange.packet.message

enum class Event0x210SubType(var value: Int) {
    FRIEND_REQUEST(35),
    GROUP_MEMBER_ENTER(38),
    FRIEND_DELETE_OR_PIN_CHANGE(39),
    FRIEND_RECALL(138),
    SERVICE_PIN_CHANGE(199), // e.g: My computer | QQ Wallet | ...
    FRIEND_POKE(290),
    GROUP_KICK(212),
}