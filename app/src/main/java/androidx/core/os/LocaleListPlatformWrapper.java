package androidx.core.os;

import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleListPlatformWrapper {
    public final LocaleList mLocaleList;

    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public final boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListPlatformWrapper) obj).mLocaleList);
    }

    public final int hashCode() {
        return this.mLocaleList.hashCode();
    }

    public final String toString() {
        return this.mLocaleList.toString();
    }
}
