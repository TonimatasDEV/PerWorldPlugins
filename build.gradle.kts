plugins {
    id("java")
}

val pluginVersion: String by extra
val minecraftVersion: String by extra

group = "net.tonimatasdev"
version = pluginVersion

base {
    archivesName = "PerWorldPlugins"
}

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:${minecraftVersion}-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    inputs.property("pluginVersion", version)

    filesMatching("plugin.yml") {
        expand("pluginVersion" to version)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}