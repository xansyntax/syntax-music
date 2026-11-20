package androidx.media3.exoplayer.analytics;

import android.util.Pair;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import coil3.util.UtilsKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.metrolist.music.App;
import com.metrolist.music.constants.PreferenceKeysKt;
import com.metrolist.music.playback.MusicService;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager$Listener {
    public Format audioFormat;
    public long bandwidthBytes;
    public long bandwidthTimeMs;
    public final MusicService callback;
    public long discontinuityFromPositionMs;
    public String discontinuityFromSession;
    public int discontinuityReason;
    public int droppedFrames;
    public PlaybackStats finishedPlaybackStats;
    public Exception nonFatalException;
    public final Timeline.Period period;
    public final HashMap playbackStatsTrackers;
    public final DefaultPlaybackSessionManager sessionManager;
    public final HashMap sessionStartEventTimes;
    public Format videoFormat;
    public VideoSize videoSize;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlaybackStatsTracker {
        public long audioFormatBitrateTimeProduct;
        public final List audioFormatHistory;
        public long audioFormatTimeMs;
        public long audioUnderruns;
        public long bandwidthBytes;
        public long bandwidthTimeMs;
        public Format currentAudioFormat;
        public float currentPlaybackSpeed;
        public int currentPlaybackState;
        public long currentPlaybackStateStartTimeMs;
        public Format currentVideoFormat;
        public long droppedFrames;
        public int fatalErrorCount;
        public final List fatalErrorHistory;
        public long firstReportedTimeMs;
        public boolean hasBeenReady;
        public boolean hasEnded;
        public boolean hasFatalError;
        public long initialAudioFormatBitrate;
        public long initialVideoFormatBitrate;
        public int initialVideoFormatHeight;
        public final boolean isAd;
        public boolean isForeground;
        public boolean isInterruptedByAd;
        public boolean isJoinTimeInvalid;
        public boolean isSeeking;
        public long lastAudioFormatStartTimeMs;
        public long lastRebufferStartTimeMs;
        public long lastVideoFormatStartTimeMs;
        public long maxRebufferTimeMs;
        public final List mediaTimeHistory;
        public int nonFatalErrorCount;
        public final List nonFatalErrorHistory;
        public int pauseBufferCount;
        public int pauseCount;
        public final long[] playbackStateDurationsMs = new long[16];
        public final List playbackStateHistory;
        public int rebufferCount;
        public int seekCount;
        public boolean startedLoading;
        public long videoFormatBitrateTimeMs;
        public long videoFormatBitrateTimeProduct;
        public long videoFormatHeightTimeMs;
        public long videoFormatHeightTimeProduct;
        public final List videoFormatHistory;

        public PlaybackStatsTracker(AnalyticsListener.EventTime eventTime) {
            List list = Collections.EMPTY_LIST;
            this.playbackStateHistory = list;
            this.mediaTimeHistory = list;
            this.videoFormatHistory = list;
            this.audioFormatHistory = list;
            this.fatalErrorHistory = list;
            this.nonFatalErrorHistory = list;
            boolean z = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            this.firstReportedTimeMs = -9223372036854775807L;
            this.maxRebufferTimeMs = -9223372036854775807L;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime.mediaPeriodId;
            if (mediaSource$MediaPeriodId != null && mediaSource$MediaPeriodId.isAd()) {
                z = true;
            }
            this.isAd = z;
            this.initialAudioFormatBitrate = -1L;
            this.initialVideoFormatBitrate = -1L;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        public static boolean isRebufferingState(int i) {
            return i == 6 || i == 7 || i == 10;
        }

        public final void maybeRecordAudioFormatTime(long j) {
            Format format;
            int i;
            if (this.currentPlaybackState == 3 && (format = this.currentAudioFormat) != null && (i = format.bitrate) != -1) {
                long j2 = (long) ((j - this.lastAudioFormatStartTimeMs) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j2;
                this.audioFormatBitrateTimeProduct = (j2 * ((long) i)) + this.audioFormatBitrateTimeProduct;
            }
            this.lastAudioFormatStartTimeMs = j;
        }

        public final void maybeRecordVideoFormatTime(long j) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j2 = (long) ((j - this.lastVideoFormatStartTimeMs) * this.currentPlaybackSpeed);
                int i = format.height;
                if (i != -1) {
                    this.videoFormatHeightTimeMs += j2;
                    this.videoFormatHeightTimeProduct = (((long) i) * j2) + this.videoFormatHeightTimeProduct;
                }
                int i2 = format.bitrate;
                if (i2 != -1) {
                    this.videoFormatBitrateTimeMs += j2;
                    this.videoFormatBitrateTimeProduct = (j2 * ((long) i2)) + this.videoFormatBitrateTimeProduct;
                }
            }
            this.lastVideoFormatStartTimeMs = j;
        }

        public final void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, Format format) {
            int i;
            if (Objects.equals(this.currentAudioFormat, format)) {
                return;
            }
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            if (format != null && this.initialAudioFormatBitrate == -1 && (i = format.bitrate) != -1) {
                this.initialAudioFormatBitrate = i;
            }
            this.currentAudioFormat = format;
        }

        public final void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, Format format) {
            int i;
            int i2;
            if (Objects.equals(this.currentVideoFormat, format)) {
                return;
            }
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            if (format != null) {
                if (this.initialVideoFormatHeight == -1 && (i2 = format.height) != -1) {
                    this.initialVideoFormatHeight = i2;
                }
                if (this.initialVideoFormatBitrate == -1 && (i = format.bitrate) != -1) {
                    this.initialVideoFormatBitrate = i;
                }
            }
            this.currentVideoFormat = format;
        }

        public final void updatePlaybackState(int i, AnalyticsListener.EventTime eventTime) {
            long j = eventTime.realtimeMs;
            UtilsKt.checkArgument(j >= this.currentPlaybackStateStartTimeMs);
            long j2 = j - this.currentPlaybackStateStartTimeMs;
            int i2 = this.currentPlaybackState;
            long[] jArr = this.playbackStateDurationsMs;
            jArr[i2] = jArr[i2] + j2;
            if (this.firstReportedTimeMs == -9223372036854775807L) {
                this.firstReportedTimeMs = j;
            }
            this.isJoinTimeInvalid |= ((i2 != 1 && i2 != 2 && i2 != 14) || i == 1 || i == 2 || i == 14 || i == 3 || i == 4 || i == 9 || i == 11) ? false : true;
            this.hasBeenReady |= i == 3 || i == 4 || i == 9;
            this.hasEnded = (i == 11) | this.hasEnded;
            if (i2 != 4 && i2 != 7 && (i == 4 || i == 7)) {
                this.pauseCount++;
            }
            if (i == 5) {
                this.seekCount++;
            }
            if (!isRebufferingState(i2) && isRebufferingState(i)) {
                this.rebufferCount++;
                this.lastRebufferStartTimeMs = j;
            }
            if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && i == 7) {
                this.pauseBufferCount++;
            }
            if (isRebufferingState(this.currentPlaybackState)) {
                long j3 = j - this.lastRebufferStartTimeMs;
                long j4 = this.maxRebufferTimeMs;
                if (j4 == -9223372036854775807L || j3 > j4) {
                    this.maxRebufferTimeMs = j3;
                }
            }
            this.currentPlaybackState = i;
            this.currentPlaybackStateStartTimeMs = j;
        }
    }

    public PlaybackStatsListener(MusicService musicService) {
        this.callback = musicService;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        this.playbackStatsTrackers = new HashMap();
        this.sessionStartEventTimes = new HashMap();
        this.finishedPlaybackStats = PlaybackStats.EMPTY;
        this.period = new Timeline.Period();
        this.videoSize = VideoSize.UNKNOWN;
        defaultPlaybackSessionManager.listener = this;
    }

    public final boolean hasEvent(CallbackWrapper callbackWrapper, String str, int i) {
        return callbackWrapper.contains(i) && this.sessionManager.belongsToSession(callbackWrapper.getEventTime(i), str);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onAdPlaybackStarted(String str) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) this.playbackStatsTrackers.get(str);
        playbackStatsTracker.getClass();
        playbackStatsTracker.isInterruptedByAd = true;
        playbackStatsTracker.isSeeking = false;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j) {
        this.bandwidthTimeMs = i;
        this.bandwidthBytes = j;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, FloatTweenSpec floatTweenSpec) {
        int i = floatTweenSpec.duration;
        Format format = (Format) floatTweenSpec.easing;
        if (i == 2 || i == 0) {
            this.videoFormat = format;
        } else if (i == 1) {
            this.audioFormat = format;
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onDrmSessionManagerError(Exception exc) {
        this.nonFatalException = exc;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onDroppedVideoFrames(int i) {
        this.droppedFrames = i;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00f6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21, types: [int] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.media3.exoplayer.analytics.PlaybackStatsListener$PlaybackStatsTracker, java.lang.Object] */
    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onEvents(Player player, CallbackWrapper callbackWrapper) {
        DefaultPlaybackSessionManager defaultPlaybackSessionManager;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager2;
        boolean z;
        ?? r13;
        HashMap map;
        int i;
        FlagSet flagSet = (FlagSet) callbackWrapper.mCallback;
        if (flagSet.flags.size() == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int size = flagSet.flags.size();
            defaultPlaybackSessionManager = this.sessionManager;
            if (i2 >= size) {
                break;
            }
            int i3 = flagSet.get(i2);
            AnalyticsListener.EventTime eventTime = callbackWrapper.getEventTime(i3);
            if (i3 == 0) {
                defaultPlaybackSessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i3 == 11) {
                defaultPlaybackSessionManager.updateSessionsWithDiscontinuity(this.discontinuityReason, eventTime);
            } else {
                defaultPlaybackSessionManager.updateSessions(eventTime);
            }
            i2++;
        }
        HashMap map2 = this.playbackStatsTrackers;
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            int i4 = 0;
            AnalyticsListener.EventTime eventTime2 = null;
            boolean zBelongsToSession = false;
            while (i4 < flagSet.flags.size()) {
                AnalyticsListener.EventTime eventTime3 = callbackWrapper.getEventTime(flagSet.get(i4));
                boolean zBelongsToSession2 = defaultPlaybackSessionManager.belongsToSession(eventTime3, str);
                if (eventTime2 == null || (zBelongsToSession2 && !zBelongsToSession)) {
                    map = map2;
                    i = i4;
                } else {
                    if (zBelongsToSession2 == zBelongsToSession) {
                        i = i4;
                        map = map2;
                        if (eventTime3.realtimeMs > eventTime2.realtimeMs) {
                        }
                    } else {
                        map = map2;
                        i = i4;
                    }
                    i4 = i + 1;
                    map2 = map;
                }
                eventTime2 = eventTime3;
                zBelongsToSession = zBelongsToSession2;
                i4 = i + 1;
                map2 = map;
            }
            HashMap map3 = map2;
            eventTime2.getClass();
            Timeline timeline = eventTime2.timeline;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = eventTime2.mediaPeriodId;
            if (zBelongsToSession || mediaSource$MediaPeriodId == null) {
                defaultPlaybackSessionManager2 = defaultPlaybackSessionManager;
            } else {
                int i5 = mediaSource$MediaPeriodId.adGroupIndex;
                Object obj = mediaSource$MediaPeriodId.periodUid;
                if (mediaSource$MediaPeriodId.isAd()) {
                    Timeline.Period period = this.period;
                    long adGroupTimeUs = timeline.getPeriodByUid(obj, period).getAdGroupTimeUs(i5);
                    if (adGroupTimeUs == Long.MIN_VALUE) {
                        adGroupTimeUs = period.durationUs;
                    }
                    eventTime2 = new AnalyticsListener.EventTime(eventTime2.realtimeMs, timeline, eventTime2.windowIndex, new MediaSource$MediaPeriodId(i5, mediaSource$MediaPeriodId.windowSequenceNumber, obj), Util.usToMs(adGroupTimeUs + period.positionInWindowUs), timeline, eventTime2.currentWindowIndex, eventTime2.currentMediaPeriodId, eventTime2.currentPlaybackPositionMs, eventTime2.totalBufferedDurationMs);
                    defaultPlaybackSessionManager2 = defaultPlaybackSessionManager;
                    zBelongsToSession = defaultPlaybackSessionManager2.belongsToSession(eventTime2, str);
                } else {
                    defaultPlaybackSessionManager2 = defaultPlaybackSessionManager;
                }
            }
            Pair pairCreate = Pair.create(eventTime2, Boolean.valueOf(zBelongsToSession));
            ?? r6 = (PlaybackStatsTracker) map3.get(str);
            boolean zHasEvent = hasEvent(callbackWrapper, str, 11);
            boolean zHasEvent2 = hasEvent(callbackWrapper, str, 1018);
            boolean zHasEvent3 = hasEvent(callbackWrapper, str, 1011);
            boolean zHasEvent4 = hasEvent(callbackWrapper, str, CIOKt.DEFAULT_HTTP_POOL_SIZE);
            boolean zHasEvent5 = hasEvent(callbackWrapper, str, 10);
            boolean z2 = hasEvent(callbackWrapper, str, 1003) || hasEvent(callbackWrapper, str, 1024);
            boolean zHasEvent6 = hasEvent(callbackWrapper, str, 1006);
            boolean zHasEvent7 = hasEvent(callbackWrapper, str, 1004);
            boolean zHasEvent8 = hasEvent(callbackWrapper, str, 25);
            AnalyticsListener.EventTime eventTime4 = (AnalyticsListener.EventTime) pairCreate.first;
            ((Boolean) pairCreate.second).booleanValue();
            long j = str.equals(this.discontinuityFromSession) ? this.discontinuityFromPositionMs : -9223372036854775807L;
            int i6 = zHasEvent2 ? this.droppedFrames : 0;
            PlaybackException playerError = zHasEvent5 ? player.getPlayerError() : null;
            Exception exc = z2 ? this.nonFatalException : null;
            long j2 = j;
            long j3 = zHasEvent6 ? this.bandwidthTimeMs : 0L;
            long j4 = zHasEvent6 ? this.bandwidthBytes : 0L;
            Format format = zHasEvent7 != 0 ? this.videoFormat : null;
            Format format2 = zHasEvent7 ? this.audioFormat : null;
            VideoSize videoSize = zHasEvent8 ? this.videoSize : null;
            r6.getClass();
            if (j2 != -9223372036854775807L) {
                long j5 = eventTime4.realtimeMs;
                r6.isSeeking = true;
            }
            if (player.getPlaybackState() != 2) {
                r6.isSeeking = false;
            }
            int playbackState = player.getPlaybackState();
            Iterator it2 = it;
            if (playbackState == 1 || playbackState == 4 || zHasEvent) {
                z = false;
                r6.isInterruptedByAd = false;
            } else {
                z = false;
            }
            if (playerError != null) {
                r6.hasFatalError = true;
                r6.fatalErrorCount++;
            } else if (player.getPlayerError() == null) {
                r6.hasFatalError = z;
            }
            if (r6.isForeground && !r6.isInterruptedByAd) {
                Tracks currentTracks = player.getCurrentTracks();
                if (!currentTracks.isTypeSelected(2)) {
                    r6.maybeUpdateVideoFormat(eventTime4, null);
                }
                if (!currentTracks.isTypeSelected(1)) {
                    r6.maybeUpdateAudioFormat(eventTime4, null);
                }
            }
            if (format != null) {
                r6.maybeUpdateVideoFormat(eventTime4, format);
            }
            if (format2 != null) {
                r6.maybeUpdateAudioFormat(eventTime4, format2);
            }
            Format format3 = r6.currentVideoFormat;
            if (format3 != null && format3.height == -1 && videoSize != null) {
                Format.Builder builderBuildUpon = format3.buildUpon();
                builderBuildUpon.width = videoSize.width;
                builderBuildUpon.height = videoSize.height;
                r6.maybeUpdateVideoFormat(eventTime4, new Format(builderBuildUpon));
            }
            if (zHasEvent4) {
                r6.startedLoading = true;
            }
            if (zHasEvent3) {
                r6.audioUnderruns++;
            }
            r6.droppedFrames += (long) i6;
            r6.bandwidthTimeMs += j3;
            r6.bandwidthBytes += j4;
            if (exc != null) {
                r6.nonFatalErrorCount++;
            }
            int playbackState2 = player.getPlaybackState();
            if (r6.isSeeking && r6.isForeground) {
                r13 = 5;
            } else if (r6.hasFatalError) {
                r13 = 13;
            } else if (!r6.isForeground) {
                r13 = r6.startedLoading;
            } else if (r6.isInterruptedByAd) {
                r13 = 14;
            } else if (playbackState2 == 4) {
                r13 = 11;
            } else if (playbackState2 == 2) {
                int i7 = r6.currentPlaybackState;
                if (i7 == 0 || i7 == 1 || i7 == 2 || i7 == 14) {
                    r13 = 2;
                } else if (player.getPlayWhenReady()) {
                    r13 = player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
                } else {
                    r13 = 7;
                }
            } else {
                r13 = 3;
                if (playbackState2 != 3) {
                    r13 = (playbackState2 != 1 || r6.currentPlaybackState == 0) ? r6.currentPlaybackState : 12;
                } else if (!player.getPlayWhenReady()) {
                    r13 = 4;
                } else if (player.getPlaybackSuppressionReason() != 0) {
                    r13 = 9;
                }
            }
            float f = player.getPlaybackParameters().speed;
            if (r6.currentPlaybackState != r13 || r6.currentPlaybackSpeed != f) {
                long j6 = eventTime4.realtimeMs;
                r6.maybeRecordVideoFormatTime(j6);
                r6.maybeRecordAudioFormatTime(j6);
            }
            r6.currentPlaybackSpeed = f;
            if (r6.currentPlaybackState != r13) {
                r6.updatePlaybackState(r13, eventTime4);
            }
            defaultPlaybackSessionManager = defaultPlaybackSessionManager2;
            map2 = map3;
            it = it2;
            flagSet = flagSet;
        }
        DefaultPlaybackSessionManager defaultPlaybackSessionManager3 = defaultPlaybackSessionManager;
        this.videoFormat = null;
        this.audioFormat = null;
        this.discontinuityFromSession = null;
        if (callbackWrapper.contains(1028)) {
            defaultPlaybackSessionManager3.finishAllSessions(callbackWrapper.getEventTime(1028));
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onLoadError(FloatTweenSpec floatTweenSpec, IOException iOException) {
        this.nonFatalException = iOException;
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, int i) {
        String str;
        if (this.discontinuityFromSession == null) {
            DefaultPlaybackSessionManager defaultPlaybackSessionManager = this.sessionManager;
            synchronized (defaultPlaybackSessionManager) {
                str = defaultPlaybackSessionManager.currentSessionId;
            }
            this.discontinuityFromSession = str;
            this.discontinuityFromPositionMs = positionInfo.positionMs;
        }
        this.discontinuityReason = i;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) this.playbackStatsTrackers.get(str);
        playbackStatsTracker.getClass();
        playbackStatsTracker.isForeground = true;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        this.playbackStatsTrackers.put(str, new PlaybackStatsTracker(eventTime));
        this.sessionStartEventTimes.put(str, eventTime);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener
    public final void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) this.playbackStatsTrackers.remove(str);
        playbackStatsTracker.getClass();
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) this.sessionStartEventTimes.remove(str);
        eventTime2.getClass();
        str.equals(this.discontinuityFromSession);
        int i = 11;
        if (playbackStatsTracker.currentPlaybackState != 11 && !z) {
            i = 15;
        }
        long j = eventTime.realtimeMs;
        playbackStatsTracker.maybeRecordVideoFormatTime(j);
        playbackStatsTracker.maybeRecordAudioFormatTime(j);
        playbackStatsTracker.updatePlaybackState(i, eventTime);
        List list = playbackStatsTracker.playbackStateHistory;
        List list2 = playbackStatsTracker.audioFormatHistory;
        List list3 = playbackStatsTracker.videoFormatHistory;
        long[] jArr = playbackStatsTracker.playbackStateDurationsMs;
        List list4 = playbackStatsTracker.mediaTimeHistory;
        int i2 = (playbackStatsTracker.isJoinTimeInvalid || !playbackStatsTracker.hasBeenReady) ? 1 : 0;
        long j2 = i2 != 0 ? -9223372036854775807L : jArr[2];
        int i3 = jArr[1] > 0 ? 1 : 0;
        long j3 = playbackStatsTracker.firstReportedTimeMs;
        boolean z2 = playbackStatsTracker.isForeground;
        int i4 = !playbackStatsTracker.hasBeenReady ? 1 : 0;
        boolean z3 = playbackStatsTracker.hasEnded;
        int i5 = i2 ^ 1;
        int i6 = playbackStatsTracker.pauseCount;
        int i7 = playbackStatsTracker.pauseBufferCount;
        int i8 = playbackStatsTracker.seekCount;
        int i9 = playbackStatsTracker.rebufferCount;
        long j4 = playbackStatsTracker.maxRebufferTimeMs;
        boolean z4 = playbackStatsTracker.isAd;
        long j5 = playbackStatsTracker.videoFormatHeightTimeMs;
        long j6 = playbackStatsTracker.videoFormatHeightTimeProduct;
        long j7 = playbackStatsTracker.videoFormatBitrateTimeMs;
        long j8 = playbackStatsTracker.videoFormatBitrateTimeProduct;
        long j9 = playbackStatsTracker.audioFormatTimeMs;
        long j10 = playbackStatsTracker.audioFormatBitrateTimeProduct;
        int i10 = playbackStatsTracker.initialVideoFormatHeight;
        int i11 = i10 == -1 ? 0 : 1;
        long j11 = playbackStatsTracker.initialVideoFormatBitrate;
        int i12 = j11 == -1 ? 0 : 1;
        long j12 = playbackStatsTracker.initialAudioFormatBitrate;
        int i13 = j12 == -1 ? 0 : 1;
        long j13 = playbackStatsTracker.bandwidthTimeMs;
        long j14 = playbackStatsTracker.bandwidthBytes;
        long j15 = playbackStatsTracker.droppedFrames;
        long j16 = playbackStatsTracker.audioUnderruns;
        int i14 = playbackStatsTracker.fatalErrorCount;
        PlaybackStats playbackStats = new PlaybackStats(1, jArr, list, list4, j3, z2 ? 1 : 0, i4, z3 ? 1 : 0, i3, j2, i5, i6, i7, i8, i9, j4, z4 ? 1 : 0, list3, list2, j5, j6, j7, j8, j9, j10, i11, i12, i10, j11, i13, j12, j13, j14, j15, j16, i14 > 0 ? 1 : 0, i14, playbackStatsTracker.nonFatalErrorCount, playbackStatsTracker.fatalErrorHistory, playbackStatsTracker.nonFatalErrorHistory);
        this.finishedPlaybackStats = PlaybackStats.merge(this.finishedPlaybackStats, playbackStats);
        MediaItem mediaItem = eventTime2.timeline.getWindow(eventTime2.windowIndex, new Timeline.Window(), 0L).mediaItem;
        mediaItem.getClass();
        MusicService musicService = this.callback;
        Float f = (Float) com.metrolist.music.utils.UtilsKt.get(com.metrolist.music.utils.UtilsKt.getDataStore(musicService), PreferenceKeysKt.HistoryDuration);
        float fFloatValue = f != null ? f.floatValue() * 1000.0f : 30000.0f;
        if (jArr[3] >= fFloatValue && !((Boolean) com.metrolist.music.utils.UtilsKt.get(com.metrolist.music.utils.UtilsKt.getDataStore(musicService), PreferenceKeysKt.PauseListenHistoryKey, Boolean.FALSE)).booleanValue()) {
            musicService.getDatabase().query(new QuickJs$$ExternalSyntheticLambda1(mediaItem, playbackStats, (byte) 23));
        }
        if (jArr[3] >= fFloatValue) {
            ContextScope contextScope = musicService.scope;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            AwaitKt.launch$default(contextScope, DefaultIoScheduler.INSTANCE, null, new App.C01391(musicService, mediaItem, null, (byte) 22), 2);
        }
    }

    @Override // androidx.media3.exoplayer.analytics.AnalyticsListener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        this.videoSize = videoSize;
    }
}
