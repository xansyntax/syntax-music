package com.metrolist.music.playback;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$createRenderersFactory$1$buildAudioRenderers$1 extends MediaCodecAudioRenderer {
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        format.getClass();
        formatArr.getClass();
        if (0.95f <= f && f <= 1.05f) {
            f = 1.0f;
        }
        return super.getCodecOperatingRateV23(f, format, formatArr);
    }
}
