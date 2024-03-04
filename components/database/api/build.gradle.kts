plugins {
    id("flipper.android-lib")
    id("flipper.anvil")
    id("com.google.devtools.ksp")
}

android.namespace = "com.lionzxy.flippertesttask.database.api"

dependencies {
    implementation(projects.components.core.di)
    implementation(libs.dagger)
    implementation(libs.kotlin.coroutines)
}