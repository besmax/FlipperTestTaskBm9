plugins {
    id("com.squareup.anvil")
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    "implementation"(libs.dagger)
}
