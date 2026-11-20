package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RendererHolder {
    public final int index;
    public final BaseRenderer primaryRenderer;
    public final BaseRenderer secondaryRenderer;
    public int prewarmingState = 0;
    public boolean primaryRequiresReset = false;
    public boolean secondaryRequiresReset = false;

    public RendererHolder(BaseRenderer baseRenderer, BaseRenderer baseRenderer2, int i) {
        this.primaryRenderer = baseRenderer;
        this.index = i;
        this.secondaryRenderer = baseRenderer2;
    }

    public static void ensureStopped(BaseRenderer baseRenderer) {
        byte b = baseRenderer.state;
        if (b == 2) {
            UtilsKt.checkState(b == 2);
            baseRenderer.state = (byte) 1;
            baseRenderer.onStopped();
        }
    }

    public static void setCurrentStreamFinalInternal(BaseRenderer baseRenderer, long j) {
        baseRenderer.streamIsFinal = true;
        if (baseRenderer instanceof TextRenderer) {
            TextRenderer textRenderer = (TextRenderer) baseRenderer;
            UtilsKt.checkState(textRenderer.streamIsFinal);
            textRenderer.finalStreamEndPositionUs = j;
        }
    }

    public final void disableRenderer(BaseRenderer baseRenderer, DefaultMediaClock defaultMediaClock) {
        UtilsKt.checkState(this.primaryRenderer == baseRenderer || this.secondaryRenderer == baseRenderer);
        if (isRendererEnabled(baseRenderer)) {
            if (baseRenderer == ((BaseRenderer) defaultMediaClock.rendererClockSource)) {
                defaultMediaClock.rendererClock = null;
                defaultMediaClock.rendererClockSource = null;
                defaultMediaClock.isUsingStandaloneClock = true;
            }
            ensureStopped(baseRenderer);
            UtilsKt.checkState(baseRenderer.state == 1);
            baseRenderer.formatHolder.clear();
            baseRenderer.state = (byte) 0;
            baseRenderer.stream = null;
            baseRenderer.streamFormats = null;
            baseRenderer.streamIsFinal = false;
            baseRenderer.onDisabled();
            baseRenderer.mediaPeriodId = null;
        }
    }

    public final int getEnabledRendererCount() {
        boolean zIsRendererEnabled = isRendererEnabled(this.primaryRenderer);
        BaseRenderer baseRenderer = this.secondaryRenderer;
        return (zIsRendererEnabled ? 1 : 0) + ((baseRenderer == null || !isRendererEnabled(baseRenderer)) ? 0 : 1);
    }

    public final BaseRenderer getRendererReadingFromPeriod(MediaPeriodHolder mediaPeriodHolder) {
        SampleStream sampleStream;
        if (mediaPeriodHolder == null || (sampleStream = mediaPeriodHolder.sampleStreams[this.index]) == null) {
            return null;
        }
        BaseRenderer baseRenderer = this.primaryRenderer;
        if (baseRenderer.stream == sampleStream) {
            return baseRenderer;
        }
        BaseRenderer baseRenderer2 = this.secondaryRenderer;
        if (baseRenderer2 == null || baseRenderer2.stream != sampleStream) {
            return null;
        }
        return baseRenderer2;
    }

    public final boolean hasFinishedReadingFromPeriodInternal(MediaPeriodHolder mediaPeriodHolder, BaseRenderer baseRenderer) {
        if (baseRenderer == null) {
            return true;
        }
        SampleStream[] sampleStreamArr = mediaPeriodHolder.sampleStreams;
        int i = this.index;
        SampleStream sampleStream = sampleStreamArr[i];
        SampleStream sampleStream2 = baseRenderer.stream;
        if (sampleStream2 == null) {
            return true;
        }
        if (sampleStream2 == sampleStream) {
            if (sampleStream == null || baseRenderer.hasReadStreamToEnd()) {
                return true;
            }
            MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder.next;
            if (mediaPeriodHolder.info.isFollowedByTransitionToSameStream && mediaPeriodHolder2 != null && mediaPeriodHolder2.prepared && ((baseRenderer instanceof TextRenderer) || (baseRenderer instanceof MetadataRenderer) || baseRenderer.readingPositionUs >= mediaPeriodHolder2.getStartPositionRendererTime())) {
                return true;
            }
        }
        MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder.next;
        return mediaPeriodHolder3 != null && mediaPeriodHolder3.sampleStreams[i] == baseRenderer.stream;
    }

    public final boolean isPrewarming() {
        int i = this.prewarmingState;
        return i == 2 || i == 4 || i == 3;
    }

    public final boolean isRendererEnabled() {
        int i = this.prewarmingState;
        if (i == 0 || i == 2 || i == 4) {
            return isRendererEnabled(this.primaryRenderer);
        }
        BaseRenderer baseRenderer = this.secondaryRenderer;
        baseRenderer.getClass();
        return baseRenderer.state != 0;
    }

    public final void maybeResetRenderer(boolean z) {
        if (z) {
            if (this.primaryRequiresReset) {
                BaseRenderer baseRenderer = this.primaryRenderer;
                UtilsKt.checkState(baseRenderer.state == 0);
                baseRenderer.formatHolder.clear();
                baseRenderer.onReset();
                this.primaryRequiresReset = false;
                return;
            }
            return;
        }
        if (this.secondaryRequiresReset) {
            BaseRenderer baseRenderer2 = this.secondaryRenderer;
            baseRenderer2.getClass();
            UtilsKt.checkState(baseRenderer2.state == 0);
            baseRenderer2.formatHolder.clear();
            baseRenderer2.onReset();
            this.secondaryRequiresReset = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int replaceStreamsOrDisableRendererForTransitionInternal(BaseRenderer baseRenderer, MediaPeriodHolder mediaPeriodHolder, TrackSelectorResult trackSelectorResult, DefaultMediaClock defaultMediaClock) {
        BaseRenderer baseRenderer2;
        int i;
        if (baseRenderer == null || baseRenderer.state == 0 || (baseRenderer == (baseRenderer2 = this.primaryRenderer) && ((i = this.prewarmingState) == 2 || i == 4))) {
            return 1;
        }
        if (baseRenderer == this.secondaryRenderer && this.prewarmingState == 3) {
            return 1;
        }
        SampleStream sampleStream = baseRenderer.stream;
        SampleStream[] sampleStreamArr = mediaPeriodHolder.sampleStreams;
        int i2 = this.index;
        Object[] objArr = sampleStream != sampleStreamArr[i2];
        boolean zIsRendererEnabled = trackSelectorResult.isRendererEnabled(i2);
        if (!zIsRendererEnabled || objArr != false) {
            if (!baseRenderer.streamIsFinal) {
                ExoTrackSelection exoTrackSelection = trackSelectorResult.selections[i2];
                int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
                Format[] formatArr = new Format[length];
                for (int i3 = 0; i3 < length; i3++) {
                    exoTrackSelection.getClass();
                    formatArr[i3] = exoTrackSelection.getFormat(i3);
                }
                SampleStream sampleStream2 = mediaPeriodHolder.sampleStreams[i2];
                sampleStream2.getClass();
                baseRenderer.replaceStream(formatArr, sampleStream2, mediaPeriodHolder.getStartPositionRendererTime(), mediaPeriodHolder.rendererPositionOffsetUs, mediaPeriodHolder.info.id);
                return 3;
            }
            if (!baseRenderer.isEnded()) {
                return 0;
            }
            disableRenderer(baseRenderer, defaultMediaClock);
            if (!zIsRendererEnabled || isPrewarming()) {
                maybeResetRenderer(baseRenderer == baseRenderer2);
                return 1;
            }
        }
        return 1;
    }

    public final void reset() {
        if (!isRendererEnabled(this.primaryRenderer)) {
            maybeResetRenderer(true);
        }
        BaseRenderer baseRenderer = this.secondaryRenderer;
        if (baseRenderer == null || baseRenderer.state != 0) {
            return;
        }
        maybeResetRenderer(false);
    }

    public final void start() {
        byte b;
        BaseRenderer baseRenderer = this.primaryRenderer;
        byte b2 = baseRenderer.state;
        if (b2 == 1 && this.prewarmingState != 4) {
            UtilsKt.checkState(b2 == 1);
            baseRenderer.state = (byte) 2;
            baseRenderer.onStarted();
            return;
        }
        BaseRenderer baseRenderer2 = this.secondaryRenderer;
        if (baseRenderer2 == null || (b = baseRenderer2.state) != 1 || this.prewarmingState == 3) {
            return;
        }
        UtilsKt.checkState(b == 1);
        baseRenderer2.state = (byte) 2;
        baseRenderer2.onStarted();
    }

    public static boolean isRendererEnabled(BaseRenderer baseRenderer) {
        return baseRenderer.state != 0;
    }
}
