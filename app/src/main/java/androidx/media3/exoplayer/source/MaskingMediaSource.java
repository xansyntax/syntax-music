package androidx.media3.exoplayer.source;

import android.util.Pair;
import androidx.emoji2.text.EmojiProcessor;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MaskingMediaSource extends WrappingMediaSource {
    public boolean hasRealTimeline;
    public boolean hasStartedPreparing;
    public boolean isPrepared;
    public final Timeline.Period period;
    public MaskingTimeline timeline;
    public MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    public final boolean useLazyPreparation;
    public final Timeline.Window window;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MaskingTimeline extends ForwardingTimeline {
        public static final Object MASKING_EXTERNAL_PERIOD_UID = new Object();
        public final Object replacedInternalPeriodUid;
        public final Object replacedInternalWindowUid;

        public MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final int getIndexOfPeriod(Object obj) {
            Object obj2;
            if (MASKING_EXTERNAL_PERIOD_UID == obj && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return this.timeline.getIndexOfPeriod(obj);
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Objects.equals(period.uid, this.replacedInternalPeriodUid) && z) {
                period.uid = MASKING_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Objects.equals(uidOfPeriod, this.replacedInternalPeriodUid) ? MASKING_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }

        @Override // androidx.media3.exoplayer.source.ForwardingTimeline, androidx.media3.common.Timeline
        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Objects.equals(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaceholderTimeline extends Timeline {
        public final MediaItem mediaItem;

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
        }

        @Override // androidx.media3.common.Timeline
        public final int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            period.set(z ? 0 : null, z ? MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID : null, 0, -9223372036854775807L, 0L, AdPlaybackState.NONE, true);
            return period;
        }

        @Override // androidx.media3.common.Timeline
        public final int getPeriodCount() {
            return 1;
        }

        @Override // androidx.media3.common.Timeline
        public final Object getUidOfPeriod(int i) {
            return MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }

        @Override // androidx.media3.common.Timeline
        public final Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // androidx.media3.common.Timeline
        public final int getWindowCount() {
            return 1;
        }
    }

    public MaskingMediaSource(BaseMediaSource baseMediaSource, boolean z) {
        super(baseMediaSource);
        this.useLazyPreparation = z && baseMediaSource.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = baseMediaSource.getInitialTimeline();
        if (initialTimeline == null) {
            this.timeline = new MaskingTimeline(new PlaceholderTimeline(baseMediaSource.getMediaItem()), Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID);
        } else {
            this.timeline = new MaskingTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
        }
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final boolean canUpdateMediaItem(MediaItem mediaItem) {
        return this.mediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final MaskingMediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, EmojiProcessor emojiProcessor, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaSource$MediaPeriodId, emojiProcessor, j);
        UtilsKt.checkState(maskingMediaPeriod.mediaSource == null);
        maskingMediaPeriod.mediaSource = this.mediaSource;
        if (!this.isPrepared) {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource();
            }
            return maskingMediaPeriod;
        }
        Object obj = mediaSource$MediaPeriodId.periodUid;
        if (this.timeline.replacedInternalPeriodUid != null && obj.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) {
            obj = this.timeline.replacedInternalPeriodUid;
        }
        maskingMediaPeriod.createPeriod(mediaSource$MediaPeriodId.copyWithPeriodUid(obj));
        return maskingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Object obj = mediaSource$MediaPeriodId.periodUid;
        Object obj2 = this.timeline.replacedInternalPeriodUid;
        if (obj2 != null && obj2.equals(obj)) {
            obj = MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
        return mediaSource$MediaPeriodId.copyWithPeriodUid(obj);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final void onChildSourceInfoRefreshed(Timeline timeline) {
        long j;
        MaskingTimeline maskingTimeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodIdCopyWithPeriodUid;
        MaskingTimeline maskingTimeline2;
        if (this.isPrepared) {
            MaskingTimeline maskingTimeline3 = this.timeline;
            this.timeline = new MaskingTimeline(timeline, maskingTimeline3.replacedInternalWindowUid, maskingTimeline3.replacedInternalPeriodUid);
            MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
            if (maskingMediaPeriod != null) {
                setPreparePositionOverrideToUnpreparedMaskingPeriod(maskingMediaPeriod.preparePositionOverrideUs);
            }
        } else {
            if (!timeline.isEmpty()) {
                Timeline.Window window = this.window;
                timeline.getWindow(0, window);
                long j2 = window.defaultPositionUs;
                Object obj = window.uid;
                MaskingMediaPeriod maskingMediaPeriod2 = this.unpreparedMaskingMediaPeriod;
                Timeline.Period period = this.period;
                if (maskingMediaPeriod2 != null) {
                    long j3 = maskingMediaPeriod2.preparePositionUs;
                    this.timeline.getPeriodByUid(maskingMediaPeriod2.id.periodUid, period);
                    long j4 = period.positionInWindowUs + j3;
                    this.timeline.getWindow(0, window, 0L);
                    if (j4 != window.defaultPositionUs) {
                        j = j4;
                    } else {
                        j = j2;
                    }
                } else {
                    j = j2;
                }
                Pair periodPositionUs = timeline.getPeriodPositionUs(window, period, 0, j);
                Object obj2 = periodPositionUs.first;
                long jLongValue = ((Long) periodPositionUs.second).longValue();
                if (this.hasRealTimeline) {
                    MaskingTimeline maskingTimeline4 = this.timeline;
                    maskingTimeline = new MaskingTimeline(timeline, maskingTimeline4.replacedInternalWindowUid, maskingTimeline4.replacedInternalPeriodUid);
                } else {
                    maskingTimeline = new MaskingTimeline(timeline, obj, obj2);
                }
                this.timeline = maskingTimeline;
                MaskingMediaPeriod maskingMediaPeriod3 = this.unpreparedMaskingMediaPeriod;
                if (maskingMediaPeriod3 != null && setPreparePositionOverrideToUnpreparedMaskingPeriod(jLongValue)) {
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId = maskingMediaPeriod3.id;
                    Object obj3 = mediaSource$MediaPeriodId.periodUid;
                    if (this.timeline.replacedInternalPeriodUid != null && obj3.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) {
                        obj3 = this.timeline.replacedInternalPeriodUid;
                    }
                    mediaSource$MediaPeriodIdCopyWithPeriodUid = mediaSource$MediaPeriodId.copyWithPeriodUid(obj3);
                }
                this.hasRealTimeline = true;
                this.isPrepared = true;
                refreshSourceInfo(this.timeline);
                if (mediaSource$MediaPeriodIdCopyWithPeriodUid != null) {
                    MaskingMediaPeriod maskingMediaPeriod4 = this.unpreparedMaskingMediaPeriod;
                    maskingMediaPeriod4.getClass();
                    maskingMediaPeriod4.createPeriod(mediaSource$MediaPeriodIdCopyWithPeriodUid);
                }
            }
            if (this.hasRealTimeline) {
                MaskingTimeline maskingTimeline5 = this.timeline;
                maskingTimeline2 = new MaskingTimeline(timeline, maskingTimeline5.replacedInternalWindowUid, maskingTimeline5.replacedInternalPeriodUid);
            } else {
                maskingTimeline2 = new MaskingTimeline(timeline, Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID);
            }
            this.timeline = maskingTimeline2;
        }
        mediaSource$MediaPeriodIdCopyWithPeriodUid = null;
        this.hasRealTimeline = true;
        this.isPrepared = true;
        refreshSourceInfo(this.timeline);
        if (mediaSource$MediaPeriodIdCopyWithPeriodUid != null) {
            MaskingMediaPeriod maskingMediaPeriod5 = this.unpreparedMaskingMediaPeriod;
            maskingMediaPeriod5.getClass();
            maskingMediaPeriod5.createPeriod(mediaSource$MediaPeriodIdCopyWithPeriodUid);
        }
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource
    public final void prepareSourceInternal() {
        if (this.useLazyPreparation) {
            return;
        }
        this.hasStartedPreparing = true;
        prepareChildSource();
    }

    @Override // androidx.media3.exoplayer.source.BaseMediaSource
    public final void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        if (maskingMediaPeriod.mediaPeriod != null) {
            BaseMediaSource baseMediaSource = maskingMediaPeriod.mediaSource;
            baseMediaSource.getClass();
            baseMediaSource.releasePeriod(maskingMediaPeriod.mediaPeriod);
        }
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    public final boolean setPreparePositionOverrideToUnpreparedMaskingPeriod(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        MaskingTimeline maskingTimeline = this.timeline;
        Timeline.Period period = this.period;
        maskingTimeline.getPeriod(indexOfPeriod, period, false);
        long j2 = period.durationUs;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.preparePositionOverrideUs = j;
        return true;
    }

    @Override // androidx.media3.exoplayer.source.WrappingMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    public final void updateMediaItem(MediaItem mediaItem) {
        if (this.hasRealTimeline) {
            MaskingTimeline maskingTimeline = this.timeline;
            Timeline timeline = maskingTimeline.timeline;
            this.timeline = new MaskingTimeline(timeline instanceof TimelineWithUpdatedMediaItem ? new TimelineWithUpdatedMediaItem(((TimelineWithUpdatedMediaItem) timeline).timeline, mediaItem) : new TimelineWithUpdatedMediaItem(timeline, mediaItem), maskingTimeline.replacedInternalWindowUid, maskingTimeline.replacedInternalPeriodUid);
        } else {
            this.timeline = new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.SINGLE_WINDOW_UID, MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID);
        }
        this.mediaSource.updateMediaItem(mediaItem);
    }
}
