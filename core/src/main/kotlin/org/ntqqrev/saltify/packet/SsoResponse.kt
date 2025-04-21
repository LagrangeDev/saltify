package org.ntqqrev.saltify.packet

internal data class SsoResponse(
    val retCode: Int,
    val command: String,
    val response: ByteArray,
    val sequence: Int,
    val extra: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SsoResponse

        if (retCode != other.retCode) return false
        if (sequence != other.sequence) return false
        if (command != other.command) return false
        if (!response.contentEquals(other.response)) return false
        if (extra != other.extra) return false

        return true
    }

    override fun hashCode(): Int {
        var result = retCode
        result = 31 * result + sequence
        result = 31 * result + command.hashCode()
        result = 31 * result + response.contentHashCode()
        result = 31 * result + (extra?.hashCode() ?: 0)
        return result
    }
}
