plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.xansyntax.music"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.xansyntax.music"
        minSdk = 26
        targetSdk = 36
        versionCode = 410
        versionName = "4.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    androidResources {
        additionalParameters += listOf("--stable-ids", rootProject.file("stable-ids.txt").absolutePath)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            res.srcDirs("src/main/res")
            assets.srcDirs("src/main/assets")
            jniLibs.srcDirs("src/main/jniLibs")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")

    val composeBom = platform("androidx.compose:compose-bom:2024.11.00")
    implementation(composeBom)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")

    implementation("androidx.navigation:navigation-compose:2.8.4")

    val media3Version = "1.5.0"
    implementation("androidx.media3:media3-exoplayer:$media3Version")
    implementation("androidx.media3:media3-session:$media3Version")
    implementation("androidx.media3:media3-ui:$media3Version")

    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    implementation("androidx.datastore:datastore-preferences:1.1.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    val ktorVersion = "3.0.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    implementation("io.coil-kt.coil3:coil-compose:3.0.4")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4")
}

tasks.withType<JavaCompile>().configureEach {
    enabled = false
}
tasks.matching { it.name.contains("Kotlin", ignoreCase = true) && it.name.startsWith("compile") }.configureEach {
    enabled = false
}
tasks.matching { it.name.contains("dexBuilder", ignoreCase = true) }.configureEach {
    enabled = false
}
tasks.matching { it.name.contains("mergeProjectDex", ignoreCase = true) }.configureEach {
    enabled = false
}

val injectDexAndSign = tasks.register("injectDexAndSign") {
    dependsOn("packageDebug")
    doLast {
        val apkFile = file("build/outputs/apk/debug/app-debug.apk")
        if (!apkFile.exists()) return@doLast

        val dexDir = file("src/main/dex")
        val buildToolsDir = file("/home/xansyntax/Android/Sdk/build-tools/35.0.0")
        val apksigner = File(buildToolsDir, "apksigner")
        val zipalign = File(buildToolsDir, "zipalign")
        val keystore = file("/home/xansyntax/.android/debug.keystore")

        // 1. Remove existing classes*.dex and signature files from apk
        exec {
            commandLine("zip", "-d", apkFile.absolutePath, "classes*.dex", "META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.MF", "META-INF/CERT*")
            isIgnoreExitValue = true
        }

        // 2. Add prebuilt dex files into apk
        val dexFiles = dexDir.listFiles { _, name -> name.endsWith(".dex") }?.map { it.name } ?: emptyList()
        exec {
            workingDir(dexDir)
            commandLine("zip", "-u", apkFile.absolutePath, *dexFiles.toTypedArray())
        }

        // 3. Zipalign
        val alignedApk = File(apkFile.parentFile, "app-debug-aligned.apk")
        if (alignedApk.exists()) alignedApk.delete()
        exec {
            commandLine(zipalign.absolutePath, "-f", "-p", "4", apkFile.absolutePath, alignedApk.absolutePath)
        }
        alignedApk.copyTo(apkFile, overwrite = true)
        alignedApk.delete()

        // 4. Sign with apksigner using debug.keystore
        exec {
            commandLine(
                apksigner.absolutePath, "sign",
                "--ks", keystore.absolutePath,
                "--ks-pass", "pass:android",
                "--key-pass", "pass:android",
                "--ks-key-alias", "androiddebugkey",
                apkFile.absolutePath
            )
        }
        println("Successfully injected prebuilt DEX and signed app-debug.apk!")
    }
}

afterEvaluate {
    tasks.named("packageDebug") {
        finalizedBy(injectDexAndSign)
    }
}


