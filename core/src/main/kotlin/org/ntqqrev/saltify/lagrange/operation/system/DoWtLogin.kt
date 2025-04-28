package org.ntqqrev.saltify.lagrange.operation.system

import io.ktor.utils.io.core.*
import kotlinx.io.Buffer
import kotlinx.io.readByteArray
import kotlinx.io.writeUShort
import org.ntqqrev.saltify.lagrange.BotContext
import org.ntqqrev.saltify.lagrange.operation.NoInputOperation
import org.ntqqrev.saltify.lagrange.packet.login.Tlv
import org.ntqqrev.saltify.lagrange.packet.login.Tlv543Body
import org.ntqqrev.saltify.lagrange.util.binary.Prefix
import org.ntqqrev.saltify.lagrange.util.binary.pb
import org.ntqqrev.saltify.lagrange.util.binary.reader
import org.ntqqrev.saltify.lagrange.util.crypto.TEA

object DoWtLogin : NoInputOperation<Boolean> {
    override val command = "wtlogin.login"

    override fun build(bot: BotContext, payload: Unit): ByteArray {
        val tlvPack = Tlv(bot).apply {
            tlv106A2()
            tlv144()
            tlv116()
            tlv142()
            tlv145()
            tlv18()
            tlv141()
            tlv177()
            tlv191()
            tlv100()
            tlv107()
            tlv318()
            tlv16a()
            tlv166()
            tlv521()
        }
        val packet = Buffer().apply {
            writeUShort(9u) // internal command
            writeFully(tlvPack.build())
        }
        return bot.wtLoginContext.buildWtLogin(packet.readByteArray(), 2064u)
    }

    override fun parse(bot: BotContext, payload: ByteArray): Boolean {
        val reader = bot.wtLoginContext.parseWtLogin(payload).reader()

        val command = reader.readUShort()
        val state = reader.readUByte()
        val tlv119Reader = bot.wtLoginContext.readTlv(reader)

        if (state.toInt() == 0) {
            val tlv119 = tlv119Reader[0x119u]!!
            val array = TEA.decrypt(tlv119, bot.keystore.tgtgt)
            val tlvPack = bot.wtLoginContext.readTlv(array.reader())
            bot.keystore.apply {
                d2Key = tlvPack[0x305u]!!
                uid = tlvPack[0x543u]!!.pb<Tlv543Body>().layer1.layer2.uid
                a2 = tlvPack[0x10Au]!!
                d2 = tlvPack[0x143u]!!
                encryptedA1 = tlvPack[0x106u]!!
            }
            return true
        } else {
            val tlv146 = tlv119Reader[0x146u]!!.reader()
            val state = tlv146.readUInt()
            val tag = tlv146.readPrefixedString(Prefix.UINT_16 or Prefix.LENGTH_ONLY)
            val message = tlv146.readPrefixedString(Prefix.UINT_16 or Prefix.LENGTH_ONLY)

            println("Login failed: $state, $tag, $message")
        }

        return false
    }
}