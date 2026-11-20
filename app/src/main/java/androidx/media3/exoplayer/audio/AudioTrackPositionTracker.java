package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import android.os.Build;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda68;
import java.lang.reflect.Method;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioTrackPositionTracker {
    public final AudioTimestampPoller audioTimestampPoller;
    public final AudioTrack audioTrack;
    public float audioTrackPlaybackSpeed;
    public final long bufferSizeUs;
    public final SystemClock clock;
    public long endPlaybackHeadPosition;
    public boolean expectRawPlaybackHeadReset;
    public long forceResetWorkaroundTimeMs;
    public Method getLatencyMethod;
    public final boolean isOutputPcm;
    public long lastLatencySampleTimeUs;
    public long lastPlayheadSampleTimeUs;
    public long lastPositionUs;
    public long lastRawPlaybackHeadPositionSampleTimeMs;
    public long lastSystemTimeUs;
    public long latencyUs;
    public final AtomicInt listener;
    public int nextPlayheadOffsetIndex;
    public long onPositionAdvancingFromPositionUs;
    public final int outputSampleRate;
    public int playheadOffsetCount;
    public final long[] playheadOffsets;
    public long rawPlaybackHeadPosition;
    public long rawPlaybackHeadWrapCount;
    public long smoothedPlayheadOffsetUs;
    public long stopPlaybackHeadPosition;
    public long stopTimestampUs;
    public long sumRawPlaybackHeadPosition;

    public AudioTrackPositionTracker(AtomicInt atomicInt, SystemClock systemClock, AudioTrack audioTrack, int i, int i2, int i3) {
        this.listener = atomicInt;
        this.clock = systemClock;
        this.audioTrack = audioTrack;
        try {
            this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.playheadOffsets = new long[10];
        this.lastSystemTimeUs = -9223372036854775807L;
        this.lastPositionUs = -9223372036854775807L;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack, atomicInt);
        int sampleRate = audioTrack.getSampleRate();
        this.outputSampleRate = sampleRate;
        boolean zIsEncodingLinearPcm = Util.isEncodingLinearPcm(i);
        this.isOutputPcm = zIsEncodingLinearPcm;
        this.bufferSizeUs = zIsEncodingLinearPcm ? Util.sampleCountToDurationUs(sampleRate, i3 / i2) : -9223372036854775807L;
        this.rawPlaybackHeadPosition = 0L;
        this.rawPlaybackHeadWrapCount = 0L;
        this.expectRawPlaybackHeadReset = false;
        this.sumRawPlaybackHeadPosition = 0L;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastLatencySampleTimeUs = 0L;
        this.latencyUs = 0L;
        this.audioTrackPlaybackSpeed = 1.0f;
        this.onPositionAdvancingFromPositionUs = -9223372036854775807L;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    public final long getPlaybackHeadPosition() {
        long j;
        if (this.stopTimestampUs != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, getSimulatedPlaybackHeadPositionAfterStop());
        }
        this.clock.getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.lastRawPlaybackHeadPositionSampleTimeMs >= 5) {
            AudioTrack audioTrack = this.audioTrack;
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                if (Build.VERSION.SDK_INT > 29) {
                    j = this.rawPlaybackHeadPosition;
                    if (j > playbackHeadPosition) {
                        if (this.expectRawPlaybackHeadReset) {
                            this.sumRawPlaybackHeadPosition += j;
                            this.expectRawPlaybackHeadReset = false;
                        } else {
                            this.rawPlaybackHeadWrapCount++;
                        }
                    }
                    this.rawPlaybackHeadPosition = playbackHeadPosition;
                } else if (playbackHeadPosition != 0 || this.rawPlaybackHeadPosition <= 0 || playState != 3) {
                    this.forceResetWorkaroundTimeMs = -9223372036854775807L;
                    j = this.rawPlaybackHeadPosition;
                    if (j > playbackHeadPosition) {
                        if (this.expectRawPlaybackHeadReset) {
                            this.sumRawPlaybackHeadPosition += j;
                            this.expectRawPlaybackHeadReset = false;
                        } else {
                            this.rawPlaybackHeadWrapCount++;
                        }
                    }
                    this.rawPlaybackHeadPosition = playbackHeadPosition;
                } else if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = jElapsedRealtime;
                }
            }
            this.lastRawPlaybackHeadPositionSampleTimeMs = jElapsedRealtime;
        }
        return this.rawPlaybackHeadPosition + this.sumRawPlaybackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }

    public final long getPlaybackHeadPositionEstimateUs(long j) {
        long mediaDurationForPlayoutDuration;
        int i = this.playheadOffsetCount;
        int i2 = this.outputSampleRate;
        if (i == 0) {
            mediaDurationForPlayoutDuration = this.stopTimestampUs != -9223372036854775807L ? Util.sampleCountToDurationUs(i2, getSimulatedPlaybackHeadPositionAfterStop()) : Util.sampleCountToDurationUs(i2, getPlaybackHeadPosition());
        } else {
            mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(j + this.smoothedPlayheadOffsetUs, this.audioTrackPlaybackSpeed);
        }
        long jMax = Math.max(0L, mediaDurationForPlayoutDuration - this.latencyUs);
        return this.stopTimestampUs != -9223372036854775807L ? Math.min(Util.sampleCountToDurationUs(i2, this.endPlaybackHeadPosition), jMax) : jMax;
    }

    public final long getSimulatedPlaybackHeadPositionAfterStop() {
        if (this.audioTrack.getPlayState() == 2) {
            return this.stopPlaybackHeadPosition;
        }
        this.clock.getClass();
        return this.stopPlaybackHeadPosition + Util.scaleLargeValue(Util.getMediaDurationForPlayoutDuration(Util.msToUs(android.os.SystemClock.elapsedRealtime()) - this.stopTimestampUs, this.audioTrackPlaybackSpeed), this.outputSampleRate, 1000000L, RoundingMode.UP);
    }

    public final void maybeTriggerOnPositionAdvancingCallback(long j) {
        long j2 = this.onPositionAdvancingFromPositionUs;
        if (j2 == -9223372036854775807L || j < j2) {
            return;
        }
        long jRound = j - j2;
        float f = this.audioTrackPlaybackSpeed;
        String str = Util.DEVICE_DEBUG_INFO;
        if (f != 1.0f) {
            jRound = Math.round(jRound / ((double) f));
        }
        this.clock.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - Util.usToMs(jRound);
        this.onPositionAdvancingFromPositionUs = -9223372036854775807L;
        ListenerSet listenerSet = ((AudioTrackAudioOutput) this.listener.delegate).listeners;
        listenerSet.getClass();
        if (Thread.currentThread() == listenerSet.thread) {
            listenerSet.sendEvent(-1, new MediaSessionStub$$ExternalSyntheticLambda68(jCurrentTimeMillis));
        }
    }
}
