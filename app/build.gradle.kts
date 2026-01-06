android {
    namespace = "xxxb.xxxb.pirna800"
    compileSdk = 36

    defaultConfig {
        applicationId = "xxxb.xxxb.pirna800"
        minSdk = 23
        targetSdk = 36
        versionCode = 3
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            val storeFilePath = "/home/runner/work/Pirna800Android/Pirna800Android/app/keystore.jks"
            storeFile = file(storeFilePath)
            storePassword = System.getenv("STORE_PASSWORD") ?: "defaultStorePassword"
            keyAlias = System.getenv("KEY_ALIAS") ?: "defaultKeyAlias"
            keyPassword = System.getenv("KEY_PASSWORD") ?: "defaultKeyPassword"
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
