plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    compileOnly(libs.bundles.kotlinxEcosystem)
    compileOnly(libs.kotlinLogging)
    compileOnly(project(":api"))
    implementation(project(":core"))

    testImplementation(libs.bundles.kotlinxEcosystem)
    testImplementation(libs.bundles.logging)
    testImplementation(project(":api"))
}