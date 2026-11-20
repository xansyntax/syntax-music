package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.datastore.core.AtomicInt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioTimestampPoller {
    public final AudioTimestampWrapper audioTimestamp;
    public final AtomicInt errorListener;
    public long initialTimestampPositionFrames;
    public long initialTimestampSystemTimeUs;
    public long initializeSystemTimeUs;
    public long lastTimestampSampleTimeUs;
    public int sampleIntervalUs;
    public final int sampleRate;
    public byte state;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AudioTimestampWrapper {
        public long accumulatedRawTimestampFramePosition;
        public final AudioTimestamp audioTimestamp = new AudioTimestamp();
        public final AudioTrack audioTrack;
        public boolean expectTimestampFramePositionReset;
        public long lastTimestampPositionFrames;
        public long lastTimestampRawPositionFrames;
        public long rawTimestampFramePositionWrapCount;

        public AudioTimestampWrapper(AudioTrack audioTrack) {
            this.audioTrack = audioTrack;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack, AtomicInt atomicInt) {
        this.audioTimestamp = new AudioTimestampWrapper(audioTrack);
        this.sampleRate = audioTrack.getSampleRate();
        this.errorListener = atomicInt;
        updateState(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateState(int i) {
        this.state = i;
        if (i == 0) {
            this.lastTimestampSampleTimeUs = 0L;
            this.initialTimestampPositionFrames = -1L;
            this.initialTimestampSystemTimeUs = -9223372036854775807L;
            this.initializeSystemTimeUs = System.nanoTime() / 1000;
            this.sampleIntervalUs = 10000;
            return;
        }
        if (i == 1) {
            this.sampleIntervalUs = 10000;
            return;
        }
        if (i == 2 || i == 3) {
            this.sampleIntervalUs = 10000000;
        } else if (i == 4) {
            this.sampleIntervalUs = 500000;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m();
        }
    }
}
