plugins {
    id("com.android.application")
    kotlin("android")
}
val coroutinesVersion = "1.3.9-native-mt"
android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.networkkmm.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("com.squareup.picasso:picasso:2.5.2")
}