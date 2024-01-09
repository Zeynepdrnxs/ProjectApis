plugins {
    id("com.android.application")
}

android {
    namespace = "com.medipol.projectapis"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.medipol.projectapis"
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
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val retrofitLibraryVersion = "2.9.0"

// Retrofit Library
    implementation("com.squareup.retrofit2:retrofit:$retrofitLibraryVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitLibraryVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitLibraryVersion")

// OkHttp Library
    implementation("com.squareup.okhttp:okhttp:2.7.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// RxJava Library
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")


    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
}