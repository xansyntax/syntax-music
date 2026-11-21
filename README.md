# Syntax Music

## Overview
Syntax Music is an open-source, ad-free Android music streaming client built around a custom Liquid Glass aesthetic. It combines translucent frosted surfaces, subtle hairline highlights, and full edge-to-edge rendering with a fast, lightweight audio playback engine.

This public repository showcases the Jetpack Compose **Liquid Glass UI** layer and visual resources (`ui-showcase/`), keeping private backend modules and external service endpoints decoupled.

## Key Features

### Visual & Interface Design

- **Liquid Glass UI System:** Translucent frosted containers across cards, floating navigation pills, mini-player, full-screen player, top app bars, and modal dialogs.
- **True Edge-to-Edge Layout:** Full-bleed rendering extending seamlessly beneath both the status bar and system gesture navigation bar with zero contrast scrims.
- **Dynamic Ambient Canvas:** Subtle animated background gradients synchronized with album artwork and active theme accents.
- **Speed Dial & Personalized Home:** 3x3 quick-access Speed Dial grid, mood & genre filters, listening history, and tailored recommendations.

### Audio & Playback Capabilities

- **Ad-Free Streaming & Offline Playback:** Stream songs and videos from YouTube Music with background playback, smart caching, and offline downloads.
- **Real-Time Synced Lyrics:** Time-synced lyrics with AI translation and multi-script romanization support.
- **Audio Engine Controls:** Built-in equalizer, loudness normalization, silence skipping, and playback speed/pitch adjustment.
- **Android Auto & Account Support:** Native Android Auto integration alongside optional account/token sign-in and scrobbling support.

## Download & Installation

Pre-built signed APK packages are available directly from the **[GitHub Releases](https://github.com/xansyntax/syntax-music/releases/latest)** page.

1. Download the latest `Syntax-Music-v1.1.0.apk` from **Releases**.
2. Open the downloaded file on your Android device and allow installation from unknown sources if prompted.
3. *(Optional)* Install via ADB:
   ```bash
   adb install -r Syntax-Music-v1.1.0.apk
