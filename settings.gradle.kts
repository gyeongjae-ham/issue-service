plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "issue-service"
include("issue-service-fast")
include("user-service")
