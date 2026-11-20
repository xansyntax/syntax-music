package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import androidx.datastore.core.AtomicInt;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm$$ExternalSyntheticLambda0;
import androidx.media3.session.DefaultMediaNotificationProvider$$ExternalSyntheticLambda1;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioTrackAudioOutput {
    public static int pendingReleaseCount;
    public static ScheduledExecutorService releaseExecutor;
    public static final Object releaseExecutorLock = new Object();
    public final AudioTrack audioTrack;
    public final AudioTrackPositionTracker audioTrackPositionTracker;
    public final AtomicInt capabilityChangeListener;
    public final AudioOutputProvider.OutputConfig config;
    public int framesPerEncodedSample;
    public boolean hasBeenStopped;
    public final boolean isOutputPcm;
    public long lastTunnelingAvSyncPresentationTimeUs;
    public int lastUnderrunCount;
    public final ListenerSet listeners = new ListenerSet(Thread.currentThread());
    public final StreamEventCallbackV29 offloadStreamEventCallbackV29;
    public Dispatcher onRoutingChangedListener;
    public final int pcmFrameSize;
    public long writtenEncodedFrames;
    public long writtenPcmBytes;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class StreamEventCallbackV29 {
        public final AnonymousClass1 callback;
        public final Handler handler;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.media.AudioTrack$StreamEventCallback, androidx.media3.exoplayer.audio.AudioTrackAudioOutput$StreamEventCallbackV29$1] */
        public StreamEventCallbackV29() {
            Handler handlerCreateHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(null);
            this.handler = handlerCreateHandlerForCurrentLooper;
            ?? r1 = new AudioTrack$StreamEventCallback() { // from class: androidx.media3.exoplayer.audio.AudioTrackAudioOutput.StreamEventCallbackV29.1
                public final void onDataRequest(AudioTrack audioTrack, int i) {
                    AudioTrackAudioOutput.this.listeners.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 4));
                }

                public final void onPresentationEnded(AudioTrack audioTrack) {
                    AudioTrackAudioOutput.this.listeners.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 5));
                }

                public final void onTearDown(AudioTrack audioTrack) {
                    AudioTrackAudioOutput.this.listeners.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 4));
                }
            };
            this.callback = r1;
            AudioTrackAudioOutput.this.audioTrack.registerStreamEventCallback(new DefaultMediaNotificationProvider$$ExternalSyntheticLambda1(handlerCreateHandlerForCurrentLooper, (byte) 1), r1);
        }

        public final void unregister() {
            AudioTrackAudioOutput.this.audioTrack.unregisterStreamEventCallback(this.callback);
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    public AudioTrackAudioOutput(AudioTrack audioTrack, AudioOutputProvider.OutputConfig outputConfig, AtomicInt atomicInt, SystemClock systemClock) {
        int byteDepth;
        this.audioTrack = audioTrack;
        this.config = outputConfig;
        this.capabilityChangeListener = atomicInt;
        int i = outputConfig.encoding;
        boolean zIsEncodingLinearPcm = Util.isEncodingLinearPcm(i);
        this.isOutputPcm = zIsEncodingLinearPcm;
        if (zIsEncodingLinearPcm) {
            byteDepth = Util.getByteDepth(i) * Integer.bitCount(outputConfig.channelMask);
            this.pcmFrameSize = byteDepth;
        } else {
            byteDepth = -1;
            this.pcmFrameSize = -1;
        }
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new AtomicInt(this), systemClock, audioTrack, outputConfig.encoding, byteDepth, outputConfig.bufferSize);
        if (atomicInt != null) {
            this.onRoutingChangedListener = new Dispatcher(audioTrack, atomicInt);
        }
        this.offloadStreamEventCallbackV29 = isOffloadedPlayback() ? new StreamEventCallbackV29() : null;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:112:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:114:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:116:0x031a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0328  */
    /* JADX WARN: Code duplicated, block: B:125:0x0332  */
    /* JADX WARN: Code duplicated, block: B:128:0x0340  */
    /* JADX WARN: Code duplicated, block: B:134:0x0375  */
    /* JADX WARN: Code duplicated, block: B:136:0x0378  */
    /* JADX WARN: Code duplicated, block: B:47:0x0100 A[PHI: r17
      0x0100: PHI (r17v5 long) = (r17v6 long), (r17v7 long) binds: [B:46:0x00fe, B:7:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x029a  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:97:0x02a9  */
    public final long getPositionUs() {
        AudioTrack audioTrack;
        long j;
        boolean z;
        long jNanoTime;
        boolean z2;
        AudioTrackPositionTracker audioTrackPositionTracker;
        long playbackHeadPositionEstimateUs;
        long jConstrainValue;
        int playState;
        long j2;
        long j3;
        long mediaDurationForPlayoutDuration;
        long j4;
        byte b;
        long j5;
        float f;
        boolean z3;
        AudioTimestamp audioTimestamp;
        AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper;
        byte b2;
        Method method;
        Method method2;
        AudioTrackPositionTracker audioTrackPositionTracker2 = this.audioTrackPositionTracker;
        SystemClock systemClock = audioTrackPositionTracker2.clock;
        AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker2.audioTimestampPoller;
        AudioTrack audioTrack2 = audioTrackPositionTracker2.audioTrack;
        if (audioTrack2.getPlayState() == 3) {
            long[] jArr = audioTrackPositionTracker2.playheadOffsets;
            systemClock.getClass();
            long jNanoTime2 = System.nanoTime() / 1000;
            if (jNanoTime2 - audioTrackPositionTracker2.lastPlayheadSampleTimeUs >= 30000) {
                j = 1000;
                long jSampleCountToDurationUs = Util.sampleCountToDurationUs(audioTrackPositionTracker2.outputSampleRate, audioTrackPositionTracker2.getPlaybackHeadPosition());
                if (jSampleCountToDurationUs != 0) {
                    int i = audioTrackPositionTracker2.nextPlayheadOffsetIndex;
                    float f2 = audioTrackPositionTracker2.audioTrackPlaybackSpeed;
                    if (f2 != 1.0f) {
                        jSampleCountToDurationUs = Math.round(jSampleCountToDurationUs / ((double) f2));
                    }
                    jArr[i] = jSampleCountToDurationUs - jNanoTime2;
                    audioTrackPositionTracker2.nextPlayheadOffsetIndex = (audioTrackPositionTracker2.nextPlayheadOffsetIndex + 1) % 10;
                    int i2 = audioTrackPositionTracker2.playheadOffsetCount;
                    if (i2 < 10) {
                        audioTrackPositionTracker2.playheadOffsetCount = i2 + 1;
                    }
                    audioTrackPositionTracker2.lastPlayheadSampleTimeUs = jNanoTime2;
                    audioTrackPositionTracker2.smoothedPlayheadOffsetUs = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = audioTrackPositionTracker2.playheadOffsetCount;
                        if (i3 >= i4) {
                            break;
                        }
                        audioTrackPositionTracker2.smoothedPlayheadOffsetUs = (jArr[i3] / ((long) i4)) + audioTrackPositionTracker2.smoothedPlayheadOffsetUs;
                        i3++;
                    }
                } else {
                    audioTrackPositionTracker2 = audioTrackPositionTracker2;
                    systemClock = systemClock;
                    audioTrack = audioTrack2;
                }
            } else {
                j = 1000;
            }
            long j6 = audioTrackPositionTracker2.latencyUs;
            if (!audioTrackPositionTracker2.isOutputPcm || (method = audioTrackPositionTracker2.getLatencyMethod) == null) {
                j5 = 500000;
            } else {
                j5 = 500000;
                if (jNanoTime2 - audioTrackPositionTracker2.lastLatencySampleTimeUs >= 500000) {
                    try {
                        Integer num = (Integer) method.invoke(audioTrack2, null);
                        String str = Util.DEVICE_DEBUG_INFO;
                        try {
                            long jIntValue = (((long) num.intValue()) * j) - audioTrackPositionTracker2.bufferSizeUs;
                            audioTrackPositionTracker2.latencyUs = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            audioTrackPositionTracker2.latencyUs = jMax;
                            if (jMax > 10000000) {
                                Log.w("AudioTrackAudioOutput", "Ignoring impossibly large audio latency: " + jMax);
                                audioTrackPositionTracker2.latencyUs = 0L;
                            }
                        } catch (Exception unused) {
                            method2 = null;
                            audioTrackPositionTracker2.getLatencyMethod = method2;
                        }
                    } catch (Exception unused2) {
                        method2 = null;
                    }
                    audioTrackPositionTracker2.lastLatencySampleTimeUs = jNanoTime2;
                }
            }
            boolean z4 = j6 != audioTrackPositionTracker2.latencyUs;
            float f3 = audioTrackPositionTracker2.audioTrackPlaybackSpeed;
            long playbackHeadPositionEstimateUs2 = audioTrackPositionTracker2.getPlaybackHeadPositionEstimateUs(jNanoTime2);
            AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper2 = audioTimestampPoller.audioTimestamp;
            AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper3 = audioTimestampPoller.audioTimestamp;
            int i5 = audioTimestampPoller.sampleRate;
            if (z4 || jNanoTime2 - audioTimestampPoller.lastTimestampSampleTimeUs >= audioTimestampPoller.sampleIntervalUs) {
                audioTimestampPoller.lastTimestampSampleTimeUs = jNanoTime2;
                AudioTrack audioTrack3 = audioTimestampWrapper2.audioTrack;
                AudioTimestamp audioTimestamp2 = audioTimestampWrapper2.audioTimestamp;
                boolean timestamp = audioTrack3.getTimestamp(audioTimestamp2);
                if (timestamp) {
                    long j7 = audioTimestamp2.framePosition;
                    long j8 = audioTimestampWrapper2.lastTimestampRawPositionFrames;
                    if (j8 > j7) {
                        if (audioTimestampWrapper2.expectTimestampFramePositionReset) {
                            audioTimestampWrapper2.accumulatedRawTimestampFramePosition += j8;
                            audioTimestampWrapper2.expectTimestampFramePositionReset = false;
                        } else {
                            audioTimestampWrapper2.rawTimestampFramePositionWrapCount++;
                        }
                    }
                    audioTimestampWrapper2.lastTimestampRawPositionFrames = j7;
                    audioTimestampWrapper2.lastTimestampPositionFrames = j7 + audioTimestampWrapper2.accumulatedRawTimestampFramePosition + (audioTimestampWrapper2.rawTimestampFramePositionWrapCount << 32);
                }
                if (timestamp) {
                    AtomicInt atomicInt = audioTimestampPoller.errorListener;
                    long j9 = audioTimestamp2.nanoTime / j;
                    z3 = timestamp;
                    audioTimestamp = audioTimestamp2;
                    long mediaDurationForPlayoutDuration2 = Util.getMediaDurationForPlayoutDuration(jNanoTime2 - (audioTimestampWrapper3.audioTimestamp.nanoTime / j), f3) + Util.sampleCountToDurationUs(i5, audioTimestampWrapper3.lastTimestampPositionFrames);
                    if (Math.abs(j9 - jNanoTime2) > 5000000) {
                        long j10 = audioTimestampWrapper2.lastTimestampPositionFrames;
                        atomicInt.getClass();
                        Log.w("AudioTrackAudioOutput", "Spurious audio timestamp (system clock mismatch): " + j10 + ", " + j9 + ", " + jNanoTime2 + ", " + playbackHeadPositionEstimateUs2 + ", " + ((AudioTrackAudioOutput) atomicInt.delegate).getWrittenFrames());
                        b2 = 4;
                        audioTimestampPoller.updateState(4);
                        audioTrack = audioTrack2;
                        f = f3;
                        audioTimestampWrapper = audioTimestampWrapper3;
                    } else if (Math.abs(mediaDurationForPlayoutDuration2 - playbackHeadPositionEstimateUs2) > 5000000) {
                        f = f3;
                        long j11 = audioTimestampWrapper2.lastTimestampPositionFrames;
                        atomicInt.getClass();
                        audioTrack = audioTrack2;
                        audioTimestampWrapper = audioTimestampWrapper3;
                        Log.w("AudioTrackAudioOutput", "Spurious audio timestamp (frame position mismatch): " + j11 + ", " + j9 + ", " + jNanoTime2 + ", " + playbackHeadPositionEstimateUs2 + ", " + ((AudioTrackAudioOutput) atomicInt.delegate).getWrittenFrames());
                        b2 = 4;
                        audioTimestampPoller.updateState(4);
                    } else {
                        audioTrack = audioTrack2;
                        f = f3;
                        audioTimestampWrapper = audioTimestampWrapper3;
                        b2 = 4;
                        if (audioTimestampPoller.state == 4) {
                            audioTimestampPoller.updateState(0);
                        }
                    }
                } else {
                    audioTrack = audioTrack2;
                    f = f3;
                    z3 = timestamp;
                    audioTimestamp = audioTimestamp2;
                    audioTimestampWrapper = audioTimestampWrapper3;
                    b2 = 4;
                }
                byte b3 = audioTimestampPoller.state;
                if (b3 == 0) {
                    AudioTimestamp audioTimestamp3 = audioTimestamp;
                    z = false;
                    if (z3) {
                        long j12 = audioTimestamp3.nanoTime;
                        if (j12 / j >= audioTimestampPoller.initializeSystemTimeUs) {
                            audioTimestampPoller.initialTimestampPositionFrames = audioTimestampWrapper2.lastTimestampPositionFrames;
                            audioTimestampPoller.initialTimestampSystemTimeUs = j12 / j;
                            audioTimestampPoller.updateState(1);
                        }
                    } else if (jNanoTime2 - audioTimestampPoller.initializeSystemTimeUs > j5) {
                        audioTimestampPoller.updateState(3);
                    }
                } else if (b3 == 1) {
                    AudioTimestamp audioTimestamp4 = audioTimestamp;
                    if (z3) {
                        long j13 = audioTimestampWrapper2.lastTimestampPositionFrames;
                        long j14 = audioTimestampPoller.initialTimestampPositionFrames;
                        if (j13 > j14) {
                            float f4 = f;
                            AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper4 = audioTimestampWrapper;
                            if (Math.abs((Util.getMediaDurationForPlayoutDuration(jNanoTime2 - (audioTimestampWrapper4.audioTimestamp.nanoTime / j), f4) + Util.sampleCountToDurationUs(i5, audioTimestampWrapper4.lastTimestampPositionFrames)) - (Util.getMediaDurationForPlayoutDuration(jNanoTime2 - audioTimestampPoller.initialTimestampSystemTimeUs, f4) + Util.sampleCountToDurationUs(i5, j14))) < j) {
                                audioTimestampPoller.updateState(2);
                            } else if (jNanoTime2 - audioTimestampPoller.initializeSystemTimeUs > 2000000) {
                                audioTimestampPoller.updateState(3);
                            } else {
                                audioTimestampPoller.initialTimestampPositionFrames = audioTimestampWrapper2.lastTimestampPositionFrames;
                                audioTimestampPoller.initialTimestampSystemTimeUs = audioTimestamp4.nanoTime / j;
                            }
                        } else if (jNanoTime2 - audioTimestampPoller.initializeSystemTimeUs > 2000000) {
                            audioTimestampPoller.updateState(3);
                        } else {
                            audioTimestampPoller.initialTimestampPositionFrames = audioTimestampWrapper2.lastTimestampPositionFrames;
                            audioTimestampPoller.initialTimestampSystemTimeUs = audioTimestamp4.nanoTime / j;
                        }
                    } else {
                        z = false;
                        audioTimestampPoller.updateState(0);
                    }
                } else if (b3 != 2) {
                    if (b3 != 3) {
                        if (b3 != b2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m();
                            return 0L;
                        }
                    } else if (z3) {
                        z = false;
                        audioTimestampPoller.updateState(0);
                    }
                } else if (!z3) {
                    audioTimestampPoller.updateState(0);
                }
                systemClock.getClass();
                jNanoTime = System.nanoTime() / j;
                if (audioTimestampPoller.state == 2) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if (z2) {
                    audioTrackPositionTracker = audioTrackPositionTracker2;
                    float f5 = audioTrackPositionTracker.audioTrackPlaybackSpeed;
                    AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper5 = audioTimestampPoller.audioTimestamp;
                    playbackHeadPositionEstimateUs = Util.getMediaDurationForPlayoutDuration(jNanoTime - (audioTimestampWrapper5.audioTimestamp.nanoTime / j), f5) + Util.sampleCountToDurationUs(audioTimestampPoller.sampleRate, audioTimestampWrapper5.lastTimestampPositionFrames);
                } else {
                    audioTrackPositionTracker = audioTrackPositionTracker2;
                    playbackHeadPositionEstimateUs = audioTrackPositionTracker.getPlaybackHeadPositionEstimateUs(jNanoTime);
                }
                jConstrainValue = playbackHeadPositionEstimateUs;
                playState = audioTrack.getPlayState();
                if (playState == 3) {
                    if (z2 || ((b = audioTimestampPoller.state) != 0 && b != 1)) {
                        audioTrackPositionTracker.maybeTriggerOnPositionAdvancingCallback(jConstrainValue);
                    }
                    j2 = audioTrackPositionTracker.lastSystemTimeUs;
                    if (j2 != -9223372036854775807L) {
                        j3 = jConstrainValue - audioTrackPositionTracker.lastPositionUs;
                        mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(jNanoTime - j2, audioTrackPositionTracker.audioTrackPlaybackSpeed);
                        j4 = audioTrackPositionTracker.lastPositionUs + mediaDurationForPlayoutDuration;
                        long jAbs = Math.abs(j4 - jConstrainValue);
                        if (j3 != 0 && jAbs < 1000000) {
                            long j15 = (mediaDurationForPlayoutDuration * 10) / 100;
                            jConstrainValue = Util.constrainValue(jConstrainValue, j4 - j15, j4 + j15);
                        }
                    }
                    audioTrackPositionTracker.lastSystemTimeUs = jNanoTime;
                    audioTrackPositionTracker.lastPositionUs = jConstrainValue;
                } else if (playState == 1) {
                    audioTrackPositionTracker.maybeTriggerOnPositionAdvancingCallback(jConstrainValue);
                }
                return jConstrainValue;
            }
            audioTrackPositionTracker2 = audioTrackPositionTracker2;
            systemClock = systemClock;
            audioTrack = audioTrack2;
        } else {
            audioTrackPositionTracker2 = audioTrackPositionTracker2;
            systemClock = systemClock;
            audioTrack = audioTrack2;
            j = 1000;
        }
        z = false;
        systemClock.getClass();
        jNanoTime = System.nanoTime() / j;
        if (audioTimestampPoller.state == 2) {
            z2 = true;
        } else {
            z2 = z;
        }
        if (z2) {
            audioTrackPositionTracker = audioTrackPositionTracker2;
            float f6 = audioTrackPositionTracker.audioTrackPlaybackSpeed;
            AudioTimestampPoller.AudioTimestampWrapper audioTimestampWrapper6 = audioTimestampPoller.audioTimestamp;
            playbackHeadPositionEstimateUs = Util.getMediaDurationForPlayoutDuration(jNanoTime - (audioTimestampWrapper6.audioTimestamp.nanoTime / j), f6) + Util.sampleCountToDurationUs(audioTimestampPoller.sampleRate, audioTimestampWrapper6.lastTimestampPositionFrames);
        } else {
            audioTrackPositionTracker = audioTrackPositionTracker2;
            playbackHeadPositionEstimateUs = audioTrackPositionTracker.getPlaybackHeadPositionEstimateUs(jNanoTime);
        }
        jConstrainValue = playbackHeadPositionEstimateUs;
        playState = audioTrack.getPlayState();
        if (playState == 3) {
            if (z2) {
                audioTrackPositionTracker.maybeTriggerOnPositionAdvancingCallback(jConstrainValue);
            } else {
                audioTrackPositionTracker.maybeTriggerOnPositionAdvancingCallback(jConstrainValue);
            }
            j2 = audioTrackPositionTracker.lastSystemTimeUs;
            if (j2 != -9223372036854775807L) {
                j3 = jConstrainValue - audioTrackPositionTracker.lastPositionUs;
                mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(jNanoTime - j2, audioTrackPositionTracker.audioTrackPlaybackSpeed);
                j4 = audioTrackPositionTracker.lastPositionUs + mediaDurationForPlayoutDuration;
                long jAbs2 = Math.abs(j4 - jConstrainValue);
                if (j3 != 0) {
                    long j16 = (mediaDurationForPlayoutDuration * 10) / 100;
                    jConstrainValue = Util.constrainValue(jConstrainValue, j4 - j16, j4 + j16);
                }
            }
            audioTrackPositionTracker.lastSystemTimeUs = jNanoTime;
            audioTrackPositionTracker.lastPositionUs = jConstrainValue;
        } else if (playState == 1) {
            audioTrackPositionTracker.maybeTriggerOnPositionAdvancingCallback(jConstrainValue);
        }
        return jConstrainValue;
    }

    public final long getWrittenFrames() {
        if (!this.isOutputPcm) {
            return this.writtenEncodedFrames;
        }
        long j = this.writtenPcmBytes;
        long j2 = this.pcmFrameSize;
        String str = Util.DEVICE_DEBUG_INFO;
        return ((j + j2) - 1) / j2;
    }

    public final boolean isOffloadedPlayback() {
        return Build.VERSION.SDK_INT >= 29 && this.audioTrack.isOffloadedPlayback();
    }

    public final void setOffloadDelayPadding(int i, int i2) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        this.audioTrack.setOffloadDelayPadding(i, i2);
    }

    public final void setOffloadEndOfStream() {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack.getPlayState() != 3) {
            return;
        }
        audioTrack.setOffloadEndOfStream();
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        audioTrackPositionTracker.expectRawPlaybackHeadReset = true;
        audioTrackPositionTracker.audioTimestampPoller.audioTimestamp.expectTimestampFramePositionReset = true;
    }

    public final void setPlayerId(PlayerId playerId) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        LogSessionId logSessionId = playerId.getLogSessionId();
        if (logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        this.audioTrack.setLogSessionId(logSessionId);
    }

    public final boolean write(int i, long j, ByteBuffer byteBuffer) {
        int iWrite;
        boolean z;
        AtomicInt atomicInt;
        AudioTrackAudioOutputProvider audioTrackAudioOutputProvider;
        AudioCapabilitiesReceiver audioCapabilitiesReceiver;
        AudioOutputProvider.OutputConfig outputConfig = this.config;
        boolean z2 = this.isOutputPcm;
        if (!z2 && this.framesPerEncodedSample == 0) {
            this.framesPerEncodedSample = DefaultAudioSink.getFramesPerEncodedSample(outputConfig.encoding, byteBuffer);
        }
        ListenerSet listenerSet = this.listeners;
        listenerSet.getClass();
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = listenerSet.thread;
        AudioTrack audioTrack = this.audioTrack;
        if (threadCurrentThread == thread) {
            getWrittenFrames();
            int underrunCount = audioTrack.getUnderrunCount();
            boolean z3 = underrunCount > this.lastUnderrunCount;
            this.lastUnderrunCount = underrunCount;
            if (z3) {
                listenerSet.sendEvent(-1, new FrameworkMediaDrm$$ExternalSyntheticLambda0((byte) 2));
            }
        }
        int iRemaining = byteBuffer.remaining();
        if (outputConfig.isTunneling) {
            if (j == Long.MIN_VALUE) {
                j = this.lastTunnelingAvSyncPresentationTimeUs;
            } else {
                this.lastTunnelingAvSyncPresentationTimeUs = j;
            }
            iWrite = audioTrack.write(byteBuffer, byteBuffer.remaining(), 1, j * 1000);
        } else {
            iWrite = audioTrack.write(byteBuffer, byteBuffer.remaining(), 1);
        }
        if (iWrite >= 0) {
            z = iWrite == iRemaining;
            if (z2) {
                this.writtenPcmBytes += (long) iWrite;
                return z;
            }
            if (z) {
                this.writtenEncodedFrames = (((long) this.framesPerEncodedSample) * ((long) i)) + this.writtenEncodedFrames;
            }
            return z;
        }
        z = iWrite == -6 || iWrite == -32;
        if (z && (atomicInt = this.capabilityChangeListener) != null && (audioCapabilitiesReceiver = (audioTrackAudioOutputProvider = (AudioTrackAudioOutputProvider) atomicInt.delegate).audioCapabilitiesReceiver) != null) {
            AudioCapabilities audioCapabilities = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
            audioTrackAudioOutputProvider.audioCapabilities = audioCapabilities;
            audioCapabilitiesReceiver.onNewAudioCapabilities(audioCapabilities);
        }
        throw new AudioOutput$WriteException(iWrite, z);
    }
}
