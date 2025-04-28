package org.ntqqrev.saltify.lagrange.exception

class OperationCallException(
    command: String,
    retCode: Int,
    extra: String
) : Exception("Operation $command failed with code $retCode: $extra")