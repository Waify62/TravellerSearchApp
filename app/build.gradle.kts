plugins {
    id("com.google.gms.google-services")
    id("com.android.application")
}

android {
    namespace = "com.cyberhuskies.travellersearchapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cyberhuskies.travellersearchapp"
        minSdk = 26
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
//    annotationProcessor(libs.compiler)
    implementation("androidx.core:core-ktx:1.13.0")
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:3.6.0")

    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.picasso)
    implementation(libs.play.services.maps)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit)
    androidTestImplementation("junit:junit:4.12")
    androidTestImplementation("junit:junit:4.12")
    androidTestImplementation("junit:junit:4.12")

}