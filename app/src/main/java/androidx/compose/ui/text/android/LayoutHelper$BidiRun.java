package androidx.compose.ui.text.android;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutHelper$BidiRun {
    public final int end;
    public final boolean isRtl;
    public final int start;

    public LayoutHelper$BidiRun(int i, boolean z, int i2) {
        this.start = i;
        this.end = i2;
        this.isRtl = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutHelper$BidiRun)) {
            return false;
        }
        LayoutHelper$BidiRun layoutHelper$BidiRun = (LayoutHelper$BidiRun) obj;
        return this.start == layoutHelper$BidiRun.start && this.end == layoutHelper$BidiRun.end && this.isRtl == layoutHelper$BidiRun.isRtl;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isRtl) + IntIntPair$$ExternalSyntheticOutline0.m(this.end, Integer.hashCode(this.start) * 31, 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m3m(this.start, "BidiRun(start=", ", end=", this.end, ", isRtl="), this.isRtl, ")");
    }
}
