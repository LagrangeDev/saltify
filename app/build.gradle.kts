plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":core"))
}

application {
    mainClass = "org.ntqqrev.saltify.app.AppKt"
}
