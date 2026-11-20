package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import androidx.sqlite.SQLite;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.nio.ByteBuffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public int bytesPerFrame;
    public byte[] contiguousOutputBuffer;
    public boolean enabled;
    public byte[] maybeSilenceBuffer;
    public final byte minVolumeToKeepPercentageWhenMuting;
    public final int minimumSilenceDurationUs;
    public final float silenceRetentionRatio;
    public final short silenceThresholdLevel;
    public long skippedFrames;
    public boolean state;
    public int outputSilenceFramesSinceNoise = 0;
    public int maybeSilenceBufferStartIndex = 0;
    public int maybeSilenceBufferContentsSize = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public SilenceSkippingAudioProcessor(long j, float f, int i, short s) {
        boolean z = false;
        if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 1.0f) {
            z = true;
        }
        UtilsKt.checkArgument(z);
        this.minimumSilenceDurationUs = (int) j;
        this.silenceRetentionRatio = f;
        this.minVolumeToKeepPercentageWhenMuting = i;
        this.silenceThresholdLevel = s;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = bArr;
        this.contiguousOutputBuffer = bArr;
    }

    public final int calculateShortenedSilenceLength(int i) {
        int length = ((((int) ((2000000 * ((long) this.inputAudioFormat.sampleRate)) / 1000000)) - this.outputSilenceFramesSinceNoise) * this.bytesPerFrame) - (this.maybeSilenceBuffer.length / 2);
        UtilsKt.checkState(length >= 0);
        int iMin = (int) Math.min((i * this.silenceRetentionRatio) + 0.5f, length);
        int i2 = this.bytesPerFrame;
        return (iMin / i2) * i2;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public final boolean isActive() {
        return super.isActive() && this.enabled;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.encoding == 2) {
            return audioFormat.sampleRate == -1 ? AudioProcessor.AudioFormat.NOT_SET : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onFlush(AudioProcessor.StreamMetadata streamMetadata) {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
            int i = audioFormat.channelCount * 2;
            this.bytesPerFrame = i;
            int i2 = ((((int) ((((long) this.minimumSilenceDurationUs) * ((long) audioFormat.sampleRate)) / 1000000)) / 2) / i) * i * 2;
            if (this.maybeSilenceBuffer.length != i2) {
                this.maybeSilenceBuffer = new byte[i2];
                this.contiguousOutputBuffer = new byte[i2];
            }
        }
        this.state = false;
        this.skippedFrames = 0L;
        this.outputSilenceFramesSinceNoise = 0;
        this.maybeSilenceBufferStartIndex = 0;
        this.maybeSilenceBufferContentsSize = 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onQueueEndOfStream() {
        if (this.maybeSilenceBufferContentsSize > 0) {
            outputShortenedSilenceBuffer(true);
            this.outputSilenceFramesSinceNoise = 0;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onReset() {
        this.enabled = false;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = bArr;
        this.contiguousOutputBuffer = bArr;
    }

    public final void outputShortenedSilenceBuffer(boolean z) {
        int length;
        int iCalculateShortenedSilenceLength;
        int i = this.maybeSilenceBufferContentsSize;
        byte[] bArr = this.maybeSilenceBuffer;
        if (i == bArr.length || z) {
            if (this.outputSilenceFramesSinceNoise == 0) {
                if (z) {
                    outputSilence(i, 3);
                    length = i;
                } else {
                    UtilsKt.checkState(i >= bArr.length / 2);
                    length = this.maybeSilenceBuffer.length / 2;
                    outputSilence(length, 0);
                }
                iCalculateShortenedSilenceLength = length;
            } else if (z) {
                int length2 = i - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iCalculateShortenedSilenceLength2 = calculateShortenedSilenceLength(length2) + (this.maybeSilenceBuffer.length / 2);
                outputSilence(iCalculateShortenedSilenceLength2, 2);
                iCalculateShortenedSilenceLength = iCalculateShortenedSilenceLength2;
                length = length3;
            } else {
                length = i - (bArr.length / 2);
                iCalculateShortenedSilenceLength = calculateShortenedSilenceLength(length);
                outputSilence(iCalculateShortenedSilenceLength, 1);
            }
            if (!(length % this.bytesPerFrame == 0)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(SQLite.lenientFormat("bytesConsumed is not aligned to frame size: %s", Integer.valueOf(length)));
                return;
            }
            UtilsKt.checkState(i >= iCalculateShortenedSilenceLength);
            this.maybeSilenceBufferContentsSize -= length;
            int i2 = this.maybeSilenceBufferStartIndex + length;
            this.maybeSilenceBufferStartIndex = i2;
            this.maybeSilenceBufferStartIndex = i2 % this.maybeSilenceBuffer.length;
            int i3 = this.outputSilenceFramesSinceNoise;
            int i4 = this.bytesPerFrame;
            this.outputSilenceFramesSinceNoise = (iCalculateShortenedSilenceLength / i4) + i3;
            this.skippedFrames += (long) ((length - iCalculateShortenedSilenceLength) / i4);
        }
    }

    public final void outputSilence(int i, int i2) {
        if (i == 0) {
            return;
        }
        UtilsKt.checkArgument(this.maybeSilenceBufferContentsSize >= i);
        int i3 = this.maybeSilenceBufferStartIndex;
        if (i2 == 2) {
            int i4 = this.maybeSilenceBufferContentsSize;
            int i5 = i3 + i4;
            byte[] bArr = this.maybeSilenceBuffer;
            if (i5 <= bArr.length) {
                System.arraycopy(bArr, i5 - i, this.contiguousOutputBuffer, 0, i);
            } else {
                int length = i4 - (bArr.length - i3);
                byte[] bArr2 = this.contiguousOutputBuffer;
                if (length >= i) {
                    System.arraycopy(bArr, length - i, bArr2, 0, i);
                } else {
                    int i6 = i - length;
                    System.arraycopy(bArr, bArr.length - i6, bArr2, 0, i6);
                    System.arraycopy(this.maybeSilenceBuffer, 0, this.contiguousOutputBuffer, i6, length);
                }
            }
        } else {
            int i7 = i3 + i;
            byte[] bArr3 = this.maybeSilenceBuffer;
            int length2 = bArr3.length;
            byte[] bArr4 = this.contiguousOutputBuffer;
            if (i7 <= length2) {
                System.arraycopy(bArr3, i3, bArr4, 0, i);
            } else {
                int length3 = bArr3.length - i3;
                System.arraycopy(bArr3, i3, bArr4, 0, length3);
                System.arraycopy(this.maybeSilenceBuffer, 0, this.contiguousOutputBuffer, length3, i - length3);
            }
        }
        UtilsKt.checkArgument("sizeToOutput is not aligned to frame size: %s", i, i % this.bytesPerFrame == 0);
        UtilsKt.checkState(this.maybeSilenceBufferStartIndex < this.maybeSilenceBuffer.length);
        byte[] bArr5 = this.contiguousOutputBuffer;
        UtilsKt.checkArgument("byteOutput size is not aligned to frame size %s", i, i % this.bytesPerFrame == 0);
        if (i2 != 3) {
            for (int i8 = 0; i8 < i; i8 += 2) {
                int i9 = i8 + 1;
                int i10 = (bArr5[i9] << 8) | (bArr5[i8] & 255);
                int i11 = this.minVolumeToKeepPercentageWhenMuting;
                if (i2 == 0) {
                    i11 = ((((i8 * CIOKt.DEFAULT_HTTP_POOL_SIZE) / (i - 1)) * (i11 - 100)) / CIOKt.DEFAULT_HTTP_POOL_SIZE) + 100;
                } else if (i2 == 2) {
                    i11 += (((i8 * CIOKt.DEFAULT_HTTP_POOL_SIZE) * (100 - i11)) / (i - 1)) / CIOKt.DEFAULT_HTTP_POOL_SIZE;
                }
                int i12 = (i10 * i11) / 100;
                if (i12 >= 32767) {
                    bArr5[i8] = -1;
                    bArr5[i9] = 127;
                } else if (i12 <= -32768) {
                    bArr5[i8] = 0;
                    bArr5[i9] = -128;
                } else {
                    bArr5[i8] = (byte) (i12 & 255);
                    bArr5[i9] = (byte) (i12 >> 8);
                }
            }
        }
        replaceOutputBuffer(i).put(bArr5, 0, i).flip();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        int iLimit;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.outputBuffer.hasRemaining()) {
            boolean z = this.state;
            short s = this.silenceThresholdLevel;
            if (!z) {
                int iLimit2 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit2, byteBuffer.position() + this.maybeSilenceBuffer.length));
                int iLimit3 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit3 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit3) << 8) | (byteBuffer.get(iLimit3 - 1) & 255)) > s) {
                        int i = this.bytesPerFrame;
                        iPosition = ((iLimit3 / i) * i) + i;
                        break;
                    }
                    iLimit3 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.state = true;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    replaceOutputBuffer(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit2);
            } else {
                if (!z) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    return;
                }
                UtilsKt.checkState(this.maybeSilenceBufferStartIndex < this.maybeSilenceBuffer.length);
                int iLimit4 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & 255)) > s) {
                        int i2 = this.bytesPerFrame;
                        iLimit = (iPosition2 / i2) * i2;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int length = this.maybeSilenceBufferStartIndex;
                int i3 = this.maybeSilenceBufferContentsSize;
                int length2 = length + i3;
                byte[] bArr = this.maybeSilenceBuffer;
                if (length2 < bArr.length) {
                    length = bArr.length;
                } else {
                    length2 = i3 - (bArr.length - length);
                }
                int i4 = length - length2;
                boolean z2 = iLimit < iLimit4;
                int iMin = Math.min(iPosition3, i4);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.maybeSilenceBuffer, length2, iMin);
                int i5 = this.maybeSilenceBufferContentsSize + iMin;
                this.maybeSilenceBufferContentsSize = i5;
                UtilsKt.checkState(i5 <= this.maybeSilenceBuffer.length);
                boolean z3 = z2 && iPosition3 < i4;
                outputShortenedSilenceBuffer(z3);
                if (z3) {
                    this.state = false;
                    this.outputSilenceFramesSinceNoise = 0;
                }
                byteBuffer.limit(iLimit4);
            }
        }
    }
}
