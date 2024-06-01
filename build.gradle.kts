/*
 * This is a general purpose Gradle build.
 * To learn more about Gradle by exploring our Samples
 * at https://docs.gradle.org/8.8/samples
 * This project uses @Incubating APIs which are subject to change.
 */

group = "io.hexlet"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

plugins {
    id("java")
    id("application")
    id("jvm-test-suite")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Place for your dependencies
}

application {
    // Define the main class for the application.
    mainClass.set("io.hexlet.code.App")
}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit4 test framework
            useJUnit("4.13.2")

            dependencies {
                implementation("junit:junit:4.13.2")
                runtimeOnly("org.junit.vintage:junit-vintage-engine:5.8.2")
            }
        }
    }
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to application.mainClass.get(),
            "Implementation-Title" to "Mind Games course work",
            "Implementation-Version" to project.version
        )
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("PASSED", "FAILED", "SKIPPED")
    }
}
