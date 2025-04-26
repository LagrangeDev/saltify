package org.ntqqrev.saltify.lagrange.exception

class OidbCallException(
    cmd: Int,
    subCmd: Int,
    retCode: Int,
    extra: String
) : Exception("Oidb call (cmd=${cmd.toString(16)},subCmd=$subCmd) failed with code $retCode: $extra")