package androidx.media3.exoplayer.analytics;

import androidx.compose.animation.core.FloatTweenSpec;
import androidx.core.provider.CallbackWrapper;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface AnalyticsListener {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class EventTime {
        public final MediaSource$MediaPeriodId currentMediaPeriodId;
        public final long currentPlaybackPositionMs;
        public final Timeline currentTimeline;
        public final int currentWindowIndex;
        public final long eventPlaybackPositionMs;
        public final MediaSource$MediaPeriodId mediaPeriodId;
        public final long realtimeMs;
        public final Timeline timeline;
        public final long totalBufferedDurationMs;
        public final int windowIndex;

        public EventTime(long j, Timeline timeline, int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j2, Timeline timeline2, int i2, MediaSource$MediaPeriodId mediaSource$MediaPeriodId2, long j3, long j4) {
            this.realtimeMs = j;
            this.timeline = timeline;
            this.windowIndex = i;
            this.mediaPeriodId = mediaSource$MediaPeriodId;
            this.eventPlaybackPositionMs = j2;
            this.currentTimeline = timeline2;
            this.currentWindowIndex = i2;
            this.currentMediaPeriodId = mediaSource$MediaPeriodId2;
            this.currentPlaybackPositionMs = j3;
            this.totalBufferedDurationMs = j4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTime.class != obj.getClass()) {
                return false;
            }
            EventTime eventTime = (EventTime) obj;
            return this.realtimeMs == eventTime.realtimeMs && this.windowIndex == eventTime.windowIndex && this.eventPlaybackPositionMs == eventTime.eventPlaybackPositionMs && this.currentWindowIndex == eventTime.currentWindowIndex && this.currentPlaybackPositionMs == eventTime.currentPlaybackPositionMs && this.totalBufferedDurationMs == eventTime.totalBufferedDurationMs && this.timeline.equals(eventTime.timeline) && Objects.equals(this.mediaPeriodId, eventTime.mediaPeriodId) && Objects.equals(this.currentTimeline, eventTime.currentTimeline) && Objects.equals(this.currentMediaPeriodId, eventTime.currentMediaPeriodId);
        }

        public final int hashCode() {
            return Objects.hash(Long.valueOf(this.realtimeMs), this.timeline, Integer.valueOf(this.windowIndex), this.mediaPeriodId, Long.valueOf(this.eventPlaybackPositionMs), this.currentTimeline, Integer.valueOf(this.currentWindowIndex), this.currentMediaPeriodId, Long.valueOf(this.currentPlaybackPositionMs), Long.valueOf(this.totalBufferedDurationMs));
        }
    }

    void onBandwidthEstimate(EventTime eventTime, int i, long j);

    void onDownstreamFormatChanged(EventTime eventTime, FloatTweenSpec floatTweenSpec);

    void onEvents(Player player, CallbackWrapper callbackWrapper);

    void onLoadError(FloatTweenSpec floatTweenSpec, IOException iOException);

    void onPositionDiscontinuity(Player.PositionInfo positionInfo, int i);

    void onVideoSizeChanged(VideoSize videoSize);

    default void onDrmSessionManagerError(Exception exc) {
    }

    default void onDroppedVideoFrames(int i) {
    }

    default void onPlayerError(PlaybackException playbackException) {
    }

    default void onVideoDisabled(DecoderCounters decoderCounters) {
    }
}
