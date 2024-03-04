plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
    id("kotlinx-serialization")
}

android.namespace = "com.lionzxy.flippertesttask.core.rootscreen.api"

dependencies {
    implementation(projects.components.core.di)
    implementation(projects.components.core.decompose)

    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.bundles.decompose)
}