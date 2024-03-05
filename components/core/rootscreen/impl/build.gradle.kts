plugins {
    id("flipper.android-compose")
    id("flipper.anvil")
}

android.namespace = "com.lionzxy.flippertesttask.core.rootscreen.impl"

dependencies {
    implementation(projects.components.core.rootscreen.api)
    implementation(projects.components.core.di)
    implementation(projects.components.core.decompose)
    implementation(projects.components.keychoose.api)
    implementation(projects.components.bottombar.api)
    implementation(projects.components.core.ui)

    implementation(libs.appcompat)
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.bundles.decompose)
    implementation(libs.essenty.lifecycle.coroutines)
}