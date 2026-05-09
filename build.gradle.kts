plugins {
    java
}

val pluginVersion: String by extra
val paperVersion: String by extra

group = "dev.tonimatas"
version = pluginVersion

base {
    archivesName = "PerWorldPlugins"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    withSourcesJar()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$paperVersion")
}

tasks.processResources {
    inputs.property("pluginVersion", version)

    filesMatching(listOf("plugin.yml", "paper-plugin.yml")) {
        expand("pluginVersion" to version)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
