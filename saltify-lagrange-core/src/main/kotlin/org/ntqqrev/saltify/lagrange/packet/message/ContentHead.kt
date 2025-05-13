package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class ContentHead(
    @ProtoField(1) var type: Int, // 消息类型
    @ProtoField(2) var subType: Int? = null, // 消息子类型（0x211\0x2dc\0x210等系统消息的子类型,取值同 c2c_cmd）
    @ProtoField(3) var c2cCmd: Long? = null, // c2c消息子类型
    @ProtoField(4) var random: Long? = null, // 随机数
    @ProtoField(5) var sequence: Long? = null, // 序列号
    @ProtoField(6) var timestamp: Long? = null, // 时间戳
    @ProtoField(7) var pkgNum: Long? = null, // 分包数目，消息需要分包发送时该值不为 1
    @ProtoField(8) var pkgIndex: Long? = null, // 当前分包索引，从 0 开始
    @ProtoField(9) var divSeq: Long? = null, // 消息分包的序列号，同一条消息的各个分包的 div_seq 相同
    @ProtoField(10) var autoReply: Long? = null, // 自动回复
    @ProtoField(11) var ntMsgSeq: Long? = null, // 两个uin之间c2c消息唯一递增seq
    @ProtoField(12) var msgUid: Long? = null, // 消息唯一 ID
    @ProtoField(15) var forward: ForwardHead? = null, // 转发头部
) : ProtoMessage() {
    class ForwardHead(
        @ProtoField(1) var field1: Long? = null, // 0
        @ProtoField(2) var field2: Long? = null, // 0
        @ProtoField(3) var field3: Long? = null, // for friend: 2, for group: null
        @ProtoField(4) var unknownBase64: String? = null, // unknown base64
        @ProtoField(5) var avatar: String? // 头像
    ) : ProtoMessage()
}