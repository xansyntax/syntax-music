package okhttp3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.DateFormattingKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Cookie {
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final String sameSite;
    public final boolean secure;
    public final String value;
    public static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
        this.sameSite = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.expiresAt == this.expiresAt && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && Intrinsics.areEqual(cookie.sameSite, this.sameSite);
    }

    public final int hashCode() {
        int iM = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.name), 31, this.value), 31, this.expiresAt), 31, this.domain), 31, this.path), this.secure, 31), this.httpOnly, 31), this.persistent, 31), this.hostOnly, 31);
        String str = this.sameSite;
        return iM + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            long j = this.expiresAt;
            if (j == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) DateFormattingKt.STANDARD_DATE_FORMAT.get()).format(new Date(j));
                str.getClass();
                sb.append(str);
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String str2 = this.sameSite;
        if (str2 != null) {
            sb.append("; samesite=");
            sb.append(str2);
        }
        return sb.toString();
    }
}
