package org.ntqqrev.saltify.api.command

/**
 * Defines a description for a command, subcommand, option or parameter.
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
annotation class Description(val value: String)
