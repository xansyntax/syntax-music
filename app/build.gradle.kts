plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("com.google.protobuf")
}

android {
    namespace = "com.metrolist.music"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.xansyntax.music"
        minSdk = 26
        targetSdk = 36
        versionCode = 110
        versionName = "1.1.0"

        buildConfigField("String", "BASE_VERSION_NAME", "\"13.7.0\"")
        buildConfigField("String", "ARCHITECTURE", "\"universal\"")
        buildConfigField("boolean", "CAST_AVAILABLE", "false")
        buildConfigField("boolean", "UPDATER_AVAILABLE", "false")
        buildConfigField("String", "LASTFM_API_KEY", "\"\"")
        buildConfigField("String", "LASTFM_SECRET", "\"\"")
        buildConfigField("long", "DISCORD_APP_ID", "0L")
        buildConfigField("String", "SYNTAX_CONNECT_URL", "\"\"")
        buildConfigField("String", "CLOUD_SYNC_URL", "\"\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ""
            isDebuggable = true
        }
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        jniLibs {
            pickFirsts += listOf("**/libdatastore_shared_counter.so", "**/libquickjs.so")
        }
        resources {
            pickFirsts += listOf("assets/dexopt/baseline.prof", "assets/dexopt/baseline.profm")
            excludes += listOf("/META-INF/{AL2.0,LGPL2.1}", "META-INF/*.md", "META-INF/*.txt", "META-INF/DEPENDENCIES")
            pickFirsts += listOf("com/atilika/kuromoji/**", "yt_ejs/**")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.37.0-RC3"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                register("java") {
                    option("lite")
                }
            }
        }
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    implementation("com.github.MetrolistGroup.innertubex:innertubex-desktop:v0.12.0")
    implementation("com.valentinilk.shimmer:compose-shimmer:1.5.0")
    implementation("com.github.yalantis:ucrop:2.2.9")
    implementation("com.github.promeg:tinypinyin:2.0.3")
    implementation("androidx.browser:browser:1.8.0")
    implementation("androidx.lifecycle:lifecycle-process:2.9.4")
    implementation("androidx.graphics:graphics-shapes:1.1.0")
    implementation("androidx.graphics:graphics-shapes-android:1.1.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.4")

    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.4")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.navigation:navigation-compose:2.8.4")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.palette:palette-ktx:1.0.0")
    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("androidx.hilt:hilt-work:1.2.0")
    ksp("androidx.hilt:hilt-compiler:1.2.0")

    val composeBom = platform("androidx.compose:compose-bom:2024.11.00")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.5.0-alpha27")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.foundation:foundation")

    val media3Version = "1.12.0-beta01"
    implementation("androidx.media3:media3-exoplayer:$media3Version")
    implementation("androidx.media3:media3-datasource-okhttp:$media3Version")
    implementation("androidx.media3:media3-session:$media3Version")
    implementation("androidx.media3:media3-ui:$media3Version")

    val roomVersion = "2.8.4"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    implementation("androidx.datastore:datastore-preferences:1.3.0")
    implementation("androidx.datastore:datastore:1.3.0")

    val hiltVersion = "2.60.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    val ktorVersion = "3.6.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-encoding:$ktorVersion")

    implementation("io.coil-kt.coil3:coil-compose:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")

    implementation("dev.chrisbanes.haze:haze:1.6.10")
    implementation("dev.chrisbanes.haze:haze-materials:1.1.1")
    implementation("com.materialkolor:material-kolor:5.0.1")
    implementation("sh.calvin.reorderable:reorderable:3.1.0")
    implementation("com.google.protobuf:protobuf-javalite:4.37.0-RC3")
    implementation("com.atilika.kuromoji:kuromoji-ipadic:0.9.0")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("org.brotli:dec:0.1.2")
    implementation("com.github.teamnewpipe:NewPipeExtractor:v0.24.4")

    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-json:2.3.1")
}


tasks.configureEach { if (name.contains("ArtProfile")) enabled = false }
