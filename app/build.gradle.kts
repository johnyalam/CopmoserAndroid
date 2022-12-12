plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.johnyalam.copmoserandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.johnyalam.copmoserandroid"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary  = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

dependencies {

    implementation (Deps.core_ktx)
    implementation (Deps.lifecycle_runtime_ktx )
    implementation (Deps.activity_compose )
    implementation (Deps.compose_ui )
    implementation (Deps.ui_tooling_preview )
    implementation (Deps.material3 )
    implementation (Deps.appcompat )
    implementation (Deps.material )
    testImplementation (Deps.junit )
    androidTestImplementation (Deps.androidx_test_ext )
    androidTestImplementation (Deps.espresso_core )
    androidTestImplementation (Deps.ui_test_junit4 )
    debugImplementation (Deps.ui_tooling )
    debugImplementation (Deps.ui_test_manifest )
    implementation (Deps.coil_compose )

    //Dagger - Hilt
    implementation (Deps.hilt_android )
    kapt (Deps.hilt_android_compiler )
    kapt (Deps.hilt_compiler )
    implementation (Deps.hilt_navigation_compose )

    // Retrofit
    implementation (Deps.retrofit2 )
    implementation (Deps.converter_gson )
    implementation (Deps.squareup_okhttp3 )
    implementation (Deps.logging_interceptor )

    // Coroutine Lifecycle Scopes
    implementation (Deps.lifecycle_viewmodel_ktx )
    implementation (Deps.lifecycle_runtime_ktx )

    // Coroutines
    implementation (Deps.kotlinx_coroutines_core )
    implementation (Deps.kotlinx_coroutines_android )

    // Compose dependencies
    implementation (Deps.lifecycle_viewmodel_compose )
    implementation (Deps.navigation_compose )
    implementation (Deps.accompanist_flowlayout )
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}