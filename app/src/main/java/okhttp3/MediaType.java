package okhttp3;

import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class MediaType {
    public final String mediaType;
    public final String[] parameterNamesAndValues;
    public static final Regex TYPE_SUBTYPE = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Regex PARAMETER = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public MediaType(String str, String str2, String str3, String[] strArr) {
        str.getClass();
        strArr.getClass();
        this.mediaType = str;
        this.parameterNamesAndValues = strArr;
    }

    public static Charset charset$default(MediaType mediaType) {
        String str;
        String[] strArr = mediaType.parameterNamesAndValues;
        int i = 0;
        int progressionLastElement = UuidKt.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement < 0) {
            str = null;
            break;
        }
        while (true) {
            if (!StringsKt__StringsJVMKt.equals(strArr[i], HttpAuthHeader.Parameters.Charset, true)) {
                if (i == progressionLastElement) {
                    str = null;
                    break;
                }
                i += 2;
            } else {
                str = strArr[i + 1];
                break;
            }
        }
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public final int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String toString() {
        return this.mediaType;
    }
}
