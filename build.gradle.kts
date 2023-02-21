plugins {
    kotlin("jvm") version "1.8.0"
}

group = "fr.mvand"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.reactivex.rxjava3:rxjava:3.0.0")
    implementation("org.simpleframework:simple-xml:2.7.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}