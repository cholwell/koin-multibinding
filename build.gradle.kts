group = "cholwell.dev"

version = "1.0"

plugins {
    alias(libs.plugins.kotlin)
    `maven-publish`
}

dependencies {
    implementation(libs.koin)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/cholwell/koin-multibinding")
            credentials {
                username = project.findProperty("gpruser") as String? ?: System.getenv("gpruser")
                password = project.findProperty("gprkey") as String? ?: System.getenv("gprkey")
            }
        }
    }
    publications { register<MavenPublication>("gpr") { from(components["java"]) } }
}
