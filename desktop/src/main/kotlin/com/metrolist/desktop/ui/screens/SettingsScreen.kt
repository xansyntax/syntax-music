package com.metrolist.desktop.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metrolist.desktop.playback.DesktopPlaybackEngine
import com.metrolist.desktop.ui.components.glassSurface
import com.metrolist.desktop.ui.theme.GlassCardShape
import com.metrolist.innertubex.extraction.AudioQuality

@Composable
fun SettingsScreen(engine: DesktopPlaybackEngine) {
    val state by engine.state.collectAsState()
    val cs = MaterialTheme.colorScheme

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 26.dp, vertical = 22.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Column {
            Text("Settings", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("Audio, Kontrol & Environment", fontSize = 12.sp, color = cs.primary, fontWeight = FontWeight.Medium)
        }

        // Audio Quality
        Column(modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Rounded.HighQuality, contentDescription = null, tint = cs.primary)
                Text("Kualitas Audio", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf(
                    AudioQuality.HIGH to "Tinggi (256 kbps)",
                    AudioQuality.AUTO to "Otomatis",
                    AudioQuality.LOW to "Rendah (128 kbps)",
                ).forEach { (q, label) ->
                    val active = state.audioQuality == q
                    val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(120))
                    val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(120))
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(bg)
                            .clickable { engine.setAudioQuality(q) }
                            .padding(horizontal = 18.dp, vertical = 8.dp),
                    ) {
                        Text(label, color = fg, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    }
                }
            }
        }

        // Playback Speed
        Column(modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Rounded.Speed, contentDescription = null, tint = cs.primary)
                Text("Kecepatan Putar (${state.playbackSpeed}x)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf(0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f).forEach { spd ->
                    val active = state.playbackSpeed == spd
                    val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(120))
                    val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(120))
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(bg)
                            .clickable { engine.setPlaybackSpeed(spd) }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text("${spd}x", color = fg, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    }
                }
            }
        }

        // Sleep Timer
        Column(modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Rounded.Bedtime, contentDescription = null, tint = cs.primary)
                val timerLabel = state.sleepTimerRemainingSec?.let { "Sleep Timer (Sisa ${formatTimer(it)})" } ?: "Sleep Timer (Nonaktif)"
                Text(timerLabel, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf(0 to "Off", 15 to "15 Menit", 30 to "30 Menit", 45 to "45 Menit", 60 to "60 Menit").forEach { (mins, label) ->
                    val active = if (mins == 0) state.sleepTimerRemainingSec == null else (state.sleepTimerRemainingSec != null && state.sleepTimerRemainingSec!! in ((mins - 1) * 60 + 1)..(mins * 60))
                    val bg by animateColorAsState(if (active) cs.primary else Color.White.copy(0.08f), tween(120))
                    val fg by animateColorAsState(if (active) cs.onPrimary else Color.White, tween(120))
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(bg)
                            .clickable { engine.setSleepTimer(mins) }
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    ) {
                        Text(label, color = fg, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    }
                }
            }
        }

        // Keyboard Shortcuts
        Column(modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Rounded.Keyboard, contentDescription = null, tint = cs.primary)
                Text("Pintasan Keyboard (Global/Window)", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            listOf(
                "Spasi / Ctrl + Spasi" to "Play / Pause",
                "Panah Kiri / Kanan" to "Seek Mundur / Maju 5 Detik",
                "Panah Atas / Bawah" to "Volume Naik / Turun 5%",
                "M" to "Mute / Unmute",
                "Media Keys (F8/F9/dll)" to "Media Play/Pause, Next, Previous",
            ).forEach { (shortcut, action) ->
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(shortcut, fontWeight = FontWeight.SemiBold, color = Color.White, fontSize = 13.sp)
                    Text(action, color = cs.onSurfaceVariant, fontSize = 13.sp)
                }
            }
        }

        // Environment & Hardware Acceleration Status
        Column(modifier = Modifier.fillMaxWidth().glassSurface(GlassCardShape).padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(Icons.Rounded.Memory, contentDescription = null, tint = cs.primary)
                Text("Status Lingkungan & Akselerasi GPU", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Text("OS: Arch Linux (Wayland / GNOME 165Hz)", color = cs.onSurfaceVariant, fontSize = 13.sp)
            val gpuInfo = remember {
                runCatching {
                    val nv = ProcessBuilder("nvidia-smi", "--query-gpu=name,driver_version", "--format=csv,noheader")
                        .redirectErrorStream(true).start().inputStream.bufferedReader().readText().trim()
                    if (nv.isNotBlank() && !nv.contains("not found", true) && !nv.contains("failed", true)) {
                        val parts = nv.lines().first().split(",").map { it.trim() }
                        if (parts.size >= 2) "${parts[0]} (NVIDIA Driver ${parts[1]})" else parts[0]
                    } else {
                        val glx = ProcessBuilder("sh", "-c", "glxinfo -B 2>/dev/null | grep -m1 \"OpenGL renderer string:\" | cut -d: -f2-")
                            .redirectErrorStream(true).start().inputStream.bufferedReader().readText().trim()
                        glx.ifBlank {
                            ProcessBuilder("sh", "-c", "lspci 2>/dev/null | grep -iE \"vga|3d|display\" | tail -n1 | cut -d: -f3-")
                                .redirectErrorStream(true).start().inputStream.bufferedReader().readText().trim()
                                .ifBlank { "Hardware Accelerated GPU" }
                        }
                    }
                }.getOrDefault("Hardware Accelerated GPU")
            }
            Text("GPU Driver: $gpuInfo", color = cs.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Text("Renderer: Skiko Hardware Accelerated (165 FPS)", color = cs.onSurfaceVariant, fontSize = 13.sp)
            Text("Media Server: libvlc with MPRIS D-Bus Integration", color = cs.onSurfaceVariant, fontSize = 13.sp)
        }
    }
}

private fun formatTimer(sec: Int): String {
    val m = sec / 60
    val s = sec % 60
    return "%02d:%02d".format(m, s)
}
