package androidx.media3.exoplayer;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.navigation.NavDeepLinkRequest;
import com.metrolist.innertubex.extraction.StreamDiagnostics;
import io.ktor.client.utils.CIOKt;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultMediaClock implements MediaClock {
    public boolean isUsingStandaloneClock;
    public final Object listener;
    public Object rendererClock;
    public Object rendererClockSource;
    public final Object standaloneClock;
    public boolean standaloneClockIsStarted;

    public DefaultMediaClock(int i) {
        this.standaloneClock = new NavDeepLinkRequest(i);
        this.listener = new ArrayList();
        this.rendererClockSource = new ArrayList();
        this.rendererClock = new ArrayList();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        MediaClock mediaClock = (MediaClock) this.rendererClock;
        return mediaClock != null ? mediaClock.getPlaybackParameters() : ((StandaloneMediaClock) this.standaloneClock).playbackParameters;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long getPositionUs() {
        if (this.isUsingStandaloneClock) {
            return ((StandaloneMediaClock) this.standaloneClock).getPositionUs();
        }
        MediaClock mediaClock = (MediaClock) this.rendererClock;
        mediaClock.getClass();
        return mediaClock.getPositionUs();
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public boolean hasSkippedSilenceSinceLastCall() {
        if (this.isUsingStandaloneClock) {
            return false;
        }
        MediaClock mediaClock = (MediaClock) this.rendererClock;
        mediaClock.getClass();
        return mediaClock.hasSkippedSilenceSinceLastCall();
    }

    public void onRendererEnabled(BaseRenderer baseRenderer) {
        MediaClock mediaClock;
        MediaClock mediaClock2 = baseRenderer.getMediaClock();
        if (mediaClock2 == null || mediaClock2 == (mediaClock = (MediaClock) this.rendererClock)) {
            return;
        }
        if (mediaClock != null) {
            throw new ExoPlaybackException(2, new IllegalStateException("Multiple renderer media clocks enabled."), CIOKt.DEFAULT_HTTP_POOL_SIZE);
        }
        this.rendererClock = mediaClock2;
        this.rendererClockSource = baseRenderer;
        ((MediaCodecAudioRenderer) mediaClock2).setPlaybackParameters(((StandaloneMediaClock) this.standaloneClock).playbackParameters);
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = (MediaClock) this.rendererClock;
        if (mediaClock != null) {
            mediaClock.setPlaybackParameters(playbackParameters);
            playbackParameters = ((MediaClock) this.rendererClock).getPlaybackParameters();
        }
        ((StandaloneMediaClock) this.standaloneClock).setPlaybackParameters(playbackParameters);
    }

    public StreamDiagnostics snapshot() {
        return new StreamDiagnostics(CollectionsKt.takeLast(32, (ArrayList) this.rendererClock), this.standaloneClockIsStarted);
    }

    public DefaultMediaClock(ExoPlayerImplInternal exoPlayerImplInternal) {
        this.listener = exoPlayerImplInternal;
        StandaloneMediaClock standaloneMediaClock = new StandaloneMediaClock();
        standaloneMediaClock.playbackParameters = PlaybackParameters.DEFAULT;
        this.standaloneClock = standaloneMediaClock;
        this.isUsingStandaloneClock = true;
    }
}
