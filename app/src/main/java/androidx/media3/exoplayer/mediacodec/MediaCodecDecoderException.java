package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import androidx.media3.decoder.DecoderException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class MediaCodecDecoderException extends DecoderException {
    public final int errorCode;

    public MediaCodecDecoderException(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        StringBuilder sb = new StringBuilder("Decoder failed: ");
        sb.append(mediaCodecInfo == null ? null : mediaCodecInfo.name);
        super(sb.toString(), illegalStateException);
        boolean z = illegalStateException instanceof MediaCodec.CodecException;
        if (z) {
            ((MediaCodec.CodecException) illegalStateException).getDiagnosticInfo();
        }
        this.errorCode = z ? ((MediaCodec.CodecException) illegalStateException).getErrorCode() : 0;
    }
}
