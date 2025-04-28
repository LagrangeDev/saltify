package org.ntqqrev.saltify.api

/**
 * Describes an option that can be configured.
 */
@Target(AnnotationTarget.FIELD)
annotation class Config(val name: String, val description: String = "")