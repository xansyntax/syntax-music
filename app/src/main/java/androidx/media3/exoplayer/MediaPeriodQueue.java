package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util$$ExternalSyntheticLambda1;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaPeriodQueue {
    public final DefaultAnalyticsCollector analyticsCollector;
    public final SystemHandlerWrapper analyticsCollectorHandler;
    public int length;
    public MediaPeriodHolder loading;
    public final OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 mediaPeriodHolderFactory;
    public long nextWindowSequenceNumber;
    public Object oldFrontPeriodUid;
    public long oldFrontPeriodWindowSequenceNumber;
    public MediaPeriodHolder playing;
    public MediaPeriodHolder preloading;
    public MediaPeriodHolder prewarming;
    public MediaPeriodHolder reading;
    public int repeatMode;
    public boolean shuffleModeEnabled;
    public final Timeline.Period period = new Timeline.Period();
    public final Timeline.Window window = new Timeline.Window();
    public ArrayList preloadPriorityList = new ArrayList();

    public MediaPeriodQueue(DefaultAnalyticsCollector defaultAnalyticsCollector, SystemHandlerWrapper systemHandlerWrapper, OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0) {
        this.analyticsCollector = defaultAnalyticsCollector;
        this.analyticsCollectorHandler = systemHandlerWrapper;
        this.mediaPeriodHolderFactory = onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0062 A[LOOP:0: B:3:0x0013->B:28:0x0062, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x006d A[EDGE_INSN: B:40:0x006d->B:29:0x006d BREAK  A[LOOP:0: B:3:0x0013->B:28:0x0062], SYNTHETIC] */
    public static MediaSource$MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j, long j2, Timeline.Window window, Timeline.Period period) {
        timeline.getPeriodByUid(obj, period);
        timeline.getWindow(period.windowIndex, window);
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        Object obj2 = obj;
        while (true) {
            int i = period.adPlaybackState.adGroupCount;
            if (i == 0) {
                break;
            }
            if ((i == 1 && period.isLivePostrollPlaceholder(0)) || !period.isServerSideInsertedAdGroup(period.adPlaybackState.removedAdGroupCount)) {
                break;
            }
            long j3 = 0;
            if (period.getAdGroupIndexForPositionUs(0L) != -1) {
                break;
            }
            if (period.durationUs == 0) {
                if (indexOfPeriod <= window.lastPeriodIndex) {
                    break;
                    break;
                }
                timeline.getPeriod(indexOfPeriod, period, true);
                obj2 = period.uid;
                obj2.getClass();
                indexOfPeriod++;
            } else {
                int i2 = i - (period.isLivePostrollPlaceholder(i + (-1)) ? 2 : 1);
                for (int i3 = 0; i3 <= i2; i3++) {
                    j3 += period.adPlaybackState.getAdGroup(i3).contentResumeOffsetUs;
                }
                if (period.durationUs > j3) {
                    break;
                }
                if (indexOfPeriod <= window.lastPeriodIndex) {
                    break;
                }
                timeline.getPeriod(indexOfPeriod, period, true);
                obj2 = period.uid;
                obj2.getClass();
                indexOfPeriod++;
            }
        }
        timeline.getPeriodByUid(obj2, period);
        int adGroupIndexForPositionUs = period.getAdGroupIndexForPositionUs(j);
        return adGroupIndexForPositionUs == -1 ? new MediaSource$MediaPeriodId(period.getAdGroupIndexAfterPositionUs(j), j2, obj2) : new MediaSource$MediaPeriodId(obj2, adGroupIndexForPositionUs, period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j2, -1);
    }

    public final MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.next;
        }
        if (mediaPeriodHolder == this.prewarming) {
            this.prewarming = mediaPeriodHolder.next;
        }
        mediaPeriodHolder.release();
        int i = this.length - 1;
        this.length = i;
        if (i == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.id.windowSequenceNumber;
        }
        this.playing = this.playing.next;
        notifyQueueUpdate();
        return this.playing;
    }

    public final void clear() {
        if (this.length == 0) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        mediaPeriodHolder.getClass();
        this.oldFrontPeriodUid = mediaPeriodHolder.uid;
        this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.id.windowSequenceNumber;
        while (mediaPeriodHolder != null) {
            mediaPeriodHolder.release();
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.prewarming = null;
        this.length = 0;
        notifyQueueUpdate();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005d  */
    /* JADX WARN: Code duplicated, block: B:54:0x010b  */
    public final MediaPeriodInfo getFirstMediaPeriodInfoOfNextPeriod(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        Object obj;
        long j2;
        Timeline.Window window;
        long j3;
        long j4;
        long j5;
        long j6;
        long jMax;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        long j7 = mediaPeriodInfo.requestedContentPositionUs;
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid);
        int i = this.repeatMode;
        boolean z = this.shuffleModeEnabled;
        Timeline.Period period = this.period;
        Timeline.Window window2 = this.window;
        int nextPeriodIndex = timeline.getNextPeriodIndex(indexOfPeriod, period, window2, i, z);
        if (nextPeriodIndex == -1) {
            return null;
        }
        int i2 = timeline.getPeriod(nextPeriodIndex, period, true).windowIndex;
        Object obj2 = period.uid;
        obj2.getClass();
        long j8 = mediaSource$MediaPeriodId.windowSequenceNumber;
        long j9 = -9223372036854775807L;
        if (timeline.getWindow(i2, window2, 0L).firstPeriodIndex == nextPeriodIndex) {
            int i3 = period.windowIndex;
            if (period.durationUs != -9223372036854775807L) {
                jMax = -9223372036854775807L;
            } else {
                timeline.getWindow(i3, window2);
                if (!window2.isDynamic || window2.isPlaceholder) {
                    jMax = -9223372036854775807L;
                } else {
                    jMax = Math.max(0L, j);
                }
            }
            window = window2;
            Pair periodPositionUs = timeline.getPeriodPositionUs(window, period, i2, -9223372036854775807L, jMax);
            if (periodPositionUs == null) {
                return null;
            }
            obj = periodPositionUs.first;
            long jLongValue = ((Long) periodPositionUs.second).longValue();
            MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder.next;
            if (mediaPeriodHolder2 == null || !mediaPeriodHolder2.uid.equals(obj)) {
                long jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(obj);
                if (jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods == -1) {
                    jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods + 1;
                }
                j2 = jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
            } else {
                j2 = mediaPeriodHolder2.info.id.windowSequenceNumber;
            }
            j3 = jLongValue;
            j4 = jMax;
        } else {
            timeline = timeline;
            obj = obj2;
            j2 = j8;
            j9 = 0;
            period = period;
            window = window2;
            j3 = 0;
            j4 = -9223372036854775807L;
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodIdResolveMediaPeriodIdForAds = resolveMediaPeriodIdForAds(timeline, obj, j3, j2, window, period);
        if (j9 == -9223372036854775807L || j7 == -9223372036854775807L) {
            j5 = j3;
            j6 = j9;
        } else {
            int i4 = timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, period).adPlaybackState.adGroupCount;
            int i5 = period.adPlaybackState.removedAdGroupCount;
            boolean z2 = i4 > 0 && period.isServerSideInsertedAdGroup(i5) && (i4 > 1 || period.getAdGroupTimeUs(i5) != Long.MIN_VALUE);
            if (mediaSource$MediaPeriodIdResolveMediaPeriodIdForAds.isAd() && z2) {
                j5 = j3;
                j6 = j7;
            } else {
                if (z2) {
                    j5 = j7;
                } else {
                    j5 = j3;
                }
                j6 = j9;
            }
        }
        return getMediaPeriodInfo(timeline, mediaSource$MediaPeriodIdResolveMediaPeriodIdForAds, j6, j5, j4);
    }

    public final MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j) {
        Timeline timeline2;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long j2 = (mediaPeriodHolder.rendererPositionOffsetUs + mediaPeriodInfo.durationUs) - j;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            return getFirstMediaPeriodInfoOfNextPeriod(timeline, mediaPeriodHolder, j2);
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        Object obj = mediaSource$MediaPeriodId.periodUid;
        int i = mediaSource$MediaPeriodId.nextAdGroupIndex;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        boolean z = mediaPeriodInfo.isFollowedByTransitionToSameStream;
        if (!mediaSource$MediaPeriodId.isAd()) {
            if (i != -1 && period.isLivePostrollPlaceholder(i)) {
                return getFirstMediaPeriodInfoOfNextPeriod(timeline, mediaPeriodHolder, j2);
            }
            int firstAdIndexToPlay = period.getFirstAdIndexToPlay(i);
            boolean z2 = period.isServerSideInsertedAdGroup(i) && period.getAdState(i, firstAdIndexToPlay) == 3;
            if (firstAdIndexToPlay != period.adPlaybackState.getAdGroup(i).count && !z2) {
                return getMediaPeriodInfoForAd(timeline, mediaSource$MediaPeriodId.periodUid, mediaSource$MediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaSource$MediaPeriodId.windowSequenceNumber, z);
            }
            timeline.getPeriodByUid(obj, period);
            long adGroupTimeUs = period.getAdGroupTimeUs(i);
            return getMediaPeriodInfoForContent(timeline, mediaSource$MediaPeriodId.periodUid, adGroupTimeUs == Long.MIN_VALUE ? period.durationUs : period.adPlaybackState.getAdGroup(i).contentResumeOffsetUs + adGroupTimeUs, -9223372036854775807L, mediaPeriodInfo.durationUs, mediaSource$MediaPeriodId.windowSequenceNumber, false);
        }
        int i2 = mediaSource$MediaPeriodId.adGroupIndex;
        int i3 = period.adPlaybackState.getAdGroup(i2).count;
        if (i3 == -1) {
            return null;
        }
        int nextAdIndexToPlay = period.adPlaybackState.getAdGroup(i2).getNextAdIndexToPlay(mediaSource$MediaPeriodId.adIndexInAdGroup);
        if (nextAdIndexToPlay < i3) {
            return getMediaPeriodInfoForAd(timeline, mediaSource$MediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaSource$MediaPeriodId.windowSequenceNumber, z);
        }
        long jLongValue = mediaPeriodInfo.requestedContentPositionUs;
        long jMax = -9223372036854775807L;
        if (jLongValue == -9223372036854775807L) {
            int i4 = period.windowIndex;
            long j3 = period.durationUs;
            Timeline.Window window = this.window;
            if (j3 == -9223372036854775807L) {
                timeline.getWindow(i4, window);
                if (window.isDynamic && !window.isPlaceholder) {
                    jMax = Math.max(0L, j2);
                }
            }
            long j4 = jMax;
            timeline2 = timeline;
            Pair periodPositionUs = timeline2.getPeriodPositionUs(window, period, period.windowIndex, -9223372036854775807L, j4);
            if (periodPositionUs == null) {
                return null;
            }
            jLongValue = ((Long) periodPositionUs.second).longValue();
            jMax = j4;
        } else {
            timeline2 = timeline;
        }
        int i5 = mediaSource$MediaPeriodId.adGroupIndex;
        timeline2.getPeriodByUid(obj, period);
        long adGroupTimeUs2 = period.getAdGroupTimeUs(i5);
        return getMediaPeriodInfoForContent(timeline2, mediaSource$MediaPeriodId.periodUid, Math.max(adGroupTimeUs2 == Long.MIN_VALUE ? period.durationUs : period.adPlaybackState.getAdGroup(i5).contentResumeOffsetUs + adGroupTimeUs2, jLongValue), jMax, mediaPeriodInfo.requestedContentPositionUs, mediaSource$MediaPeriodId.windowSequenceNumber, z);
    }

    public final MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, long j2, long j3) {
        timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, this.period);
        boolean zIsAd = mediaSource$MediaPeriodId.isAd();
        Object obj = mediaSource$MediaPeriodId.periodUid;
        return zIsAd ? getMediaPeriodInfoForAd(timeline, obj, mediaSource$MediaPeriodId.adGroupIndex, mediaSource$MediaPeriodId.adIndexInAdGroup, j, mediaSource$MediaPeriodId.windowSequenceNumber, false) : getMediaPeriodInfoForContent(timeline, obj, j2, j3, j, mediaSource$MediaPeriodId.windowSequenceNumber, false);
    }

    public final MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i, int i2, long j, long j2, boolean z) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(obj, i, i2, j2, -1);
        Timeline.Period period = this.period;
        long adDurationUs = timeline.getPeriodByUid(obj, period).getAdDurationUs(i, i2);
        long jMax = i2 == period.getFirstAdIndexToPlay(i) ? period.adPlaybackState.adResumePositionUs : 0L;
        boolean zIsServerSideInsertedAdGroup = period.isServerSideInsertedAdGroup(i);
        if (adDurationUs != -9223372036854775807L && jMax >= adDurationUs) {
            jMax = Math.max(0L, adDurationUs - 1);
        }
        return new MediaPeriodInfo(mediaSource$MediaPeriodId, jMax, -9223372036854775807L, j, -9223372036854775807L, adDurationUs, z, zIsServerSideInsertedAdGroup, false, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4  */
    public final MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object obj, long j, long j2, long j3, long j4, boolean z) {
        AdPlaybackState.AdGroup adGroup;
        int i;
        boolean z2;
        long j5;
        long adGroupTimeUs;
        long j6;
        long jMax;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        int adGroupIndexAfterPositionUs = period.getAdGroupIndexAfterPositionUs(j);
        int i2 = 1;
        if (adGroupIndexAfterPositionUs == -1) {
            AdPlaybackState adPlaybackState = period.adPlaybackState;
            if (adPlaybackState.adGroupCount <= 0 || !period.isServerSideInsertedAdGroup(adPlaybackState.removedAdGroupCount)) {
                z2 = false;
                break;
            }
            z2 = true;
        } else {
            if (!period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs) || period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) != period.durationUs || (i = (adGroup = period.adPlaybackState.getAdGroup(adGroupIndexAfterPositionUs)).count) == -1) {
                z2 = false;
                break;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    z2 = true;
                    adGroupIndexAfterPositionUs = -1;
                    break;
                }
                int i4 = adGroup.states[i3];
                if (i4 == 0 || i4 == 1) {
                    z2 = false;
                    break;
                }
                i3++;
            }
        }
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(adGroupIndexAfterPositionUs, j4, obj);
        boolean z3 = !mediaSource$MediaPeriodId.isAd() && adGroupIndexAfterPositionUs == -1;
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaSource$MediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaSource$MediaPeriodId, z3);
        boolean z4 = (adGroupIndexAfterPositionUs == -1 || !period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs) || period.isLivePostrollPlaceholder(adGroupIndexAfterPositionUs)) ? false : true;
        boolean z5 = adGroupIndexAfterPositionUs != -1 && period.isLivePostrollPlaceholder(adGroupIndexAfterPositionUs) && period.isServerSideInsertedAdGroup(adGroupIndexAfterPositionUs);
        if (adGroupIndexAfterPositionUs == -1 || z5) {
            if (z2) {
                adGroupTimeUs = period.durationUs;
            } else {
                j5 = -9223372036854775807L;
            }
            if (j5 != -9223372036854775807L || j5 == Long.MIN_VALUE) {
                j6 = period.durationUs;
            } else {
                j6 = j5;
            }
            if (j6 != -9223372036854775807L || j < j6) {
                jMax = j;
            } else {
                if (!zIsLastInTimeline && z2) {
                    i2 = 0;
                }
                jMax = Math.max(0L, j6 - ((long) i2));
            }
            return new MediaPeriodInfo(mediaSource$MediaPeriodId, jMax, j2, j3, j5, j6, z, z4, z3, zIsLastInWindow, zIsLastInTimeline);
        }
        adGroupTimeUs = period.getAdGroupTimeUs(adGroupIndexAfterPositionUs);
        j5 = adGroupTimeUs;
        if (j5 != -9223372036854775807L) {
            j6 = period.durationUs;
        } else {
            j6 = period.durationUs;
        }
        if (j6 != -9223372036854775807L) {
            jMax = j;
        } else {
            jMax = j;
        }
        return new MediaPeriodInfo(mediaSource$MediaPeriodId, jMax, j2, j3, j5, j6, z, z4, z3, zIsLastInWindow, zIsLastInTimeline);
    }

    public final MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long adDurationUs;
        boolean z;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
        int i = mediaSource$MediaPeriodId.nextAdGroupIndex;
        boolean zIsServerSideInsertedAdGroup = false;
        boolean z2 = !mediaSource$MediaPeriodId.isAd() && i == -1;
        int i2 = mediaSource$MediaPeriodId.adGroupIndex;
        boolean zIsLastInWindow = isLastInWindow(timeline, mediaSource$MediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(timeline, mediaSource$MediaPeriodId, z2);
        Object obj = mediaSource$MediaPeriodId.periodUid;
        Timeline.Period period = this.period;
        timeline.getPeriodByUid(obj, period);
        long adGroupTimeUs = (mediaSource$MediaPeriodId.isAd() || i == -1) ? -9223372036854775807L : period.getAdGroupTimeUs(i);
        if (mediaSource$MediaPeriodId.isAd()) {
            adDurationUs = period.getAdDurationUs(i2, mediaSource$MediaPeriodId.adIndexInAdGroup);
        } else {
            adDurationUs = (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) ? period.durationUs : adGroupTimeUs;
        }
        if (!mediaSource$MediaPeriodId.isAd()) {
            if (i != -1 && period.isServerSideInsertedAdGroup(i)) {
                z = true;
            }
            return new MediaPeriodInfo(mediaSource$MediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.liveStreamStartPositionProjectionUs, mediaPeriodInfo.requestedContentPositionUs, adGroupTimeUs, adDurationUs, mediaPeriodInfo.isPrecededByTransitionFromSameStream, z, z2, zIsLastInWindow, zIsLastInTimeline);
        }
        zIsServerSideInsertedAdGroup = period.isServerSideInsertedAdGroup(i2);
        z = zIsServerSideInsertedAdGroup;
        return new MediaPeriodInfo(mediaSource$MediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.liveStreamStartPositionProjectionUs, mediaPeriodInfo.requestedContentPositionUs, adGroupTimeUs, adDurationUs, mediaPeriodInfo.isPrecededByTransitionFromSameStream, z, z2, zIsLastInWindow, zIsLastInTimeline);
    }

    public final boolean isLastInTimeline(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, boolean z) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaSource$MediaPeriodId.periodUid);
        Timeline.Period period = this.period;
        int i = timeline.getPeriod(indexOfPeriod, period, false).windowIndex;
        Timeline.Window window = this.window;
        return !timeline.getWindow(i, window, 0L).isDynamic && timeline.getNextPeriodIndex(indexOfPeriod, period, window, this.repeatMode, this.shuffleModeEnabled) == -1 && z;
    }

    public final boolean isLastInWindow(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        boolean z = !mediaSource$MediaPeriodId.isAd() && mediaSource$MediaPeriodId.nextAdGroupIndex == -1;
        Object obj = mediaSource$MediaPeriodId.periodUid;
        if (z) {
            if (timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window, 0L).lastPeriodIndex == timeline.getIndexOfPeriod(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void maybeUpdatePreloadMediaPeriodHolder() {
        MediaPeriodHolder mediaPeriodHolder = this.preloading;
        if (mediaPeriodHolder == null || mediaPeriodHolder.isFullyPreloaded()) {
            this.preloading = null;
            for (int i = 0; i < this.preloadPriorityList.size(); i++) {
                MediaPeriodHolder mediaPeriodHolder2 = (MediaPeriodHolder) this.preloadPriorityList.get(i);
                if (!mediaPeriodHolder2.isFullyPreloaded()) {
                    this.preloading = mediaPeriodHolder2;
                    return;
                }
            }
        }
    }

    public final void notifyQueueUpdate() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.next) {
            builder.add((Object) mediaPeriodHolder.info.id);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.reading;
        this.analyticsCollectorHandler.post(new Util$$ExternalSyntheticLambda1((Object) this, (Object) builder, (Object) (mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.info.id), (byte) 5));
    }

    public final void reevaluateBuffer(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            UtilsKt.checkState(mediaPeriodHolder.next == null);
            if (mediaPeriodHolder.prepared) {
                mediaPeriodHolder.mediaPeriod.reevaluateBuffer(j - mediaPeriodHolder.rendererPositionOffsetUs);
            }
        }
    }

    public final int removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        mediaPeriodHolder.getClass();
        int i = 0;
        if (mediaPeriodHolder != this.loading) {
            this.loading = mediaPeriodHolder;
            while (true) {
                mediaPeriodHolder = mediaPeriodHolder.next;
                if (mediaPeriodHolder == null) {
                    break;
                }
                MediaPeriodHolder mediaPeriodHolder2 = this.reading;
                if (mediaPeriodHolder == mediaPeriodHolder2) {
                    mediaPeriodHolder2 = this.playing;
                    this.reading = mediaPeriodHolder2;
                    this.prewarming = mediaPeriodHolder2;
                    i = 3;
                }
                if (mediaPeriodHolder == this.prewarming) {
                    this.prewarming = mediaPeriodHolder2;
                    i |= 2;
                }
                mediaPeriodHolder.release();
                this.length--;
            }
            MediaPeriodHolder mediaPeriodHolder3 = this.loading;
            mediaPeriodHolder3.getClass();
            if (mediaPeriodHolder3.next != null) {
                mediaPeriodHolder3.disableTrackSelectionsInResult();
                mediaPeriodHolder3.next = null;
                mediaPeriodHolder3.enableTrackSelectionsInResult();
            }
            notifyQueueUpdate();
        }
        return i;
    }

    public final MediaSource$MediaPeriodId resolveMediaPeriodIdForAdsAfterPeriodPositionChange(Timeline timeline, Object obj, long j) {
        long jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
        int indexOfPeriod;
        Timeline.Period period = this.period;
        int i = timeline.getPeriodByUid(obj, period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 == null || (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) == -1 || timeline.getPeriod(indexOfPeriod, period, false).windowIndex != i) {
            MediaPeriodHolder mediaPeriodHolder = this.playing;
            while (true) {
                if (mediaPeriodHolder == null) {
                    MediaPeriodHolder mediaPeriodHolder2 = this.playing;
                    while (true) {
                        if (mediaPeriodHolder2 == null) {
                            jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(obj);
                            if (jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods != -1) {
                                break;
                            }
                            jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = this.nextWindowSequenceNumber;
                            this.nextWindowSequenceNumber = 1 + jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
                            if (this.playing != null) {
                                break;
                            }
                            this.oldFrontPeriodUid = obj;
                            this.oldFrontPeriodWindowSequenceNumber = jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods;
                            break;
                        }
                        int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaPeriodHolder2.uid);
                        if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, period, false).windowIndex == i) {
                            jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = mediaPeriodHolder2.info.id.windowSequenceNumber;
                            break;
                        }
                        mediaPeriodHolder2 = mediaPeriodHolder2.next;
                    }
                } else {
                    if (mediaPeriodHolder.uid.equals(obj)) {
                        jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = mediaPeriodHolder.info.id.windowSequenceNumber;
                        break;
                    }
                    mediaPeriodHolder = mediaPeriodHolder.next;
                }
            }
        } else {
            jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods = this.oldFrontPeriodWindowSequenceNumber;
        }
        timeline.getPeriodByUid(obj, period);
        int i2 = period.windowIndex;
        Timeline.Window window = this.window;
        timeline.getWindow(i2, window);
        Object obj3 = obj;
        boolean z = false;
        for (int indexOfPeriod3 = timeline.getIndexOfPeriod(obj); indexOfPeriod3 >= window.firstPeriodIndex; indexOfPeriod3--) {
            timeline.getPeriod(indexOfPeriod3, period, true);
            boolean z2 = period.adPlaybackState.adGroupCount > 0;
            z |= z2;
            if (period.getAdGroupIndexForPositionUs(period.durationUs) != -1) {
                obj3 = period.uid;
                obj3.getClass();
            }
            if (z && (!z2 || period.durationUs != 0)) {
                break;
            }
        }
        return resolveMediaPeriodIdForAds(timeline, obj3, j, jResolvePeriodUidToWindowSequenceNumberInPreloadPeriods, window, period);
    }

    public final long resolvePeriodUidToWindowSequenceNumberInPreloadPeriods(Object obj) {
        for (int i = 0; i < this.preloadPriorityList.size(); i++) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) this.preloadPriorityList.get(i);
            if (mediaPeriodHolder.uid.equals(obj)) {
                return mediaPeriodHolder.info.id.windowSequenceNumber;
            }
        }
        return -1L;
    }

    public final int updateForPlaybackModeChange(Timeline timeline) {
        Timeline timeline2;
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2 = this.playing;
        if (mediaPeriodHolder2 == null) {
            return 0;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodHolder2.uid);
        while (true) {
            timeline2 = timeline;
            indexOfPeriod = timeline2.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (true) {
                mediaPeriodHolder = mediaPeriodHolder2.next;
                if (mediaPeriodHolder == null || mediaPeriodHolder2.info.isLastInTimelinePeriod) {
                    break;
                }
                mediaPeriodHolder2 = mediaPeriodHolder;
            }
            if (indexOfPeriod == -1 || mediaPeriodHolder == null || timeline2.getIndexOfPeriod(mediaPeriodHolder.uid) != indexOfPeriod) {
                break;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            timeline = timeline2;
        }
        int iRemoveAfter = removeAfter(mediaPeriodHolder2);
        mediaPeriodHolder2.info = getUpdatedMediaPeriodInfo(timeline2, mediaPeriodHolder2.info);
        return iRemoveAfter;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00c9  */
    public final int updateQueuedPeriods(Timeline timeline, long j, long j2, long j3) {
        long j4;
        int i;
        MediaPeriodInfo mediaPeriodInfoCopyWithStartPositionUs;
        int i2;
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
            if (mediaPeriodHolder2 != null) {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder2, j);
                if (followingMediaPeriodInfo != null) {
                    long j5 = followingMediaPeriodInfo.startPositionUs;
                    MediaSource$MediaPeriodId mediaSource$MediaPeriodId = mediaPeriodInfo.id;
                    long j6 = mediaPeriodInfo.liveStreamStartPositionProjectionUs;
                    j4 = -9223372036854775807L;
                    long j7 = mediaPeriodInfo.startPositionUs;
                    i = 0;
                    if (mediaSource$MediaPeriodId.equals(followingMediaPeriodInfo.id)) {
                        if (j7 != j5) {
                            if (j6 != -9223372036854775807L) {
                                long j8 = followingMediaPeriodInfo.liveStreamStartPositionProjectionUs;
                                if (j8 != -9223372036854775807L) {
                                    if (Math.abs((j5 - j8) - (j7 - j6)) >= 5000000) {
                                    }
                                }
                            }
                        }
                        mediaPeriodInfoCopyWithStartPositionUs = j7 != j5 ? followingMediaPeriodInfo.copyWithStartPositionUs(j7, j6) : followingMediaPeriodInfo;
                    }
                }
                return removeAfter(mediaPeriodHolder2);
            }
            mediaPeriodInfoCopyWithStartPositionUs = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo);
            j4 = -9223372036854775807L;
            i = 0;
            long j9 = mediaPeriodInfoCopyWithStartPositionUs.durationUs;
            long j10 = mediaPeriodInfo.requestedContentPositionUs;
            long j11 = mediaPeriodInfo.durationUs;
            mediaPeriodHolder.info = mediaPeriodInfoCopyWithStartPositionUs.copyWithRequestedContentPositionUs(j10);
            if (j11 != j9) {
                mediaPeriodHolder.updateClipping();
                long j12 = j9 == j4 ? Long.MAX_VALUE : j9 + mediaPeriodHolder.rendererPositionOffsetUs;
                int i3 = 1;
                int i4 = (mediaPeriodHolder != this.reading || mediaPeriodHolder.info.isFollowedByTransitionToSameStream || (j2 != Long.MIN_VALUE && j2 < j12)) ? i : 1;
                int i5 = (mediaPeriodHolder != this.prewarming || (j3 != Long.MIN_VALUE && j3 < j12)) ? i : 1;
                int iRemoveAfter = removeAfter(mediaPeriodHolder);
                if (iRemoveAfter != 0) {
                    return iRemoveAfter;
                }
                if (j11 == j4 && mediaPeriodInfo.endPositionUs == Long.MIN_VALUE) {
                    long j13 = mediaPeriodInfoCopyWithStartPositionUs.endPositionUs;
                    if (j13 == j4 || j13 == Long.MIN_VALUE) {
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                } else {
                    i2 = i;
                }
                if (i4 == 0 || (j11 == j4 && i2 == 0)) {
                    i3 = i;
                }
                return i5 != 0 ? i3 | 2 : i3;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.next;
        }
        return 0;
    }
}
