package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    public static final LocaleListCompat sEmptyLocaleList = new LocaleListCompat(new LocaleListPlatformWrapper(new LocaleList(new Locale[0])));
    public final LocaleListPlatformWrapper mImpl;

    public LocaleListCompat(LocaleListPlatformWrapper localeListPlatformWrapper) {
        this.mImpl = localeListPlatformWrapper;
    }

    public static LocaleListCompat forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return sEmptyLocaleList;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Locale.forLanguageTag(strArrSplit[i]);
        }
        return new LocaleListCompat(new LocaleListPlatformWrapper(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocaleListCompat) {
            return this.mImpl.equals(((LocaleListCompat) obj).mImpl);
        }
        return false;
    }

    public final int hashCode() {
        return this.mImpl.mLocaleList.hashCode();
    }

    public final String toString() {
        return this.mImpl.mLocaleList.toString();
    }
}
