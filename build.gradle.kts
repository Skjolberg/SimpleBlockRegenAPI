plugins {
    id("java")
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
    id("org.jetbrains.dokka") version "0.9.18"
}

group = "${project.property("group")}"
version = "${project.property("version")}"

plugins.apply("java")
plugins.apply("maven-publish")
plugins.apply("com.github.johnrengelman.shadow")

publishing {
    repositories {
        if (project.hasProperty("mavenUsername") && project.hasProperty("mavenPassword")) {
            maven {
                credentials {
                    username = "${project.property("mavenUsername")}"
                    password = "${project.property("mavenPassword")}"
                }

                val release = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
                val snapshot = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
                url = if (version.toString().endsWith("SNAPSHOT")) snapshot else release
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "${project.group}"
            artifactId = project.name
            version = "${project.version}"

            from(components["java"])
        }
        afterEvaluate {
            named<MavenPublication>("maven") {
                //artifact(sourcesJar)
                //artifact(javadocJar)
                pom {
                    name.set(project.name)
                    description.set(project.description)
                    inceptionYear.set("2022")
                    url.set("${project.property("github")}")
                    developers {
                        developer {
                            name.set("SKJOLBERG")
                            id.set("SKJOLBERG")
                        }
                    }
                    licenses {
                        license {
                            name.set("GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007")
                            url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                        }
                    }
                    scm {
                        url.set("https://github.com/Skjolberg/SimpleBlockRegenAPI.git")
                        connection.set("scm:git:https://github.com/Skjolberg/SimpleBlockRegenAPI.git")
                        developerConnection.set("scm:git:git@github.com:Skjolberg/SimpleBlockRegenAPI.git")
                    }
                }
            }
        }
    }
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly(libs.spigot16)
    implementation(libs.retinaLibrary)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks {
    /*named("publishToMavenLocal") {
        dependsOn(shadowJar)
    }*/

    assemble {
        dependsOn(shadowJar)
    }
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
        withSourcesJar()
        withJavadocJar()
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    shadowJar {
        minimize()
    }

}


