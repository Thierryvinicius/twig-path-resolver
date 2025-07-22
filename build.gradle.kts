plugins {
    id("org.jetbrains.intellij") version "1.17.3"
    kotlin("jvm") version "1.9.23"
}

group = "com.thierry.twigpathresolver"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

intellij {
    version.set("2023.3")
    type.set("PS")
    plugins.set(listOf("com.jetbrains.php:233.11799.232", "com.jetbrains.twig"))
}

kotlin {
    jvmToolchain(17)
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}

tasks {
    patchPluginXml {
        changeNotes.set("Primeira versão do plugin TwigPathResolver.")
    }
}
