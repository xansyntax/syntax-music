package androidx.compose.material3.carousel;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Keyline {
    public final float cutoff;
    public final boolean isAnchor;
    public final boolean isFocal;
    public final boolean isPivot;
    public final float offset;
    public final float size;
    public final float unadjustedOffset;

    public Keyline(float f, float f2, float f3, boolean z, boolean z2, boolean z3, float f4) {
        this.size = f;
        this.offset = f2;
        this.unadjustedOffset = f3;
        this.isFocal = z;
        this.isAnchor = z2;
        this.isPivot = z3;
        this.cutoff = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Keyline)) {
            return false;
        }
        Keyline keyline = (Keyline) obj;
        return Float.compare(this.size, keyline.size) == 0 && Float.compare(this.offset, keyline.offset) == 0 && Float.compare(this.unadjustedOffset, keyline.unadjustedOffset) == 0 && this.isFocal == keyline.isFocal && this.isAnchor == keyline.isAnchor && this.isPivot == keyline.isPivot && Float.compare(this.cutoff, keyline.cutoff) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.cutoff) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.unadjustedOffset, IntIntPair$$ExternalSyntheticOutline0.m(this.offset, Float.hashCode(this.size) * 31, 31), 31), this.isFocal, 31), this.isAnchor, 31), this.isPivot, 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Keyline(size=", this.size, ", offset=", this.offset, ", unadjustedOffset=");
        sbM.append(this.unadjustedOffset);
        sbM.append(", isFocal=");
        sbM.append(this.isFocal);
        sbM.append(", isAnchor=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.isAnchor, ", isPivot=", this.isPivot, ", cutoff=");
        sbM.append(this.cutoff);
        sbM.append(")");
        return sbM.toString();
    }
}
