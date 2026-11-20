package androidx.compose.ui.text.style;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LineBreak {
    public static final int Simple = 66305;
    public final int mask;

    public /* synthetic */ LineBreak(int i) {
        this.mask = i;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m770toStringimpl(int i) {
        String str;
        String str2;
        int i2 = i & 255;
        String str3 = "Invalid";
        if (i2 == 1) {
            str = "Strategy.Simple";
        } else if (i2 == 2) {
            str = "Strategy.HighQuality";
        } else if (i2 == 3) {
            str = "Strategy.Balanced";
        } else {
            str = i2 == 0 ? "Strategy.Unspecified" : "Invalid";
        }
        int i3 = (i >> 8) & 255;
        if (i3 == 1) {
            str2 = "Strictness.None";
        } else if (i3 == 2) {
            str2 = "Strictness.Loose";
        } else if (i3 == 3) {
            str2 = "Strictness.Normal";
        } else if (i3 == 4) {
            str2 = "Strictness.Strict";
        } else {
            str2 = i3 == 0 ? "Strictness.Unspecified" : "Invalid";
        }
        int i4 = (i >> 16) & 255;
        if (i4 == 1) {
            str3 = "WordBreak.None";
        } else if (i4 == 2) {
            str3 = "WordBreak.Phrase";
        } else if (i4 == 0) {
            str3 = "WordBreak.Unspecified";
        }
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("LineBreak(strategy=", str, ", strictness=", str2, ", wordBreak="), str3, ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LineBreak) {
            return this.mask == ((LineBreak) obj).mask;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.mask);
    }

    public final String toString() {
        return m770toStringimpl(this.mask);
    }
}
