package androidx.core.content.res;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FontResourcesParserCompat$ProviderResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {
    public final ArrayList mRequests;
    public final int mStrategy;
    public final String mSystemFontFamilyName;
    public final int mTimeoutMs;

    public FontResourcesParserCompat$ProviderResourceEntry(ArrayList arrayList, int i, int i2, String str) {
        this.mRequests = arrayList;
        this.mStrategy = i;
        this.mTimeoutMs = i2;
        this.mSystemFontFamilyName = str;
    }
}
