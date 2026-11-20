package androidx.media3.exoplayer;

import android.text.TextUtils;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.Format;
import coil3.util.UtilsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DecoderReuseEvaluation {
    public final String decoderName;
    public final int discardReasons;
    public final Format newFormat;
    public final Format oldFormat;
    public final int result;

    public DecoderReuseEvaluation(String str, Format format, Format format2, int i, int i2) {
        UtilsKt.checkArgument(i == 0 || i2 == 0);
        UtilsKt.checkArgument(true ^ TextUtils.isEmpty(str));
        this.decoderName = str;
        format.getClass();
        this.oldFormat = format;
        format2.getClass();
        this.newFormat = format2;
        this.result = i;
        this.discardReasons = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DecoderReuseEvaluation.class == obj.getClass()) {
            DecoderReuseEvaluation decoderReuseEvaluation = (DecoderReuseEvaluation) obj;
            if (this.result == decoderReuseEvaluation.result && this.discardReasons == decoderReuseEvaluation.discardReasons && this.decoderName.equals(decoderReuseEvaluation.decoderName) && this.oldFormat.equals(decoderReuseEvaluation.oldFormat) && this.newFormat.equals(decoderReuseEvaluation.newFormat)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.newFormat.hashCode() + ((this.oldFormat.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((((527 + this.result) * 31) + this.discardReasons) * 31, 31, this.decoderName)) * 31);
    }
}
