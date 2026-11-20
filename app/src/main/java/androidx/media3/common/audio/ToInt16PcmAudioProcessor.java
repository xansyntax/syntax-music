package androidx.media3.common.audio;

import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ToInt16PcmAudioProcessor extends BaseAudioProcessor {
    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    @Override // androidx.media3.common.audio.AudioProcessor
    public final void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int i2 = this.inputAudioFormat.encoding;
        if (i2 == 3) {
            i *= 2;
        } else if (i2 == 4) {
            i /= 2;
        } else {
            if (i2 != 21) {
                if (i2 == 22) {
                    i /= 2;
                } else if (i2 != 268435456) {
                    if (i2 != 1342177280) {
                        if (i2 == 1610612736) {
                            i /= 2;
                        } else {
                            if (i2 != 1879048192) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                                return;
                            }
                            i /= 4;
                        }
                    }
                }
            }
            i /= 3;
            i *= 2;
        }
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(i);
        int i3 = this.inputAudioFormat.encoding;
        if (i3 == 3) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put((byte) 0);
                byteBufferReplaceOutputBuffer.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                iPosition++;
            }
        } else if (i3 == 4) {
            while (iPosition < iLimit) {
                short sConstrainValue = (short) (Util.constrainValue(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                byteBufferReplaceOutputBuffer.put((byte) (sConstrainValue & 255));
                byteBufferReplaceOutputBuffer.put((byte) ((sConstrainValue >> 8) & 255));
                iPosition += 4;
            }
        } else if (i3 == 21) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 2));
                iPosition += 3;
            }
        } else if (i3 == 22) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 2));
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 3));
                iPosition += 4;
            }
        } else if (i3 == 268435456) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition));
                iPosition += 2;
            }
        } else if (i3 == 1342177280) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition));
                iPosition += 3;
            }
        } else if (i3 == 1610612736) {
            while (iPosition < iLimit) {
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition));
                iPosition += 4;
            }
        } else {
            if (i3 != 1879048192) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m();
                return;
            }
            while (iPosition < iLimit) {
                short sMax = (short) (Math.max(-1.0d, Math.min(byteBuffer.getDouble(iPosition), 1.0d)) * 32767.0d);
                byteBufferReplaceOutputBuffer.put((byte) (sMax & 255));
                byteBufferReplaceOutputBuffer.put((byte) ((sMax >> 8) & 255));
                iPosition += 8;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferReplaceOutputBuffer.flip();
    }
}
