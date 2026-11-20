package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;
import coil3.util.UtilsKt;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExoPlaybackException extends PlaybackException {
    public final boolean isRecoverable;
    public final MediaSource$MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final byte type;

    /* JADX WARN: Illegal instructions before constructor call */
    public ExoPlaybackException(int i, Exception exc, int i2, String str, int i3, Format format, int i4, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, boolean z) {
        String str2;
        int i5;
        Format format2;
        String string;
        String str3;
        if (i == 0) {
            str2 = str;
            i5 = i3;
            format2 = format;
            string = "Source error";
        } else if (i != 1) {
            string = i != 3 ? "Unexpected runtime error" : "Remote error";
            str2 = str;
            i5 = i3;
            format2 = format;
        } else {
            StringBuilder sb = new StringBuilder();
            str2 = str;
            sb.append(str2);
            sb.append(" error, index=");
            i5 = i3;
            sb.append(i5);
            sb.append(", format=");
            format2 = format;
            sb.append(format2);
            sb.append(", format_supported=");
            String str4 = Util.DEVICE_DEBUG_INFO;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_SUBTYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m();
                    throw null;
                }
                str3 = "YES";
            }
            sb.append(str3);
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : string.concat(": null"), exc, i2, i, str2, i5, format2, i4, mediaSource$MediaPeriodId, SystemClock.elapsedRealtime(), z);
    }

    public final ExoPlaybackException copyWithMediaPeriodId(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        String message = getMessage();
        String str = Util.DEVICE_DEBUG_INFO;
        return new ExoPlaybackException(message, getCause(), this.errorCode, this.type, this.rendererName, this.rendererIndex, this.rendererFormat, this.rendererFormatSupport, mediaSource$MediaPeriodId, this.timestampMs, this.isRecoverable);
    }

    @Override // androidx.media3.common.PlaybackException
    public final boolean errorInfoEquals(PlaybackException playbackException) {
        if (!super.errorInfoEquals(playbackException)) {
            return false;
        }
        String str = Util.DEVICE_DEBUG_INFO;
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
        return this.type == exoPlaybackException.type && Objects.equals(this.rendererName, exoPlaybackException.rendererName) && this.rendererIndex == exoPlaybackException.rendererIndex && Objects.equals(this.rendererFormat, exoPlaybackException.rendererFormat) && this.rendererFormatSupport == exoPlaybackException.rendererFormatSupport && Objects.equals(this.mediaPeriodId, exoPlaybackException.mediaPeriodId) && this.isRecoverable == exoPlaybackException.isRecoverable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExoPlaybackException(String str, Throwable th, int i, int i2, String str2, int i3, Format format, int i4, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long j, boolean z) {
        super(str, th, i, Bundle.EMPTY, j);
        UtilsKt.checkArgument(!z || i2 == 1);
        UtilsKt.checkArgument(th != null || i2 == 3);
        this.type = i2;
        this.rendererName = str2;
        this.rendererIndex = i3;
        this.rendererFormat = format;
        this.rendererFormatSupport = i4;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
        this.isRecoverable = z;
    }

    public ExoPlaybackException(int i, Exception exc, int i2) {
        this(i, exc, i2, null, -1, null, 4, null, false);
    }
}
