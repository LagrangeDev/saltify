plugins {
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotlinPluginSerialization)
}

kotlin.sourceSets.all {
    languageSettings.apply {
        // because kotlinx.serialization.protobuf is experimental
        optIn("kotlinx.serialization.ExperimentalSerializationApi")
    }
}

dependencies {
    implementation(libs.bundles.ktorEcosystem)
    implementation(libs.kotlinxSerializationProtobuf)

    compileOnly(libs.bundles.kotlinxEcosystem)
    compileOnly(libs.kotlinLogging)
    testImplementation(libs.bundles.kotlinxEcosystem)
    testImplementation(libs.bundles.logging)
}