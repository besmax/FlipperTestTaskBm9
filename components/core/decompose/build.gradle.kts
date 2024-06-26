plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
    id("kotlinx-serialization")
}

android.namespace = "com.lionzxy.flippertesttask.core.decompose"

dependencies {
    implementation(projects.components.core.di)

    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)

    implementation(libs.bundles.decompose)
    implementation(libs.essenty.lifecycle.coroutines)
}
