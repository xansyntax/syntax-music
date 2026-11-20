package com.metrolist.music.playback.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.uuid.UuidKt;
import okhttp3.ConnectionPool;
import timber.log.Timber;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class VolumeNormalizationAudioProcessor extends BaseAudioProcessor {
    public int bytesPerSample;
    public volatile GainState currentGain;
    public volatile boolean enabled;
    public int encoding;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class GainState {
        public final double linearGain;
        public final int targetGainMb;

        public GainState(int i, double d) {
            this.targetGainMb = i;
            this.linearGain = d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GainState)) {
                return false;
            }
            GainState gainState = (GainState) obj;
            return this.targetGainMb == gainState.targetGainMb && Double.compare(this.linearGain, gainState.linearGain) == 0;
        }

        public final int hashCode() {
            return Double.hashCode(this.linearGain) + (Integer.hashCode(this.targetGainMb) * 31);
        }

        public final String toString() {
            return "GainState(targetGainMb=" + this.targetGainMb + ", linearGain=" + this.linearGain + ")";
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i = audioFormat.encoding;
        this.encoding = i;
        int i2 = 2;
        if (i != 2) {
            i2 = 4;
            if (i != 4) {
                if (i == 21) {
                    i2 = 3;
                } else if (i != 22) {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
            }
        }
        this.bytesPerSample = i2;
        Timber.Forest.tag("VolumeNormalizationProcessor");
        ConnectionPool.d(new Object[0]);
        return audioFormat;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public final void onReset() {
        this.encoding = 0;
        this.bytesPerSample = 0;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            GainState gainState = this.currentGain;
            int i = 0;
            boolean z = this.enabled && gainState.targetGainMb != 0;
            int iRemaining = byteBuffer.remaining();
            int i2 = this.bytesPerSample;
            int i3 = iRemaining / i2;
            ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(i2 * i3);
            byteBufferReplaceOutputBuffer.getClass();
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBuffer.order(byteOrder);
            byteBufferReplaceOutputBuffer.order(byteOrder);
            int i4 = this.encoding;
            if (i4 == 2) {
                while (i < i3) {
                    short sCoerceIn = byteBuffer.getShort();
                    if (z) {
                        sCoerceIn = (short) UuidKt.coerceIn(((double) sCoerceIn) * gainState.linearGain, -32768.0d, 32767.0d);
                    }
                    byteBufferReplaceOutputBuffer.putShort(sCoerceIn);
                    i++;
                }
            } else if (i4 == 4) {
                while (i < i3) {
                    float fCoerceIn = byteBuffer.getFloat();
                    if (z) {
                        fCoerceIn = UuidKt.coerceIn(fCoerceIn * ((float) gainState.linearGain), -1.0f, 1.0f);
                    }
                    byteBufferReplaceOutputBuffer.putFloat(fCoerceIn);
                    i++;
                }
            } else if (i4 == 21) {
                while (i < i3) {
                    int iCoerceIn = (byteBuffer.get() & 255) | ((byteBuffer.get() & 255) << 8) | (byteBuffer.get() << 16);
                    if (z) {
                        iCoerceIn = (int) UuidKt.coerceIn(((double) iCoerceIn) * gainState.linearGain, -8388608.0d, 8388607.0d);
                    }
                    byteBufferReplaceOutputBuffer.put((byte) (iCoerceIn & 255));
                    byteBufferReplaceOutputBuffer.put((byte) ((iCoerceIn >> 8) & 255));
                    byteBufferReplaceOutputBuffer.put((byte) ((iCoerceIn >> 16) & 255));
                    i++;
                }
            } else if (i4 == 22) {
                while (i < i3) {
                    int iCoerceIn2 = byteBuffer.getInt();
                    if (z) {
                        iCoerceIn2 = (int) UuidKt.coerceIn(((double) iCoerceIn2) * gainState.linearGain, -2.147483648E9d, 2.147483647E9d);
                    }
                    byteBufferReplaceOutputBuffer.putInt(iCoerceIn2);
                    i++;
                }
            }
            byteBufferReplaceOutputBuffer.flip();
        }
    }

    public final void setEnabled(boolean z) {
        if (this.enabled != z) {
            this.enabled = z;
            Timber.Forest.tag("VolumeNormalizationProcessor");
            ConnectionPool.d(new Object[0]);
        }
    }

    public final synchronized void setTargetGain(int i) {
        if (this.currentGain.targetGainMb != i) {
            this.currentGain = new GainState(i, Math.pow(10.0d, ((double) i) / 2000.0d));
            Timber.Forest.tag("VolumeNormalizationProcessor");
            ConnectionPool.d(new Object[0]);
        }
    }
}
