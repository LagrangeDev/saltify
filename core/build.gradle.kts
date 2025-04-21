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
    implementation(libs.bundles.kotlinxEcosystem)
    implementation(libs.kotlinxSerializationProtobuf)
    implementation(libs.bundles.slf4j)
}