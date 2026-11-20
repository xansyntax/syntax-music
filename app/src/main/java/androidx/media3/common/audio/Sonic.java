package androidx.media3.common.audio;

import coil3.util.UtilsKt;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Sonic {
    public double accumulatedSpeedAdjustmentError;
    public final int channelCount;
    public final SonicImpl impl;
    public int inputFrameCount;
    public final int inputSampleRateHz;
    public final int maxPeriod;
    public final int maxRequiredFrameCount;
    public final int minPeriod;
    public int newRatePosition;
    public int oldRatePosition;
    public int outputFrameCount;
    public final float pitch;
    public int pitchFrameCount;
    public int prevPeriod;
    public final float rate;
    public int remainingInputToCopyFrameCount;
    public final float speed;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SonicFloatImpl implements SonicImpl {
        public final float[] downSampleBuffer;
        public float[] inputBuffer;
        public double maxDiff;
        public double minDiff;
        public float[] outputBuffer;
        public float[] pitchBuffer;
        public double prevMinDiff;

        public SonicFloatImpl() {
            int i = Sonic.this.maxRequiredFrameCount;
            this.downSampleBuffer = new float[i];
            int i2 = i * Sonic.this.channelCount;
            this.inputBuffer = new float[i2];
            this.outputBuffer = new float[i2];
            this.pitchBuffer = new float[i2];
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int bytesPerSample() {
            return 4;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void copyBufferToInputBuffer(int i, ByteBuffer byteBuffer) {
            FloatBuffer floatBufferAsFloatBuffer = byteBuffer.asFloatBuffer();
            float[] fArr = this.inputBuffer;
            Sonic sonic = Sonic.this;
            floatBufferAsFloatBuffer.get(fArr, sonic.inputFrameCount * sonic.channelCount, i / 4);
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void copyOutputToByteBuffer(int i, ByteBuffer byteBuffer) {
            FloatBuffer floatBufferAsFloatBuffer = byteBuffer.asFloatBuffer();
            float[] fArr = this.outputBuffer;
            int i2 = Sonic.this.channelCount;
            floatBufferAsFloatBuffer.put(fArr, 0, i * i2);
            byteBuffer.position((i * 4 * i2) + byteBuffer.position());
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void downSampleInput(int i, int i2) {
            Sonic sonic = Sonic.this;
            int i3 = sonic.maxRequiredFrameCount / i2;
            int i4 = sonic.channelCount;
            int i5 = i2 * i4;
            int i6 = i * i4;
            for (int i7 = 0; i7 < i3; i7++) {
                double d = 0.0d;
                for (int i8 = 0; i8 < i5; i8++) {
                    d += (double) this.inputBuffer[(i7 * i5) + i6 + i8];
                }
                this.downSampleBuffer[i7] = (float) (d / ((double) i5));
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInInputBuffer(int i) {
            this.inputBuffer = ensureSpaceForAdditionalFrames(Sonic.this.inputFrameCount, i, this.inputBuffer);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInOutputBuffer(int i) {
            this.outputBuffer = ensureSpaceForAdditionalFrames(Sonic.this.outputFrameCount, i, this.outputBuffer);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInPitchBuffer(int i) {
            this.pitchBuffer = ensureSpaceForAdditionalFrames(Sonic.this.pitchFrameCount, i, this.pitchBuffer);
        }

        public final float[] ensureSpaceForAdditionalFrames(int i, int i2, float[] fArr) {
            int length = fArr.length;
            int i3 = Sonic.this.channelCount;
            int i4 = length / i3;
            return i + i2 <= i4 ? fArr : Arrays.copyOf(fArr, (((i4 * 3) / 2) + i2) * i3);
        }

        public final int findPitchPeriodInRange(int i, int i2, int i3, float[] fArr) {
            int i4 = Sonic.this.channelCount * i;
            double d = 1.0d;
            int i5 = 0;
            double d2 = 0.0d;
            int i6 = 255;
            int i7 = i2;
            while (i7 <= i3) {
                double dAbs = 0.0d;
                for (int i8 = 0; i8 < i7; i8++) {
                    dAbs += (double) Math.abs(fArr[i4 + i8] - fArr[(i4 + i7) + i8]);
                }
                int i9 = i4;
                double d3 = i7;
                if (((double) i5) * dAbs < d * d3) {
                    i5 = i7;
                    d = dAbs;
                }
                if (((double) i6) * dAbs > d3 * d2) {
                    i6 = i7;
                    d2 = dAbs;
                }
                i7++;
                i4 = i9;
            }
            this.minDiff = d / ((double) i5);
            this.maxDiff = d2 / ((double) i6);
            return i5;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int findPitchPeriodInRangeWithDownsampleBuffer(int i, int i2) {
            return findPitchPeriodInRange(0, i, i2, this.downSampleBuffer);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int findPitchPeriodInRangeWithInputBuffer(int i, int i2, int i3) {
            return findPitchPeriodInRange(i, i2, i3, this.inputBuffer);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void flush() {
            this.prevMinDiff = 0.0d;
            this.minDiff = 0.0d;
            this.maxDiff = 0.0d;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getInputBuffer() {
            return this.inputBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getOutputBuffer() {
            return this.outputBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getPitchBuffer() {
            return this.pitchBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void interpolateFrame(int i, long j, long j2) {
            int i2 = 0;
            while (true) {
                Sonic sonic = Sonic.this;
                int i3 = sonic.channelCount;
                if (i2 >= i3) {
                    return;
                }
                float[] fArr = this.outputBuffer;
                int i4 = (sonic.outputFrameCount * i3) + i2;
                float[] fArr2 = this.pitchBuffer;
                int i5 = (i * i3) + i2;
                float f = fArr2[i5];
                float f2 = fArr2[i5 + i3];
                long j3 = ((long) sonic.newRatePosition) * j;
                int i6 = sonic.oldRatePosition;
                long j4 = ((long) (i6 + 1)) * j2;
                long j5 = j4 - j3;
                long j6 = j4 - (((long) i6) * j2);
                fArr[i4] = (((j6 - j5) * f2) + (j5 * f)) / j6;
                i2++;
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final boolean isPreviousPeriodBetter() {
            double d = this.minDiff;
            return d != 0.0d && Sonic.this.prevPeriod != 0 && this.maxDiff <= d * 3.0d && d * 2.0d > this.prevMinDiff * 3.0d;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void overlapAdd(int i, int i2, int i3, int i4, int i5) {
            float[] fArr = this.outputBuffer;
            float[] fArr2 = this.inputBuffer;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i3 * i2) + i6;
                int i8 = (i5 * i2) + i6;
                int i9 = (i4 * i2) + i6;
                for (int i10 = 0; i10 < i; i10++) {
                    fArr[i7] = ((fArr2[i8] * i10) + (fArr2[i9] * (i - i10))) / i;
                    i7 += i2;
                    i9 += i2;
                    i8 += i2;
                }
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void updatePreviousMinDiff() {
            this.prevMinDiff = this.minDiff;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void zeroInputBuffer(int i, int i2) {
            for (int i3 = 0; i3 < Sonic.this.channelCount * i2; i3++) {
                this.inputBuffer[i + i3] = 0.0f;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface SonicImpl {
        int bytesPerSample();

        void copyBufferToInputBuffer(int i, ByteBuffer byteBuffer);

        void copyOutputToByteBuffer(int i, ByteBuffer byteBuffer);

        void downSampleInput(int i, int i2);

        void ensureAdditionalFramesInInputBuffer(int i);

        void ensureAdditionalFramesInOutputBuffer(int i);

        void ensureAdditionalFramesInPitchBuffer(int i);

        int findPitchPeriodInRangeWithDownsampleBuffer(int i, int i2);

        int findPitchPeriodInRangeWithInputBuffer(int i, int i2, int i3);

        void flush();

        Object getInputBuffer();

        Object getOutputBuffer();

        Object getPitchBuffer();

        void interpolateFrame(int i, long j, long j2);

        boolean isPreviousPeriodBetter();

        void overlapAdd(int i, int i2, int i3, int i4, int i5);

        void updatePreviousMinDiff();

        void zeroInputBuffer(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SonicShortImpl implements SonicImpl {
        public final short[] downSampleBuffer;
        public short[] inputBuffer;
        public int maxDiff;
        public int minDiff;
        public short[] outputBuffer;
        public short[] pitchBuffer;
        public int prevMinDiff;

        public SonicShortImpl() {
            int i = Sonic.this.maxRequiredFrameCount;
            this.downSampleBuffer = new short[i];
            int i2 = i * Sonic.this.channelCount;
            this.inputBuffer = new short[i2];
            this.outputBuffer = new short[i2];
            this.pitchBuffer = new short[i2];
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int bytesPerSample() {
            return 2;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void copyBufferToInputBuffer(int i, ByteBuffer byteBuffer) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            short[] sArr = this.inputBuffer;
            Sonic sonic = Sonic.this;
            shortBufferAsShortBuffer.get(sArr, sonic.inputFrameCount * sonic.channelCount, i / 2);
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void copyOutputToByteBuffer(int i, ByteBuffer byteBuffer) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            short[] sArr = this.outputBuffer;
            int i2 = Sonic.this.channelCount;
            shortBufferAsShortBuffer.put(sArr, 0, i * i2);
            byteBuffer.position((i * 2 * i2) + byteBuffer.position());
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void downSampleInput(int i, int i2) {
            short[] sArr = this.inputBuffer;
            Sonic sonic = Sonic.this;
            int i3 = sonic.maxRequiredFrameCount / i2;
            int i4 = sonic.channelCount;
            int i5 = i2 * i4;
            int i6 = i * i4;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = 0;
                for (int i9 = 0; i9 < i5; i9++) {
                    i8 += sArr[(i7 * i5) + i6 + i9];
                }
                this.downSampleBuffer[i7] = (short) (i8 / i5);
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInInputBuffer(int i) {
            this.inputBuffer = ensureSpaceForAdditionalFrames(this.inputBuffer, Sonic.this.inputFrameCount, i);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInOutputBuffer(int i) {
            this.outputBuffer = ensureSpaceForAdditionalFrames(this.outputBuffer, Sonic.this.outputFrameCount, i);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void ensureAdditionalFramesInPitchBuffer(int i) {
            this.pitchBuffer = ensureSpaceForAdditionalFrames(this.pitchBuffer, Sonic.this.pitchFrameCount, i);
        }

        public final short[] ensureSpaceForAdditionalFrames(short[] sArr, int i, int i2) {
            int length = sArr.length;
            int i3 = Sonic.this.channelCount;
            int i4 = length / i3;
            return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
        }

        public final int findPitchPeriodInRange(short[] sArr, int i, int i2, int i3) {
            int i4 = i * Sonic.this.channelCount;
            int i5 = 255;
            int i6 = 1;
            int i7 = 0;
            int i8 = 0;
            while (i2 <= i3) {
                int iAbs = 0;
                for (int i9 = 0; i9 < i2; i9++) {
                    iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
                }
                if (iAbs * i7 < i6 * i2) {
                    i7 = i2;
                    i6 = iAbs;
                }
                if (iAbs * i5 > i8 * i2) {
                    i5 = i2;
                    i8 = iAbs;
                }
                i2++;
            }
            this.minDiff = i6 / i7;
            this.maxDiff = i8 / i5;
            return i7;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int findPitchPeriodInRangeWithDownsampleBuffer(int i, int i2) {
            return findPitchPeriodInRange(this.downSampleBuffer, 0, i, i2);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final int findPitchPeriodInRangeWithInputBuffer(int i, int i2, int i3) {
            return findPitchPeriodInRange(this.inputBuffer, i, i2, i3);
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void flush() {
            this.prevMinDiff = 0;
            this.minDiff = 0;
            this.maxDiff = 0;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getInputBuffer() {
            return this.inputBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getOutputBuffer() {
            return this.outputBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final Object getPitchBuffer() {
            return this.pitchBuffer;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void interpolateFrame(int i, long j, long j2) {
            int i2 = 0;
            while (true) {
                Sonic sonic = Sonic.this;
                int i3 = sonic.channelCount;
                if (i2 >= i3) {
                    return;
                }
                short[] sArr = this.outputBuffer;
                int i4 = (sonic.outputFrameCount * i3) + i2;
                short[] sArr2 = this.pitchBuffer;
                int i5 = (i * i3) + i2;
                short s = sArr2[i5];
                short s2 = sArr2[i5 + i3];
                long j3 = ((long) sonic.newRatePosition) * j;
                int i6 = sonic.oldRatePosition;
                long j4 = ((long) (i6 + 1)) * j2;
                long j5 = j4 - j3;
                long j6 = j4 - (((long) i6) * j2);
                sArr[i4] = (short) ((((j6 - j5) * ((long) s2)) + (((long) s) * j5)) / j6);
                i2++;
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final boolean isPreviousPeriodBetter() {
            int i = this.minDiff;
            return i != 0 && Sonic.this.prevPeriod != 0 && this.maxDiff <= i * 3 && i * 2 > this.prevMinDiff * 3;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void overlapAdd(int i, int i2, int i3, int i4, int i5) {
            short[] sArr = this.outputBuffer;
            short[] sArr2 = this.inputBuffer;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i3 * i2) + i6;
                int i8 = (i5 * i2) + i6;
                int i9 = (i4 * i2) + i6;
                for (int i10 = 0; i10 < i; i10++) {
                    sArr[i7] = (short) (((sArr2[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                    i7 += i2;
                    i9 += i2;
                    i8 += i2;
                }
            }
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void updatePreviousMinDiff() {
            this.prevMinDiff = this.minDiff;
        }

        @Override // androidx.media3.common.audio.Sonic.SonicImpl
        public final void zeroInputBuffer(int i, int i2) {
            for (int i3 = 0; i3 < Sonic.this.channelCount * i2; i3++) {
                this.inputBuffer[i + i3] = 0;
            }
        }
    }

    public Sonic(int i, int i2, float f, float f2, int i3, boolean z) {
        this.inputSampleRateHz = i;
        this.channelCount = i2;
        this.speed = f;
        this.pitch = f2;
        this.rate = i / i3;
        this.minPeriod = i / 400;
        int i4 = i / 65;
        this.maxPeriod = i4;
        this.maxRequiredFrameCount = i4 * 2;
        this.impl = z ? new SonicFloatImpl() : new SonicShortImpl();
    }

    public final void copyToOutput(int i, int i2) {
        SonicImpl sonicImpl = this.impl;
        sonicImpl.ensureAdditionalFramesInOutputBuffer(i2);
        Object inputBuffer = sonicImpl.getInputBuffer();
        int i3 = this.channelCount;
        System.arraycopy(inputBuffer, i * i3, sonicImpl.getOutputBuffer(), this.outputFrameCount * i3, i3 * i2);
        this.outputFrameCount += i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void processStreamInput() {
        float f;
        int iFindPitchPeriodInRangeWithDownsampleBuffer;
        double d;
        int i;
        int iRound;
        int i2;
        int iRound2;
        int i3;
        int i4;
        long j;
        long j2;
        int i5 = this.outputFrameCount;
        float f2 = this.speed;
        float f3 = this.pitch;
        double d2 = f2 / f3;
        float f4 = this.rate * f3;
        int i6 = this.inputSampleRateHz;
        int i7 = 1;
        SonicImpl sonicImpl = this.impl;
        int i8 = this.channelCount;
        if (d2 > 1.0000100135803223d || d2 < 0.9999899864196777d) {
            int i9 = this.inputFrameCount;
            int i10 = this.maxRequiredFrameCount;
            if (i9 >= i10) {
                int i11 = 0;
                while (true) {
                    int i12 = this.remainingInputToCopyFrameCount;
                    if (i12 > 0) {
                        int iMin = Math.min(i10, i12);
                        copyToOutput(i11, iMin);
                        this.remainingInputToCopyFrameCount -= iMin;
                        i11 += iMin;
                        f = f4;
                        d = d2;
                        i2 = i7;
                        i = i10;
                    } else {
                        int i13 = i6 > 4000 ? i6 / 4000 : i7;
                        int i14 = this.maxPeriod;
                        int i15 = this.minPeriod;
                        if (i8 == i7 && i13 == i7) {
                            iFindPitchPeriodInRangeWithDownsampleBuffer = sonicImpl.findPitchPeriodInRangeWithInputBuffer(i11, i15, i14);
                            f = f4;
                        } else {
                            sonicImpl.downSampleInput(i11, i13);
                            f = f4;
                            int iFindPitchPeriodInRangeWithDownsampleBuffer2 = sonicImpl.findPitchPeriodInRangeWithDownsampleBuffer(i15 / i13, i14 / i13);
                            if (i13 != i7) {
                                int i16 = iFindPitchPeriodInRangeWithDownsampleBuffer2 * i13;
                                int i17 = i13 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                if (i18 >= i15) {
                                    i15 = i18;
                                }
                                if (i19 <= i14) {
                                    i14 = i19;
                                }
                                if (i8 == i7) {
                                    iFindPitchPeriodInRangeWithDownsampleBuffer = sonicImpl.findPitchPeriodInRangeWithInputBuffer(i11, i15, i14);
                                } else {
                                    sonicImpl.downSampleInput(i11, i7);
                                    iFindPitchPeriodInRangeWithDownsampleBuffer = sonicImpl.findPitchPeriodInRangeWithDownsampleBuffer(i15, i14);
                                }
                            } else {
                                iFindPitchPeriodInRangeWithDownsampleBuffer = iFindPitchPeriodInRangeWithDownsampleBuffer2;
                            }
                        }
                        int i20 = sonicImpl.isPreviousPeriodBetter() ? this.prevPeriod : iFindPitchPeriodInRangeWithDownsampleBuffer;
                        sonicImpl.updatePreviousMinDiff();
                        this.prevPeriod = iFindPitchPeriodInRangeWithDownsampleBuffer;
                        double d3 = this.accumulatedSpeedAdjustmentError;
                        if (d2 > 1.0d) {
                            if (d2 >= 2.0d) {
                                double d4 = (((double) i20) / (d2 - 1.0d)) + d3;
                                iRound2 = (int) Math.round(d4);
                                d = d2;
                                this.accumulatedSpeedAdjustmentError = d4 - ((double) iRound2);
                                sonicImpl = sonicImpl;
                            } else {
                                d = d2;
                                double d5 = (((2.0d - d) * ((double) i20)) / (d - 1.0d)) + d3;
                                int iRound3 = (int) Math.round(d5);
                                this.remainingInputToCopyFrameCount = iRound3;
                                this.accumulatedSpeedAdjustmentError = d5 - ((double) iRound3);
                                iRound2 = i20;
                            }
                            sonicImpl.ensureAdditionalFramesInOutputBuffer(iRound2);
                            int i21 = i10;
                            int i22 = iRound2;
                            sonicImpl.overlapAdd(i22, this.channelCount, this.outputFrameCount, i11, i11 + i20);
                            this.outputFrameCount += i22;
                            i11 = i20 + i22 + i11;
                            i = i21;
                            i2 = i7;
                        } else {
                            d = d2;
                            int i23 = i7;
                            i = i10;
                            if (d < 0.5d) {
                                double d6 = ((((double) i20) * d) / (1.0d - d)) + d3;
                                iRound = (int) Math.round(d6);
                                this.accumulatedSpeedAdjustmentError = d6 - ((double) iRound);
                            } else {
                                double d7 = ((((2.0d * d) - 1.0d) * ((double) i20)) / (1.0d - d)) + d3;
                                int iRound4 = (int) Math.round(d7);
                                this.remainingInputToCopyFrameCount = iRound4;
                                this.accumulatedSpeedAdjustmentError = d7 - ((double) iRound4);
                                iRound = i20;
                            }
                            int i24 = i20 + iRound;
                            sonicImpl.ensureAdditionalFramesInOutputBuffer(i24);
                            i2 = i23;
                            System.arraycopy(sonicImpl.getInputBuffer(), i11 * i8, sonicImpl.getOutputBuffer(), this.outputFrameCount * i8, i20 * i8);
                            int i25 = i11;
                            sonicImpl.overlapAdd(iRound, this.channelCount, this.outputFrameCount + i20, i20 + i11, i25);
                            this.outputFrameCount += i24;
                            i11 = i25 + iRound;
                        }
                    }
                    if (i11 + i > i9) {
                        break;
                    }
                    i10 = i;
                    f4 = f;
                    i7 = i2;
                    d2 = d;
                }
                int i26 = this.inputFrameCount - i11;
                System.arraycopy(sonicImpl.getInputBuffer(), i11 * i8, sonicImpl.getInputBuffer(), 0, i26 * i8);
                this.inputFrameCount = i26;
            }
            if (f != 1.0f || this.outputFrameCount == i5) {
            }
            long j3 = (long) (i6 / f);
            long j4 = i6;
            while (j3 != 0 && j4 != 0 && j3 % 2 == 0 && j4 % 2 == 0) {
                j3 /= 2;
                j4 /= 2;
            }
            int i27 = this.outputFrameCount - i5;
            sonicImpl.ensureAdditionalFramesInPitchBuffer(i27);
            System.arraycopy(sonicImpl.getOutputBuffer(), i5 * i8, sonicImpl.getPitchBuffer(), this.pitchFrameCount * i8, i27 * i8);
            this.outputFrameCount = i5;
            this.pitchFrameCount += i27;
            int i28 = 0;
            while (true) {
                i3 = this.pitchFrameCount - 1;
                if (i28 >= i3) {
                    break;
                }
                while (true) {
                    i4 = this.oldRatePosition + 1;
                    j = i4;
                    long j5 = j * j3;
                    j2 = this.newRatePosition;
                    if (j5 <= j2 * j4) {
                        break;
                    }
                    int i29 = i2;
                    sonicImpl.ensureAdditionalFramesInOutputBuffer(i29);
                    sonicImpl.interpolateFrame(i28, j4, j3);
                    this.newRatePosition += i29;
                    this.outputFrameCount += i29;
                }
                int i30 = i2;
                this.oldRatePosition = i4;
                if (j == j4) {
                    this.oldRatePosition = 0;
                    UtilsKt.checkState(j2 == j3 ? i30 : 0);
                    this.newRatePosition = 0;
                }
                i28++;
                i2 = i30;
            }
            if (i3 == 0) {
                return;
            }
            System.arraycopy(sonicImpl.getPitchBuffer(), i3 * i8, sonicImpl.getPitchBuffer(), 0, (this.pitchFrameCount - i3) * i8);
            this.pitchFrameCount -= i3;
            return;
        }
        copyToOutput(0, this.inputFrameCount);
        this.inputFrameCount = 0;
        f = f4;
        i2 = 1;
        if (f != 1.0f) {
        }
    }
}
