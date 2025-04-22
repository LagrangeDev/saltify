package org.ntqqrev.saltify.core.packet.message

import kotlinx.serialization.Serializable
import kotlinx.serialization.protobuf.ProtoNumber

@Serializable
internal class ContentHead(
    @ProtoNumber(1) val type: Long, // 消息类型
    @ProtoNumber(2) val subType: Long?, // 消息子类型（0x211\0x2dc\0x210等系统消息的子类型,取值同 c2c_cmd）
    @ProtoNumber(3) val c2cCmd: Long?, // c2c消息子类型
    @ProtoNumber(4) val random: Long?, // 随机数
    @ProtoNumber(5) val sequence: Long?, // 序列号
    @ProtoNumber(6) val timestamp: Long?, // 时间戳
    @ProtoNumber(7) val pkgNum: Long?, // 分包数目，消息需要分包发送时该值不为 1
    @ProtoNumber(8) val pkgIndex: Long?, // 当前分包索引，从 0 开始
    @ProtoNumber(9) val divSeq: Long?, // 消息分包的序列号，同一条消息的各个分包的 div_seq 相同
    @ProtoNumber(10) val autoReply: Long, // 自动回复
    @ProtoNumber(11) val ntMsgSeq: Long?, // 两个uin之间c2c消息唯一递增seq
    @ProtoNumber(12) val msgUid: Long?, // 消息唯一 ID
    @ProtoNumber(15) val forward: ForwardHead? = null, // 转发头部
) {
    @Serializable
    class ForwardHead(
        val field1: Long?, // 0
        val field2: Long?, // 0
        val field3: Long?, // for friend: 2, for group: null
        val unknownBase64: String?, // unknown base64
        val avatar: String? // 头像
    )
}