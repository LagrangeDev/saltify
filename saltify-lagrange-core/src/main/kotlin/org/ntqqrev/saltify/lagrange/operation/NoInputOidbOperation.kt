package org.ntqqrev.saltify.lagrange.operation

abstract class NoInputOidbOperation<R>(
    cmd: Int,
    subCmd: Int,
    reserve: Boolean = false
) : NoInputOperation<R>, OidbOperation<Unit, R>(cmd, subCmd, reserve)