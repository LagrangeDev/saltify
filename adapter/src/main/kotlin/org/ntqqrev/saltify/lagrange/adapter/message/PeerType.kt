package org.ntqqrev.saltify.lagrange.adapter.message

@JvmInline
value class MessageType(val type: Int) {
    companion object {
        val PRIVATE = MessageType(1)
        val GROUP = MessageType(2)
    }
}