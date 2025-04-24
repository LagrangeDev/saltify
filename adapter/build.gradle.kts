plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    compileOnly(libs.bundles.kotlinxEcosystem)
    compileOnly(project(":api"))
    implementation(project(":core"))
}