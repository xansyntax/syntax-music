<p align="center">
  <img src="assets/logo.svg" alt="Syntax Music Logo" width="112" />
</p>

<h1 align="center">Syntax Music</h1>

<p align="center">
  <strong>Liquid Glass Android music &amp; video client with 64-bit 10-Band ISO Parametric DSP &amp; Pure Dynamic Color</strong><br/>
  <a href="https://github.com/xansyntax/syntax-music/releases/latest">Latest Release: v1.5.0</a>
</p>

---

## Overview
Syntax Music is a free, ad-free Android music and video streaming client built around a custom Liquid Glass aesthetic. It combines translucent frosted surfaces, subtle hairline highlights, and full edge-to-edge rendering with a fast, lightweight audio-video playback engine.

This public repository hosts the visual showcase (`ui-showcase/`), release documentation, and official APK packages.

## Key Features

### Visual & Interface Design

- **Liquid Glass UI System:** Translucent frosted containers across cards, floating navigation pills, mini-player, full-screen player, top app bars, and modal dialogs.
- **Pure Dynamic Color & Fidelity Cover Extraction:** Android 12+ System Dynamic Color paired with `PaletteStyle.Fidelity` album artwork extraction for accurate cover-matched theming.
- **True Edge-to-Edge Layout:** Full-bleed rendering extending seamlessly beneath both the status bar and system gesture navigation bar with zero contrast scrims.
- **Dynamic Ambient Canvas:** Subtle animated background gradients synchronized with album artwork and active theme accents.
- **Speed Dial & Personalized Home:** 3x3 quick-access Speed Dial grid, mood & genre filters, listening history, and tailored recommendations.

### Audio & Video Playback Capabilities

- **Clean Overlay-Free Video Mode:** Switch seamlessly between **Audio** and **Video** directly in Now Playing with distraction-free playback, native aspect ratio adaptation, and real-time audio-video sync.
- **64-Bit 10-Band ISO Parametric Equalizer:** Precision biquad DSP (`31.25Hz-16kHz`) supporting per-band `Peaking (PK)`, `Low Shelf`, and `High Shelf` filters, adjustable `Q-Factor` (`0.40-8.00`), custom vertical faders, and `+/-0.1 dB` / `+/-0.5 dB` fine-tuning steppers.
- **Active Output Device Detection & Auto-Profile:** Automatically detects connected audio outputs (*USB DAC*, *Bluetooth TWS/Wireless*, *Wired IEM/Headset*, and *Built-in Speaker*) with one-tap **Auto-Tune 10-Band** and automatic per-device profile switching.
- **Ad-Free Streaming & Offline Playback:** Stream songs and videos from YouTube Music with background playback, smart caching, and offline downloads.
- **Real-Time Synced Lyrics:** Low-overhead time-synced lyrics with AI translation and multi-script romanization support.
- **Android Auto & Account Support:** Native Android Auto integration alongside optional account/token sign-in, Discord Rich Presence, and scrobbling support.

## Download & Installation

Pre-built APK packages are available directly from the **[GitHub Releases](https://github.com/xansyntax/syntax-music/releases/latest)** page.

1. Download the latest `Syntax-Music-v1.5.0-release.apk` from **Releases**.
2. Open the downloaded file on your Android device and allow installation from unknown sources if prompted.
3. *(Optional)* Install via ADB:
   ```bash
   adb install -r Syntax-Music-v1.5.0-release.apk
   
## License

Copyright (c) 2026 Xan Syntax. All rights reserved. See [LICENSE](LICENSE) for details.
