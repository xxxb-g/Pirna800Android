// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
signingConfigs {
        create("release") {
            storeFile = file("keystore.jks")
            storePassword = System.getenv("ANDROID_KEYSTORE_PASSWORD")
            keyPassword = System.getenv("ANDROID_KEY_PASSWORD")
            keyAlias = System.getenv("ANDROID_KEY_ALIAS")
        }
    }
    
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ... weitere Release-Konfigurationen
        }
    }
}