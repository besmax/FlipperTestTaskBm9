enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FlipperTestTask"
include(
    ":instances:app",
    ":components:core:di",
    ":components:core:log",
    ":components:core:decompose",
    ":components:singleactivity",
    ":components:bottombar:api",
    ":components:bottombar:impl",
    ":components:lockerchoose:api",
    ":components:lockerchoose:impl",
    ":components:database:api",
    ":components:database:impl",
    ":components:keychoose:api",
    ":components:keychoose:impl"
)
include(":components:core:ui")
include(":components:core:rootscreen")
include(":components:core:rootscreen:api")
include(":components:core:rootscreen:impl")
