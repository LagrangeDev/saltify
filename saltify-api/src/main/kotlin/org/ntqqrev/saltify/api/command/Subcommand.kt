package org.ntqqrev.saltify.api.command

@Target(AnnotationTarget.FUNCTION)
annotation class Subcommand(val name: String = "")
