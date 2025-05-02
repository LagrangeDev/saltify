package org.ntqqrev.saltify.api.command

/**
 * Defines a command.
 */
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
annotation class Command(val name: String = "")
