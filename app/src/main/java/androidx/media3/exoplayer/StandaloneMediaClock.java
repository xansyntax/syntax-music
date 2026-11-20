package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StandaloneMediaClock implements MediaClock {
    public long baseElapsedMs;
    public long baseUs;
    public PlaybackParameters playbackParameters;
    public boolean started;

    @Override // androidx.media3.exoplayer.MediaClock
    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final long getPositionUs() {
        long j = this.baseUs;
        if (!this.started) {
            return j;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.baseElapsedMs;
        PlaybackParameters playbackParameters = this.playbackParameters;
        return (playbackParameters.speed == 1.0f ? Util.msToUs(jElapsedRealtime) : jElapsedRealtime * ((long) playbackParameters.scaledUsPerMs)) + j;
    }

    public final void resetPosition(long j) {
        this.baseUs = j;
        if (this.started) {
            this.baseElapsedMs = SystemClock.elapsedRealtime();
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackParameters = playbackParameters;
    }

    public final void start() {
        if (this.started) {
            return;
        }
        this.baseElapsedMs = SystemClock.elapsedRealtime();
        this.started = true;
    }
}
