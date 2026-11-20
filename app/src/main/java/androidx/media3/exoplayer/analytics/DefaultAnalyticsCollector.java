package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import android.util.SparseArray;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.compose.foundation.text.TextLinkScope$$ExternalSyntheticLambda10;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.SystemHandlerWrapper;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import androidx.media3.exoplayer.ExoPlayerImpl$$ExternalSyntheticLambda6;
import androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.session.MediaControllerImplBase$$ExternalSyntheticLambda41;
import coil3.util.UtilsKt;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableMap;
import com.materialkolor.quantize.QuantizerWu;
import io.ktor.client.utils.CIOKt;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultAnalyticsCollector implements Player.Listener, MediaSourceEventListener, DrmSessionEventListener {
    public final SystemClock clock;
    public final SparseArray eventTimes;
    public SystemHandlerWrapper handler;
    public boolean isSeeking;
    public ListenerSet listeners;
    public final QuantizerWu mediaPeriodQueueTracker;
    public final Timeline.Period period;
    public Player player;
    public final Timeline.Window window;

    public DefaultAnalyticsCollector(SystemClock systemClock) {
        systemClock.getClass();
        this.clock = systemClock;
        this.listeners = new ListenerSet(Util.getCurrentOrMainLooper().getThread());
        Timeline.Period period = new Timeline.Period();
        this.period = period;
        this.window = new Timeline.Window();
        QuantizerWu quantizerWu = new QuantizerWu();
        quantizerWu.weights = period;
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        quantizerWu.momentsR = RegularImmutableList.EMPTY;
        quantizerWu.momentsG = RegularImmutableMap.EMPTY;
        this.mediaPeriodQueueTracker = quantizerWu;
        this.eventTimes = new SparseArray();
    }

    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime((MediaSource$MediaPeriodId) this.mediaPeriodQueueTracker.momentsB);
    }

    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = timeline.isEmpty() ? null : mediaSource$MediaPeriodId;
        this.clock.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean z = timeline.equals(this.player.getCurrentTimeline()) && i == this.player.getCurrentMediaItemIndex();
        long jUsToMs = 0;
        if (mediaSource$MediaPeriodId2 == null || !mediaSource$MediaPeriodId2.isAd()) {
            if (z) {
                jUsToMs = this.player.getContentPosition();
            } else if (!timeline.isEmpty()) {
                jUsToMs = Util.usToMs(timeline.getWindow(i, this.window, 0L).defaultPositionUs);
            }
        } else if (z && this.player.getCurrentAdGroupIndex() == mediaSource$MediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaSource$MediaPeriodId2.adIndexInAdGroup) {
            jUsToMs = this.player.getCurrentPosition();
        }
        return new AnalyticsListener.EventTime(jElapsedRealtime, timeline, i, mediaSource$MediaPeriodId2, jUsToMs, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), (MediaSource$MediaPeriodId) this.mediaPeriodQueueTracker.momentsB, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    public final AnalyticsListener.EventTime generateMediaPeriodEventTime(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.player.getClass();
        if (mediaSource$MediaPeriodId != null) {
            return ((Timeline) ((RegularImmutableMap) this.mediaPeriodQueueTracker.momentsG).get(mediaSource$MediaPeriodId)) != null ? generateEventTime(mediaSource$MediaPeriodId) : generateEventTime(Timeline.EMPTY, i, mediaSource$MediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, null);
    }

    public final AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime((MediaSource$MediaPeriodId) this.mediaPeriodQueueTracker.cubes);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        sendEvent(generateReadingMediaPeriodEventTime(), 20, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 8));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onAudioSessionIdChanged(int i) {
        sendEvent(generateReadingMediaPeriodEventTime(), 21, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 24));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onAvailableCommandsChanged(Player.Commands commands) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 13, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 1));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onCues(List list) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 27, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 19));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 29, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 23));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onDeviceVolumeChanged(int i, boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 30, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 16));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, FloatTweenSpec floatTweenSpec) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1004, new TextLinkScope$$ExternalSyntheticLambda10((Object) eventTimeGenerateMediaPeriodEventTime, (Object) floatTweenSpec, (byte) 3));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void onDrmKeysLoaded(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, CueDecoder cueDecoder) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), 1023, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 21));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void onDrmKeysRestored(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), 1025, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 22));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void onDrmSessionAcquired(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, int i2) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1022, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4(i2, eventTimeGenerateMediaPeriodEventTime));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void onDrmSessionManagerError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1024, new OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0(eventTimeGenerateMediaPeriodEventTime, (Object) exc, (byte) 14));
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void onDrmSessionReleased(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), 1027, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 20));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onIsLoadingChanged(boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 3, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 26));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onIsPlayingChanged(boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 7, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 11));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void onLoadCanceled(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), 1002, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 8));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void onLoadCompleted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), 1001, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 10));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void onLoadError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, IOException iOException, boolean z) {
        AnalyticsListener.EventTime eventTimeGenerateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId);
        sendEvent(eventTimeGenerateMediaPeriodEventTime, 1003, new TextLinkScope$$ExternalSyntheticLambda10(eventTimeGenerateMediaPeriodEventTime, loadEventInfo, floatTweenSpec, iOException, z));
    }

    @Override // androidx.media3.exoplayer.source.MediaSourceEventListener
    public final void onLoadStarted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, int i2) {
        sendEvent(generateMediaPeriodEventTime(i, mediaSource$MediaPeriodId), CIOKt.DEFAULT_HTTP_POOL_SIZE, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 4));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMaxSeekToPreviousPositionChanged(long j) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 18, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 15));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMediaItemTransition(int i, MediaItem mediaItem) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 3));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 14, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 28));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMetadata(Metadata metadata) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 28, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 9));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayWhenReadyChanged(int i, boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 5, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 17));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 12, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 4, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 22));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackSuppressionReasonChanged(int i) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 6, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 13));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerError(PlaybackException playbackException) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = (!(playbackException instanceof ExoPlaybackException) || (mediaSource$MediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? generateCurrentPlayerMediaPeriodEventTime() : generateEventTime(mediaSource$MediaPeriodId);
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 10, new MediaControllerImplBase$$ExternalSyntheticLambda41(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, playbackException));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerErrorChanged(PlaybackException playbackException) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        sendEvent((!(playbackException instanceof ExoPlaybackException) || (mediaSource$MediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? generateCurrentPlayerMediaPeriodEventTime() : generateEventTime(mediaSource$MediaPeriodId), 10, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 15));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlayerStateChanged(int i, boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), -1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 7));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 15, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 25));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        if (i == 1) {
            this.isSeeking = false;
        }
        Player player = this.player;
        player.getClass();
        QuantizerWu quantizerWu = this.mediaPeriodQueueTracker;
        quantizerWu.momentsB = QuantizerWu.findCurrentPlayerMediaPeriodInQueue(player, (ImmutableList) quantizerWu.momentsR, (MediaSource$MediaPeriodId) quantizerWu.moments, (Timeline.Period) quantizerWu.weights);
        AnalyticsListener.EventTime eventTimeGenerateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, 11, new ExoPlayerImpl$$ExternalSyntheticLambda6(eventTimeGenerateCurrentPlayerMediaPeriodEventTime, i, positionInfo, positionInfo2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onRepeatModeChanged(int i) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 8, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 27));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onSeekBackIncrementChanged(long j) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 16, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 0));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onSeekForwardIncrementChanged(long j) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 17, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 25));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onShuffleModeEnabledChanged(boolean z) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 9, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onSkipSilenceEnabledChanged(boolean z) {
        sendEvent(generateReadingMediaPeriodEventTime(), 23, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 4));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onSurfaceSizeChanged(int i, int i2) {
        sendEvent(generateReadingMediaPeriodEventTime(), 24, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 3));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onTimelineChanged(Timeline timeline, int i) {
        Player player = this.player;
        player.getClass();
        QuantizerWu quantizerWu = this.mediaPeriodQueueTracker;
        quantizerWu.momentsB = QuantizerWu.findCurrentPlayerMediaPeriodInQueue(player, (ImmutableList) quantizerWu.momentsR, (MediaSource$MediaPeriodId) quantizerWu.moments, (Timeline.Period) quantizerWu.weights);
        quantizerWu.updateMediaPeriodTimelines(player.getCurrentTimeline());
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 0, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 2));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 19, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4((byte) 24));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onTracksChanged(Tracks tracks) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 2, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 10));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime eventTimeGenerateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(eventTimeGenerateReadingMediaPeriodEventTime, 25, new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(eventTimeGenerateReadingMediaPeriodEventTime, videoSize));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onVolumeChanged(float f) {
        sendEvent(generateReadingMediaPeriodEventTime(), 22, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 5));
    }

    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i, ListenerSet.Event event) {
        this.eventTimes.put(i, eventTime);
        this.listeners.sendEvent(i, event);
    }

    public final void setPlayer(ExoPlayerImpl exoPlayerImpl, Looper looper) {
        UtilsKt.checkState(this.player == null || ((ImmutableList) this.mediaPeriodQueueTracker.momentsR).isEmpty());
        exoPlayerImpl.getClass();
        this.player = exoPlayerImpl;
        this.handler = this.clock.createHandler(looper, null);
        ListenerSet listenerSet = this.listeners;
        TextLinkScope$$ExternalSyntheticLambda10 textLinkScope$$ExternalSyntheticLambda10 = new TextLinkScope$$ExternalSyntheticLambda10((Object) this, (Object) exoPlayerImpl, (byte) 2);
        SystemClock systemClock = this.clock;
        UtilsKt.checkState(systemClock != null);
        this.listeners = new ListenerSet(listenerSet.listeners, looper, looper.getThread(), systemClock, textLinkScope$$ExternalSyntheticLambda10, listenerSet.throwsWhenUsingWrongThread);
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onCues(CueGroup cueGroup) {
        sendEvent(generateCurrentPlayerMediaPeriodEventTime(), 27, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0((byte) 21));
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onRenderedFirstFrame() {
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onLoadingChanged(boolean z) {
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onEvents(Player player, Player.Events events) {
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPositionDiscontinuity(int i) {
    }

    public final AnalyticsListener.EventTime generateEventTime(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.player.getClass();
        Timeline timeline = mediaSource$MediaPeriodId == null ? null : (Timeline) ((RegularImmutableMap) this.mediaPeriodQueueTracker.momentsG).get(mediaSource$MediaPeriodId);
        if (mediaSource$MediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaSource$MediaPeriodId.periodUid, this.period).windowIndex, mediaSource$MediaPeriodId);
        }
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (currentMediaItemIndex >= currentTimeline.getWindowCount()) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentMediaItemIndex, null);
    }
}
