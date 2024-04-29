plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.leadsoft.ziskapharma.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.leadsoft.ziskapharma.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)

    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    //navigation
    var nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.compose.material:material:1.5.4")
    //bottom bar
    implementation ("androidx.compose.material:material:1.6.6")
    //biometric finger print
    implementation("androidx.biometric:biometric:1.2.0-alpha05")
    implementation ("com.airbnb.android:lottie-compose:6.1.0")
    //datepicker
    implementation ("io.github.vanpra.compose-material-dialogs:datetime:0.9.0")
    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:2.0.3")
    //pager
    implementation ("com.google.accompanist:accompanist-pager:0.30.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.30.0")
    implementation ("androidx.compose.foundation:foundation:1.6.6")
}