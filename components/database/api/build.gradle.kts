plugins {
    alias(libs.plugins.android.lib)
    alias(libs.plugins.kotlin.android)
    id("flipper.android-lib")
    id("flipper.anvil")
    id("com.google.devtools.ksp")
}

android {
    namespace = "lionxyz.flippertesttask.database.api"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.components.core.di)
    implementation(projects.components.core.di)
}