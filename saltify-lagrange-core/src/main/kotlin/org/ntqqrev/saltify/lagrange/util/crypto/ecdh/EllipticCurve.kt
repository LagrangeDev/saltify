package org.ntqqrev.saltify.lagrange.util.crypto.ecdh

import java.math.BigInteger

internal class EllipticCurve(
    val p: BigInteger,
    val a: BigInteger,
    val b: BigInteger,
    val g: EllipticPoint,
    val n: BigInteger,
    val h: Int,
    val size: Int,
    val packSize: Int
) {
    fun checkOn(point: EllipticPoint): Boolean {
        return (point.y * point.y - point.x * point.x * point.x - a * point.x - b) % p == BigInteger.ZERO
    }

    companion object {
        val secp192k1 = EllipticCurve(
            p = BigInteger("0FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37", 16),
            a = BigInteger.ZERO,
            b = BigInteger.valueOf(3),
            g = EllipticPoint(
                x = BigInteger("0DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D", 16),
                y = BigInteger("09B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D", 16)
            ),
            n = BigInteger("0FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D", 16),
            h = 1,
            size = 24,
            packSize = 24
        )

        val prime256v1 = EllipticCurve(
            p = BigInteger("0FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", 16),
            a = BigInteger("0FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", 16),
            b = BigInteger("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B", 16),
            g = EllipticPoint(
                x = BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", 16),
                y = BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", 16)
            ),
            n = BigInteger("0FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551", 16),
            h = 1,
            size = 32,
            packSize = 16
        )
    }
}

