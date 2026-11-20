package androidx.media3.exoplayer;

import androidx.compose.ui.platform.WeakCache;
import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.SystemClock;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.navigation.internal.NavContext;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRenderer implements PlayerMessage.Target {
    public SystemClock clock;
    public RendererConfiguration configuration;
    public int index;
    public long lastResetPositionUs;
    public MediaSource$MediaPeriodId mediaPeriodId;
    public PlayerId playerId;
    public DefaultTrackSelector rendererCapabilitiesListener;
    public byte state;
    public SampleStream stream;
    public Format[] streamFormats;
    public boolean streamIsFinal;
    public long streamOffsetUs;
    public boolean throwRendererExceptionIsExecuting;
    public final byte trackType;
    public final Object lock = new Object();
    public final WeakCache formatHolder = new WeakCache((byte) 22, false);
    public long readingPositionUs = Long.MIN_VALUE;
    public Timeline timeline = Timeline.EMPTY;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseRenderer(int i) {
        this.trackType = i;
    }

    public static int create(int i, int i2, int i3, int i4) {
        return i | i2 | i3 | 128 | i4;
    }

    public static boolean isFormatSupported(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    public final ExoPlaybackException createRendererException(Exception exc, Format format, boolean z, int i) {
        int iSupportsFormat;
        if (format == null || this.throwRendererExceptionIsExecuting) {
            iSupportsFormat = 4;
        } else {
            this.throwRendererExceptionIsExecuting = true;
            try {
                iSupportsFormat = supportsFormat(format) & 7;
                this.throwRendererExceptionIsExecuting = false;
            } catch (ExoPlaybackException unused) {
                this.throwRendererExceptionIsExecuting = false;
                iSupportsFormat = 4;
            } catch (Throwable th) {
                this.throwRendererExceptionIsExecuting = false;
                throw th;
            }
        }
        return new ExoPlaybackException(1, exc, i, getName(), this.index, format, format == null ? 4 : iSupportsFormat, this.mediaPeriodId, z);
    }

    public long getDurationToProgressUs(long j, long j2) {
        if (this.state == 1) {
            return (isReady() || isEnded()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    public MediaClock getMediaClock() {
        return null;
    }

    public String getName() {
        return "ImageRenderer";
    }

    public final boolean hasReadStreamToEnd() {
        return this.readingPositionUs == Long.MIN_VALUE;
    }

    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    public boolean isReady() {
        return true;
    }

    public abstract void onDisabled();

    public abstract void onPositionReset(long j, boolean z, boolean z2);

    public final int readSource(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i) {
        SampleStream sampleStream = this.stream;
        sampleStream.getClass();
        int data = sampleStream.readData(weakCache, decoderInputBuffer, i);
        if (data == -4) {
            if (decoderInputBuffer.getFlag(4)) {
                this.readingPositionUs = Long.MIN_VALUE;
                return this.streamIsFinal ? -4 : -3;
            }
            long j = decoderInputBuffer.timeUs + this.streamOffsetUs;
            decoderInputBuffer.timeUs = j;
            this.readingPositionUs = Math.max(this.readingPositionUs, j);
            return data;
        }
        if (data == -5) {
            Format format = (Format) weakCache.referenceQueue;
            format.getClass();
            long j2 = format.subsampleOffsetUs;
            if (j2 != Long.MAX_VALUE) {
                Format.Builder builderBuildUpon = format.buildUpon();
                builderBuildUpon.subsampleOffsetUs = j2 + this.streamOffsetUs;
                weakCache.referenceQueue = new Format(builderBuildUpon);
            }
        }
        return data;
    }

    public abstract void render(long j, long j2);

    public final void replaceStream(Format[] formatArr, SampleStream sampleStream, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        UtilsKt.checkState(!this.streamIsFinal);
        this.stream = sampleStream;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
        if (this.readingPositionUs == Long.MIN_VALUE) {
            this.readingPositionUs = j;
        }
        this.streamFormats = formatArr;
        this.streamOffsetUs = j2;
        onStreamChanged(formatArr, j, j2, mediaSource$MediaPeriodId);
    }

    public final void resetPosition(long j, boolean z, boolean z2) {
        this.streamIsFinal = false;
        this.lastResetPositionUs = j;
        this.readingPositionUs = j;
        if (!z2) {
            SampleStream sampleStream = this.stream;
            sampleStream.getClass();
            z2 = sampleStream.skipData(j - this.streamOffsetUs) != 0;
        }
        onPositionReset(j, z, z2);
    }

    public int supportsFormat(Format format) {
        return NavContext.supportsFormat(format);
    }

    public int supportsMixedMimeTypeAdaptation() {
        return 0;
    }

    public boolean supportsResetPositionWithoutKeyFrameReset(long j) {
        return false;
    }

    public void enableMayRenderStartOfStream() {
    }

    public void onRelease() {
    }

    public void onReset() {
    }

    public void onStarted() {
    }

    public void onStopped() {
    }

    public void onTimelineChanged() {
    }

    @Override // androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i, Object obj) {
    }

    public void onEnabled(boolean z, boolean z2) {
    }

    public void setPlaybackSpeed(float f, float f2) {
    }

    public void onStreamChanged(Format[] formatArr, long j, long j2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
    }
}
