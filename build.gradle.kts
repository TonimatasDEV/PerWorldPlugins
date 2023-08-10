plugins {
    id("java")
}

val plugin_version: String by extra
val minecraft_version: String by extra

group = "net.tonimatasdev"
version = "${plugin_version}"

base {
    archivesName = "PerWorldPlugins"
}

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:${minecraft_version}-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    filesMatching("plugin.yml") {
        expand("plugin_version" to plugin_version)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}