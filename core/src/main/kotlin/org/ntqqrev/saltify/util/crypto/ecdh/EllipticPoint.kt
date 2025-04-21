package org.ntqqrev.saltify.util.crypto.ecdh

import java.math.BigInteger

internal class EllipticPoint(
    val x: BigInteger,
    val y: BigInteger
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EllipticPoint

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String {
        return "EllipticPoint(x=$x, y=$y)"
    }
    
    fun isDefault(): Boolean {
        return x == BigInteger.ZERO && y == BigInteger.ZERO
    }
    
    operator fun unaryMinus(): EllipticPoint {
        return EllipticPoint(-x, -y)
    }
}