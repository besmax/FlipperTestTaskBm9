plugins {
    id("flipper.android-lib")
    id("flipper.anvil")
    id("com.google.devtools.ksp")
}

android.namespace = "com.lionzxy.flippertesttask.database.impl"

dependencies {
    implementation(libs.core.ktx)
    implementation(projects.components.core.di)
    implementation(projects.components.database.api)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}