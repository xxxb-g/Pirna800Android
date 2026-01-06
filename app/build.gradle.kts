plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}


android {
    namespace = "xxxb.xxxb.pirna800"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "xxxb.xxxb.pirna800"
        minSdk = 23
        targetSdk = 36
        versionCode = 3
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

signingConfigs {
    release {
        val storeFile = file("/home/runner/work/Pirna800Android/Pirna800Android/app/keystore.jks")
        val storePassword = System.getenv("STORE_PASSWORD") ?: "defaultStorePassword"
        val keyAlias = System.getenv("KEY_ALIAS") ?: "defaultKeyAlias"
        val keyPassword = System.getenv("KEY_PASSWORD") ?: "defaultKeyPassword"

        this.storeFile = storeFile
        this.storePassword = storePassword
        this.keyAlias = keyAlias
        this.keyPassword = keyPassword
    }
}

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")

        }
    }
    

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}