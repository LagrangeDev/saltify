package org.ntqqrev.saltify.lagrange.packet.login

open class QrCodeState(val value: Byte) {
    data object Unknown : QrCodeState(-1)
    data object Confirmed : QrCodeState(0)
    data object CodeExpired : QrCodeState(17)
    data object WaitingForScan : QrCodeState(48)
    data object WaitingForConfirm : QrCodeState(53)
    data object Canceled : QrCodeState(54)

    companion object {
        fun values(): Array<QrCodeState> =
            arrayOf(Unknown, Confirmed, CodeExpired, WaitingForScan, WaitingForConfirm, Canceled)

        fun valueOf(value: String): QrCodeState = when (value) {
            "Unknown" -> Unknown
            "Confirmed" -> Confirmed
            "CodeExpired" -> CodeExpired
            "WaitingForScan" -> WaitingForScan
            "WaitingForConfirm" -> WaitingForConfirm
            "Canceled" -> Canceled
            else -> throw IllegalArgumentException("No object org.lagrange.dev.packet.login.QRCodeState.$value")
        }

        fun getString(value: QrCodeState): String = when (value.value) {
            Unknown.value -> "Unknown"
            Confirmed.value -> "Confirmed"
            CodeExpired.value -> "CodeExpired"
            WaitingForScan.value -> "WaitingForScan"
            WaitingForConfirm.value -> "WaitingForConfirm"
            Canceled.value -> "Canceled"
            else -> throw IllegalArgumentException("No object org.lagrange.dev.packet.login.QRCodeState.$value")
        }
    }
}