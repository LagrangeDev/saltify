package org.ntqqrev.saltify.lagrange.packet.message

import org.ntqqrev.saltify.protobuf.ProtoMessage
import org.ntqqrev.saltify.protobuf.annotation.ProtoField

class ContentHead(
    @ProtoField(1) var type: Long, // 消息类型
    @ProtoField(2) var subType: Long?, // 消息子类型（0x211\0x2dc\0x210等系统消息的子类型,取值同 c2c_cmd）
    @ProtoField(3) var c2cCmd: Long?, // c2c消息子类型
    @ProtoField(4) var random: Long?, // 随机数
    @ProtoField(5) var sequence: Long?, // 序列号
    @ProtoField(6) var timestamp: Long?, // 时间戳
    @ProtoField(7) var pkgNum: Long?, // 分包数目，消息需要分包发送时该值不为 1
    @ProtoField(8) var pkgIndex: Long?, // 当前分包索引，从 0 开始
    @ProtoField(9) var divSeq: Long?, // 消息分包的序列号，同一条消息的各个分包的 div_seq 相同
    @ProtoField(10) var autoReply: Long, // 自动回复
    @ProtoField(11) var ntMsgSeq: Long?, // 两个uin之间c2c消息唯一递增seq
    @ProtoField(12) var msgUid: Long?, // 消息唯一 ID
    @ProtoField(15) var forward: ForwardHead? = null, // 转发头部
) : ProtoMessage() {
    class ForwardHead(
        @ProtoField(1) var field1: Long?, // 0
        @ProtoField(2) var field2: Long?, // 0
        @ProtoField(3) var field3: Long?, // for friend: 2, for group: null
        @ProtoField(4) var unknownBase64: String?, // unknown base64
        @ProtoField(5) var avatar: String? // 头像
    ) : ProtoMessage()
}