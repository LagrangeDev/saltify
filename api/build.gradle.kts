plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

kotlin.sourceSets.all {
    languageSettings.apply {
    }
}

dependencies {
    compileOnly(libs.bundles.kotlinxEcosystem)
}