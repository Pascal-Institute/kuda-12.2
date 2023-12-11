plugins {
    kotlin("jvm") version "1.9.0"
    application
    `maven-publish`
}

repositories {
    mavenCentral()
    maven{
        url = uri("https://jitpack.io")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(files("libs/kudadll.dll"))
}

sourceSets {
    main {
        resources {
            srcDir("resources")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.snacklab"
            artifactId = "kuda"

            version = "1.0.2"

            from(components["java"])
        }
    }
}