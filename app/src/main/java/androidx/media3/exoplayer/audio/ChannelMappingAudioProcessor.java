package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelMappingAudioProcessor extends BaseAudioProcessor {
    public int[] outputChannels;
    public int[] pendingOutputChannels;

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        int[] iArr = this.pendingOutputChannels;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        int i2 = audioFormat.channelCount;
        if (!Util.isEncodingLinearPcm(i)) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        boolean z = i2 != iArr.length;
        int i3 = 0;
        while (i3 < iArr.length) {
            int i4 = iArr[i3];
            if (i4 >= i2) {
                throw new AudioProcessor.UnhandledAudioFormatException("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", audioFormat);
            }
            z |= i4 != i3;
            i3++;
        }
        return z ? new AudioProcessor.AudioFormat(audioFormat.sampleRate, iArr.length, i) : AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onFlush(AudioProcessor.StreamMetadata streamMetadata) {
        this.outputChannels = this.pendingOutputChannels;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onReset() {
        this.outputChannels = null;
        this.pendingOutputChannels = null;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x007c  */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00db  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:59:0x010d  */
    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder;
        ByteOrder byteOrder;
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        int[] iArr = this.outputChannels;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(((iLimit - iPosition) / this.inputAudioFormat.bytesPerFrame) * this.outputAudioFormat.bytesPerFrame);
        while (iPosition < iLimit) {
            for (int i5 : iArr) {
                int byteDepth = (Util.getByteDepth(this.inputAudioFormat.encoding) * i5) + iPosition;
                int i6 = this.inputAudioFormat.encoding;
                if (i6 == 2) {
                    byteBufferReplaceOutputBuffer.putShort(byteBuffer.getShort(byteDepth));
                } else if (i6 == 3) {
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(byteDepth));
                } else if (i6 == 4) {
                    byteBufferReplaceOutputBuffer.putFloat(byteBuffer.getFloat(byteDepth));
                } else if (i6 == 21) {
                    byteOrderOrder = byteBuffer.order();
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    if (byteOrderOrder == byteOrder) {
                        i = byteDepth;
                    } else {
                        i = byteDepth + 2;
                    }
                    byte b = byteBuffer.get(i);
                    byte b2 = byteBuffer.get(byteDepth + 1);
                    if (byteBuffer.order() == byteOrder) {
                        byteDepth += 2;
                    }
                    i2 = ((((b << 24) & (-16777216)) | ((b2 << 16) & 16711680)) | ((byteBuffer.get(byteDepth) << 8) & 65280)) >> 8;
                    if ((i2 & (-16777216)) != 0 || (i2 & (-8388608)) == -8388608) {
                        z = true;
                    } else {
                        z = false;
                    }
                    UtilsKt.checkArgument(z, "Value out of range of 24-bit integer: %s", Integer.toHexString(i2));
                    UtilsKt.checkArgument(byteBufferReplaceOutputBuffer.remaining() >= 3);
                    if (byteBufferReplaceOutputBuffer.order() == byteOrder) {
                        i3 = (i2 & 16711680) >> 16;
                    } else {
                        i3 = i2 & 255;
                    }
                    byte b3 = (byte) i3;
                    byte b4 = (byte) ((i2 & 65280) >> 8);
                    if (byteBufferReplaceOutputBuffer.order() == byteOrder) {
                        i4 = i2 & 255;
                    } else {
                        i4 = (i2 & 16711680) >> 16;
                    }
                    byteBufferReplaceOutputBuffer.put(b3).put(b4).put((byte) i4);
                } else if (i6 == 22) {
                    byteBufferReplaceOutputBuffer.putInt(byteBuffer.getInt(byteDepth));
                } else if (i6 == 268435456) {
                    byteBufferReplaceOutputBuffer.putShort(byteBuffer.getShort(byteDepth));
                } else if (i6 == 1342177280) {
                    byteOrderOrder = byteBuffer.order();
                    byteOrder = ByteOrder.BIG_ENDIAN;
                    if (byteOrderOrder == byteOrder) {
                        i = byteDepth;
                    } else {
                        i = byteDepth + 2;
                    }
                    byte b5 = byteBuffer.get(i);
                    byte b6 = byteBuffer.get(byteDepth + 1);
                    if (byteBuffer.order() == byteOrder) {
                        byteDepth += 2;
                    }
                    i2 = ((((b5 << 24) & (-16777216)) | ((b6 << 16) & 16711680)) | ((byteBuffer.get(byteDepth) << 8) & 65280)) >> 8;
                    if ((i2 & (-16777216)) != 0) {
                        z = true;
                    } else {
                        z = true;
                    }
                    UtilsKt.checkArgument(z, "Value out of range of 24-bit integer: %s", Integer.toHexString(i2));
                    UtilsKt.checkArgument(byteBufferReplaceOutputBuffer.remaining() >= 3);
                    if (byteBufferReplaceOutputBuffer.order() == byteOrder) {
                        i3 = (i2 & 16711680) >> 16;
                    } else {
                        i3 = i2 & 255;
                    }
                    byte b7 = (byte) i3;
                    byte b8 = (byte) ((i2 & 65280) >> 8);
                    if (byteBufferReplaceOutputBuffer.order() == byteOrder) {
                        i4 = i2 & 255;
                    } else {
                        i4 = (i2 & 16711680) >> 16;
                    }
                    byteBufferReplaceOutputBuffer.put(b7).put(b8).put((byte) i4);
                } else if (i6 == 1610612736) {
                    byteBufferReplaceOutputBuffer.putInt(byteBuffer.getInt(byteDepth));
                } else {
                    if (i6 != 1879048192) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$3(this.inputAudioFormat.encoding, "Unexpected encoding: ");
                        return;
                    }
                    byteBufferReplaceOutputBuffer.putDouble(byteBuffer.getDouble(byteDepth));
                }
            }
            iPosition += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer.position(iLimit);
        byteBufferReplaceOutputBuffer.flip();
    }
}
