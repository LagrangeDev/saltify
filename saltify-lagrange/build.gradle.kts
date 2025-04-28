plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    compileOnly(libs.bundles.kotlinxEcosystem)
    compileOnly(libs.kotlinLogging)
    compileOnly(project(":saltify-api"))
    implementation(project(":saltify-lagrange-core"))

    testImplementation(libs.bundles.kotlinxEcosystem)
    testImplementation(libs.bundles.logging)
    testImplementation(project(":saltify-api"))
}