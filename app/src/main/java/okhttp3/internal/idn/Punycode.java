package okhttp3.internal.idn;

import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.ByteString;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Punycode {
    public static final ByteString PREFIX;

    static {
        ByteString byteString = ByteString.EMPTY;
        PREFIX = Path.Companion.encodeUtf8("xn--");
    }

    public static int adapt(int i, boolean z, int i2) {
        int i3 = z ? i / 700 : i / 2;
        int i4 = (i3 / i2) + i3;
        int i5 = 0;
        while (i4 > 455) {
            i4 /= 35;
            i5 += 36;
        }
        return ((i4 * 36) / (i4 + 38)) + i5;
    }

    public static int getPunycodeDigit(int i) {
        if (i < 26) {
            return i + 97;
        }
        if (i < 36) {
            return i + 22;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(i, "unexpected digit: ");
        return 0;
    }
}
