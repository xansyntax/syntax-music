package androidx.media3.exoplayer.source;

import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ClippingMediaSource extends WrappingMediaSource {
    public final boolean allowDynamicClippingUpdates;
    public final boolean allowUnseekableMedia;
    public IllegalClippingException clippingError;
    public ClippingTimeline clippingTimeline;
    public final boolean enableInitialDiscontinuity;
    public final long endUs;
    public final ArrayList mediaPeriods;
    public long periodEndUs;
    public long periodStartUs;
    public final boolean relativeToDefaultPosition;
    public final long startUs;
    public final Timeline.Window window;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public boolean allowDynamicClippingUpdates;
        public boolean allowUnseekableMedia;
        public boolean buildCalled;
        public boolean enableInitialDiscontinuity;
        public long endPositionUs;
        public final BaseMediaSource mediaSource;
        public boolean relativeToDefaultPosition;
        public long startPositionUs;

        public Builder(BaseMediaSource baseMediaSource) {
            baseMediaSource.getClass();
            this.mediaSource = baseMediaSource;
            this.enableInitialDiscontinuity = true;
            this.endPositionUs = Long.MIN_VALUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ClippingTimeline extends ForwardingTimeline {
        public final long durationUs;
        public final long endUs;
        public final boolean isDynamic;
        public final long startUs;

        public ClippingTimeline(Timeline timeline, long j, long j2, boolean z) throws IllegalClippingException {
            super(timeline);
            if (j2 != Long.MIN_VALUE && j2 < j) {
                throw new IllegalClippingException(2, j, j2);
            }
            boolean z2 = false;
            if (timeline.getPeriodCount() != 1) {
                throw new IllegalClippingException(0);
            }
            Timeline.Window window = timeline.getWindow(0, new Timeline.Window(), 0L);
            long jMax = Math.max(0L, j);
            if (!z && !window.isPlaceholder && jMax != 0 && !window.isSeekable) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j2 == Long.MIN_VALUE ? window.durationUs : Math.max(0L, j2);
            long j3 = window.durationUs;
            if (j3 != -9223372036854775807L) {
                jMax2 = jMax2 > j3 ? j3 : jMax2;
                if (jMax > jMax2) {
                    jMax = jMax2;
                }
            }
            this.startUs = jMax;
            this.endUs = jMax2;
            this.durationUs = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (window.isDynamic && (jMax2 == -9223372036854775807L || (j3 != -9223372036854775807L && jMax2 == j3))) {
                z2 = true;
            }
            this.isDynamic = z2;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(0, period, z);
            long j = period.positionInWindowUs - this.startUs;
            long j2 = this.durationUs;
            period.set(period.id, period.uid, 0, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, j, AdPlaybackState.NONE, false);
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(0, window, 0L);
            long j2 = window.positionInFirstPeriodUs;
            long j3 = this.startUs;
            window.positionInFirstPeriodUs = j2 + j3;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            long j4 = window.defaultPositionUs;
            if (j4 != -9223372036854775807L) {
                long jMax = Math.max(j4, j3);
                window.defaultPositionUs = jMax;
                long j5 = this.endUs;
                if (j5 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j5);
                }
                window.defaultPositionUs = jMax - j3;
            }
            long jUsToMs = Util.usToMs(j3);
            long j6 = window.presentationStartTimeMs;
            if (j6 != -9223372036854775807L) {
                window.presentationStartTimeMs = j6 + jUsToMs;
            }
            long j7 = window.windowStartTimeMs;
            if (j7 != -9223372036854775807L) {
                window.windowStartTimeMs = j7 + jUsToMs;
            }
            return window;
        }
    }

    public ClippingMediaSource(Builder builder) {
        super(builder.mediaSource);
        this.startUs = builder.startPositionUs;
        this.endUs = builder.endPositionUs;
        this.enableInitialDiscontinuity = builder.enableInitialDiscontinuity;
        this.allowDynamicClippingUpdates = builder.allowDynamicClippingUpdates;
        this.relativeToDefaultPosition = builder.relativeToDefaultPosition;
        this.allowUnseekableMedia = builder.allowUnseekableMedia;
        this.mediaPeriods = new ArrayList();
        this.window = new Timeline.Window();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final boolean canUpdateMediaItem(MediaItem mediaItem) {
        BaseMediaSource baseMediaSource = this.mediaSource;
        return baseMediaSource.getMediaItem().clippingConfiguration.equals(mediaItem.clippingConfiguration) && baseMediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaSource$MediaPeriodId, emojiProcessor, j), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs, 0);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void maybeThrowSourceInfoRefreshError() throws IllegalClippingException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.maybeThrowSourceInfoRefreshError();
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final void onChildSourceInfoRefreshed(Timeline timeline) {
        if (this.clippingError != null) {
            return;
        }
        refreshClippedTimeline(timeline);
    }

    public final void refreshClippedTimeline(Timeline timeline) {
        long j;
        long j2;
        long j3;
        Timeline.Window window = this.window;
        timeline.getWindow(0, window);
        long j4 = window.positionInFirstPeriodUs;
        ClippingTimeline clippingTimeline = this.clippingTimeline;
        long j5 = this.endUs;
        ArrayList arrayList = this.mediaPeriods;
        if (clippingTimeline == null || arrayList.isEmpty() || this.allowDynamicClippingUpdates) {
            boolean z = this.relativeToDefaultPosition;
            j = this.startUs;
            if (z) {
                long j6 = window.defaultPositionUs;
                j += j6;
                j2 = j6 + j5;
            } else {
                j2 = j5;
            }
            this.periodStartUs = j4 + j;
            this.periodEndUs = j5 != Long.MIN_VALUE ? j4 + j2 : Long.MIN_VALUE;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) arrayList.get(i);
                long j7 = this.periodStartUs;
                long j8 = this.periodEndUs;
                clippingMediaPeriod.startUs = j7;
                clippingMediaPeriod.endUs = j8;
            }
            j3 = j2;
        } else {
            j = this.periodStartUs - j4;
            j3 = j5 != Long.MIN_VALUE ? this.periodEndUs - j4 : Long.MIN_VALUE;
        }
        try {
            ClippingTimeline clippingTimeline2 = new ClippingTimeline(timeline, j, j3, this.allowUnseekableMedia);
            this.clippingTimeline = clippingTimeline2;
            refreshSourceInfo(clippingTimeline2);
        } catch (IllegalClippingException e) {
            this.clippingError = e;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((ClippingMediaPeriod) arrayList.get(i2)).clippingError = this.clippingError;
            }
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.mediaPeriods;
        UtilsKt.checkState(arrayList.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (!arrayList.isEmpty() || this.allowDynamicClippingUpdates) {
            return;
        }
        ClippingTimeline clippingTimeline = this.clippingTimeline;
        clippingTimeline.getClass();
        refreshClippedTimeline(clippingTimeline.timeline);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class IllegalClippingException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        public IllegalClippingException(int i, long j, long j2) {
            String str;
            if (i != 0) {
                if (i == 1) {
                    str = "not seekable to start";
                } else if (i != 2) {
                    str = "unknown";
                } else {
                    UtilsKt.checkState((j == -9223372036854775807L || j2 == -9223372036854775807L) ? false : true);
                    str = "start exceeds end. Start time: " + j + ", End time: " + j2;
                }
            } else {
                str = "invalid period count";
            }
            super("Illegal clipping: ".concat(str));
        }

        public IllegalClippingException(int i) {
            this(i, -9223372036854775807L, -9223372036854775807L);
        }
    }
}
