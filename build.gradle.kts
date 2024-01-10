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
    systemProperty("java.library.path", "src/main/resources")
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
            groupId = "com.kudakit"
            artifactId = "kuda"

            version = "1.0.10"

            from(components["java"])
        }
    }
}