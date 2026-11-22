import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

kotlin {
    jvmToolchain(21)
    sourceSets {
        main {
            kotlin.srcDir("src/main/kotlin")
            kotlin.srcDir("../app/src/main/kotlin/com/metrolist/innertube")
        }
    }
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(compose.materialIconsExtended)

    implementation("com.github.MetrolistGroup.innertubex:innertubex-desktop:v0.12.0")
    implementation("com.github.teamnewpipe:NewPipeExtractor:v0.24.4")

    val ktorVersion = "3.6.1"
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-encoding:$ktorVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    implementation("io.coil-kt.coil3:coil-compose:3.6.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.6.3")
    implementation("dev.chrisbanes.haze:haze:1.6.10")
    implementation("dev.chrisbanes.haze:haze-materials:1.1.1")

    implementation("uk.co.caprica:vlcj:4.8.3")
    implementation("org.brotli:dec:0.1.2")
}

compose.desktop {
    application {
        mainClass = "com.metrolist.desktop.MainKt"

        val isWindows = System.getProperty("os.name").lowercase().contains("win")
        jvmArgs += listOf(
            if (isWindows) "-Dskiko.renderApi=DIRECT3D" else if (System.getProperty("os.name").lowercase().contains("win")) "-Dskiko.renderApi=DIRECT3D" else "-Dskiko.renderApi=OPENGL",
            "-Dskiko.fps=165",
            "-Dskiko.vsync.enabled=true",
        )

        nativeDistributions {
            targetFormats(TargetFormat.AppImage, TargetFormat.Deb, TargetFormat.Msi, TargetFormat.Exe)
            packageName = "SyntaxMusic"
            packageVersion = "1.2.0"
            description = "Syntax Music - Liquid Glass Desktop Player"
            vendor = "Xan Syntax"
            copyright = "Copyright (C) 2026 Xan Syntax"

            linux {
                iconFile.set(project.file("src/main/resources/icon.png"))
                packageName = "syntax-music"
                shortcut = true
                menuGroup = "AudioVideo;Audio;"
                appCategory = "AudioVideo"
            }
            appResourcesRootDir.set(project.layout.projectDirectory.dir("appResources"))
            appResourcesRootDir.set(project.layout.projectDirectory.dir("appResources"))
            
                iconFile.set(project.file("src/main/resources/icon.ico"))
                menuGroup = "Syntax Music"
                upgradeUuid = "8f7e4b2a-91c3-4e5d-a8b1-3c9d0e2f1a4b"
                shortcut = true
            }
        }
    }
}

tasks.withType<JavaExec> {
    environment("__GLX_VENDOR_LIBRARY_NAME", "mesa")
    environment("MESA_LOADER_DRIVER_OVERRIDE", "iris")
    jvmArgs(
        "-Dskiko.renderApi=OPENGL",
        "-Dskiko.fps=165",
        "-Dskiko.vsync.enabled=true",
    )
}
