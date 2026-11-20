package sh.calvin.reorderable;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class AbsolutePixelPadding {
    public final float bottom;
    public final float end;
    public final float start;
    public final float top;

    public AbsolutePixelPadding(float f, float f2, float f3, float f4) {
        this.start = f;
        this.end = f2;
        this.top = f3;
        this.bottom = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsolutePixelPadding)) {
            return false;
        }
        AbsolutePixelPadding absolutePixelPadding = (AbsolutePixelPadding) obj;
        return Float.compare(this.start, absolutePixelPadding.start) == 0 && Float.compare(this.end, absolutePixelPadding.end) == 0 && Float.compare(this.top, absolutePixelPadding.top) == 0 && Float.compare(this.bottom, absolutePixelPadding.bottom) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + IntIntPair$$ExternalSyntheticOutline0.m(this.top, IntIntPair$$ExternalSyntheticOutline0.m(this.end, Float.hashCode(this.start) * 31, 31), 31);
    }

    public final String toString() {
        return "AbsolutePixelPadding(start=" + this.start + ", end=" + this.end + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }
}
