val applicationPath = ":ui"

plugins {
    val kotlinVersion = "2.1.0"
    val springBootVersion = "3.4.1"

    id("org.springframework.boot") version springBootVersion

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    if (project.childProjects.isNotEmpty()) {
        return@subprojects
    }

    group = "kr.hope.grpc"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("kotlin")
        plugin("kotlin-kapt")
        plugin("kotlin-spring")
        plugin("kotlin-jpa")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    dependencies {
        implementation(kotlin("reflect"))
        implementation("org.springframework.boot:spring-boot-starter")

        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    if (project.path.contains(applicationPath)) {
        tasks {
            bootJar { enabled = true }
            jar { enabled = false }
        }
    } else {
        tasks {
            jar { enabled = true }
            bootJar { enabled = false }
        }
    }
}
