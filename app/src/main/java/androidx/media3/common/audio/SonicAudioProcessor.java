package androidx.media3.common.audio;

import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SonicAudioProcessor implements AudioProcessor {
    public ByteBuffer buffer;
    public AudioProcessor.AudioFormat inputAudioFormat;
    public long inputBytes;
    public boolean inputEnded;
    public AudioProcessor.AudioFormat outputAudioFormat;
    public ByteBuffer outputBuffer;
    public long outputBytes;
    public AudioProcessor.AudioFormat pendingInputAudioFormat;
    public AudioProcessor.AudioFormat pendingOutputAudioFormat;
    public boolean pendingSonicRecreation;
    public Sonic sonic;
    public float speed = 1.0f;
    public float pitch = 1.0f;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat configure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        if (i != 2 && i != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i2 = audioFormat.sampleRate;
        this.pendingInputAudioFormat = audioFormat;
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.channelCount, i);
        this.pendingOutputAudioFormat = audioFormat2;
        this.pendingSonicRecreation = true;
        return audioFormat2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush(AudioProcessor.StreamMetadata streamMetadata) {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.pendingInputAudioFormat;
            this.inputAudioFormat = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.pendingOutputAudioFormat;
            this.outputAudioFormat = audioFormat2;
            if (this.pendingSonicRecreation) {
                this.sonic = new Sonic(audioFormat.sampleRate, audioFormat.channelCount, this.speed, this.pitch, audioFormat2.sampleRate, audioFormat.encoding == 4);
            } else {
                Sonic sonic = this.sonic;
                if (sonic != null) {
                    sonic.inputFrameCount = 0;
                    sonic.outputFrameCount = 0;
                    sonic.pitchFrameCount = 0;
                    sonic.oldRatePosition = 0;
                    sonic.newRatePosition = 0;
                    sonic.remainingInputToCopyFrameCount = 0;
                    sonic.prevPeriod = 0;
                    sonic.accumulatedSpeedAdjustmentError = 0.0d;
                    sonic.impl.flush();
                }
            }
        }
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final long getDurationAfterProcessorApplied(long j) {
        if (this.outputBytes < 1024) {
            return (long) (j / ((double) this.speed));
        }
        long j2 = this.inputBytes;
        Sonic sonic = this.sonic;
        sonic.getClass();
        long jBytesPerSample = j2 - ((long) (sonic.impl.bytesPerSample() * (sonic.inputFrameCount * sonic.channelCount)));
        int i = this.outputAudioFormat.sampleRate;
        int i2 = this.inputAudioFormat.sampleRate;
        long j3 = this.outputBytes;
        return i == i2 ? Util.scaleLargeValue(j, j3, jBytesPerSample, RoundingMode.DOWN) : Util.scaleLargeValue(j, j3 * ((long) i2), jBytesPerSample * ((long) i), RoundingMode.DOWN);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final ByteBuffer getOutput() {
        Sonic sonic = this.sonic;
        if (sonic != null) {
            Sonic.SonicImpl sonicImpl = sonic.impl;
            int i = sonic.channelCount;
            UtilsKt.checkState(sonic.outputFrameCount >= 0);
            int iBytesPerSample = sonicImpl.bytesPerSample() * sonic.outputFrameCount * i;
            if (iBytesPerSample > 0) {
                if (this.buffer.capacity() < iBytesPerSample) {
                    this.buffer = ByteBuffer.allocateDirect(iBytesPerSample).order(ByteOrder.nativeOrder());
                } else {
                    this.buffer.clear();
                }
                ByteBuffer byteBuffer = this.buffer;
                UtilsKt.checkState(sonic.outputFrameCount >= 0);
                int iMin = Math.min(byteBuffer.remaining() / (sonicImpl.bytesPerSample() * i), sonic.outputFrameCount);
                sonicImpl.copyOutputToByteBuffer(iMin, byteBuffer);
                sonic.outputFrameCount -= iMin;
                System.arraycopy(sonicImpl.getOutputBuffer(), iMin * i, sonicImpl.getOutputBuffer(), 0, sonic.outputFrameCount * i);
                this.buffer.flip();
                this.outputBytes += (long) iBytesPerSample;
                this.outputBuffer = this.buffer;
            }
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean isActive() {
        if (this.pendingOutputAudioFormat.sampleRate != -1) {
            return Math.abs(this.speed - 1.0f) >= 1.0E-4f || Math.abs(this.pitch - 1.0f) >= 1.0E-4f || this.pendingOutputAudioFormat.sampleRate != this.pendingInputAudioFormat.sampleRate;
        }
        return false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean isEnded() {
        if (this.inputEnded) {
            Sonic sonic = this.sonic;
            if (sonic != null) {
                UtilsKt.checkState(sonic.outputFrameCount >= 0);
                if (sonic.impl.bytesPerSample() * sonic.outputFrameCount * sonic.channelCount == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueEndOfStream() {
        Sonic sonic = this.sonic;
        if (sonic != null) {
            int i = sonic.inputFrameCount;
            float f = sonic.speed;
            float f2 = sonic.pitch;
            double d = f / f2;
            double d2 = sonic.rate * f2;
            int i2 = sonic.remainingInputToCopyFrameCount;
            int i3 = sonic.outputFrameCount + ((int) ((((((((double) (i - i2)) / d) + ((double) i2)) + sonic.accumulatedSpeedAdjustmentError) + ((double) sonic.pitchFrameCount)) / d2) + 0.5d));
            sonic.accumulatedSpeedAdjustmentError = 0.0d;
            Sonic.SonicImpl sonicImpl = sonic.impl;
            int i4 = sonic.maxRequiredFrameCount * 2;
            sonicImpl.ensureAdditionalFramesInInputBuffer(i4 + i);
            sonicImpl.zeroInputBuffer(i * sonic.channelCount, i4);
            sonic.inputFrameCount = i4 + sonic.inputFrameCount;
            sonic.processStreamInput();
            if (sonic.outputFrameCount > i3) {
                sonic.outputFrameCount = Math.max(i3, 0);
            }
            sonic.inputFrameCount = 0;
            sonic.remainingInputToCopyFrameCount = 0;
            sonic.pitchFrameCount = 0;
        }
        this.inputEnded = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            Sonic sonic = this.sonic;
            sonic.getClass();
            this.inputBytes += (long) byteBuffer.remaining();
            int iRemaining = byteBuffer.remaining();
            int i = sonic.channelCount;
            Sonic.SonicImpl sonicImpl = sonic.impl;
            int iBytesPerSample = iRemaining / (sonicImpl.bytesPerSample() * i);
            sonicImpl.ensureAdditionalFramesInInputBuffer(iBytesPerSample);
            sonicImpl.copyBufferToInputBuffer(iRemaining, byteBuffer);
            sonic.inputFrameCount += iBytesPerSample;
            sonic.processStreamInput();
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        this.speed = 1.0f;
        this.pitch = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = audioFormat;
        this.pendingOutputAudioFormat = audioFormat;
        this.inputAudioFormat = audioFormat;
        this.outputAudioFormat = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.pendingSonicRecreation = false;
        this.sonic = null;
        this.inputBytes = 0L;
        this.outputBytes = 0L;
        this.inputEnded = false;
    }
}
