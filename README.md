# Syntax Music

## Overview
Syntax Music is an open-source, ad-free Android music streaming client built around a custom Liquid Glass aesthetic. It combines translucent frosted surfaces, subtle hairline highlights, and full edge-to-edge rendering with a fast, lightweight audio playback engine.

This repository hosts the Android client application engineered with a clean, self-contained frontend architecture that keeps external service endpoints decoupled and user-configurable.

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

## Building from Source

### Build APK
```bash
git clone https://github.com/xansyntax/syntax-music.git
cd syntax-music
/.gradlew assembleRelease
```

The compiled package will be generated at:
```text
app/build/outputs/apk/release/Syntax-Music-v1.1.0.apk
```

### Install via ADB
```bash
adb install -r ~/syntax-music/app/build/outputs/apk/release/Syntax-Music-v1.1.0.apk
```

## License & Credits
Open-source software licensed under the **GNU General Public License v3.0**.

- - **Creator & Maintainer:** Xan Syntax
- **Upstream Foundation:** Built upon Metrolist by Mo Agamy and the Metrolist open-source contributors.

## Disclaimer
Syntax Music is an independent open-source client and is not affiliated with, endorsed, or sponsored by Google LLC or YouTube.
