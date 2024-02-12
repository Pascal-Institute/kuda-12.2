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
    val osName = System.getProperty("os.name").toLowerCase()
    if (osName.contains("win")) {
        systemProperty("java.library.path", "src/main/resources/windows")
    } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
        systemProperty("java.library.path", "src/main/resources/linux")
    }
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

            version = "3.0.0"

            from(components["java"])
        }
    }
}