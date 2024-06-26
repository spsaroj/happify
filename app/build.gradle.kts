plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.happify"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.happify"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")



    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database")

    // Add the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    // Add the dependency for Firebase Authentication
    implementation("com.google.firebase:firebase-auth:22.3.1")
    // Add the dependency for Google Play services library
    implementation("com.google.android.gms:play-services-auth:21.0.0")
    // Import the BoM for the Firebase platform
    implementation("com.android.volley:volley:1.2.1")

    implementation("com.google.code.gson:gson:2.10.1")
}