package org.ntqqrev.saltify.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.ntqqrev.saltify.util.ext.toHex
import kotlin.random.Random

@Serializable
data class Keystore(
    @JvmField var uin: Long,
    @JvmField var uid: String,

    var a2: ByteArray,
    var d2: ByteArray,
    var d2Key: ByteArray,
    var tgtgt: ByteArray,
    var encryptedA1: ByteArray,
    var noPicSig: ByteArray,

    var qrSig: ByteArray,

    val guid: ByteArray,
    val deviceName: String,
) {
    @Transient
    internal var keySig: ByteArray? = null
    @Transient
    internal var exchangeKey: ByteArray? = null
    @Transient
    internal var unusualCookies: String? = null

    companion object {
        fun generateEmptyKeystore(): Keystore {
            return Keystore(
                uin = 0,
                uid = "",
                a2 = ByteArray(0),
                d2 = ByteArray(0),
                d2Key = ByteArray(16),
                tgtgt = ByteArray(0),
                encryptedA1 = ByteArray(0),
                noPicSig = ByteArray(0),
                qrSig = ByteArray(0),
                guid = Random.nextBytes(16),
                deviceName = "Lagrange-${Random.nextBytes(3).toHex()}"
            )
        }
    }

    internal fun clear() {
        a2 = ByteArray(0)
        d2 = ByteArray(0)
        d2Key = ByteArray(16)
        tgtgt = ByteArray(0)
        encryptedA1 = ByteArray(0)
        noPicSig = ByteArray(0)
        qrSig = ByteArray(0)
        keySig = null
        exchangeKey = null
        unusualCookies = null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Keystore

        if (uin != other.uin) return false
        if (uid != other.uid) return false
        if (!a2.contentEquals(other.a2)) return false
        if (!d2.contentEquals(other.d2)) return false
        if (!d2Key.contentEquals(other.d2Key)) return false
        if (!tgtgt.contentEquals(other.tgtgt)) return false
        if (!encryptedA1.contentEquals(other.encryptedA1)) return false
        if (!noPicSig.contentEquals(other.noPicSig)) return false
        if (!qrSig.contentEquals(other.qrSig)) return false
        if (!guid.contentEquals(other.guid)) return false
        if (deviceName != other.deviceName) return false
        if (!keySig.contentEquals(other.keySig)) return false
        if (!exchangeKey.contentEquals(other.exchangeKey)) return false
        if (unusualCookies != other.unusualCookies) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uin.hashCode()
        result = 31 * result + uid.hashCode()
        result = 31 * result + a2.contentHashCode()
        result = 31 * result + d2.contentHashCode()
        result = 31 * result + d2Key.contentHashCode()
        result = 31 * result + tgtgt.contentHashCode()
        result = 31 * result + encryptedA1.contentHashCode()
        result = 31 * result + noPicSig.contentHashCode()
        result = 31 * result + qrSig.contentHashCode()
        result = 31 * result + guid.contentHashCode()
        result = 31 * result + deviceName.hashCode()
        result = 31 * result + (keySig?.contentHashCode() ?: 0)
        result = 31 * result + (exchangeKey?.contentHashCode() ?: 0)
        result = 31 * result + (unusualCookies?.hashCode() ?: 0)
        return result
    }
}