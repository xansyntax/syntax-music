package androidx.compose.ui.unit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntRect {
    public static final IntRect Zero = new IntRect(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public IntRect(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) obj;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    /* JADX INFO: renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m808getCenternOccac() {
        return (((long) ((getHeight() / 2) + this.top)) & 4294967295L) | (((long) ((getWidth() / 2) + this.left)) << 32);
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    /* JADX INFO: renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m809getTopLeftnOccac() {
        return (((long) this.left) << 32) | (((long) this.top) & 4294967295L);
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public final int hashCode() {
        return Integer.hashCode(this.bottom) + IntIntPair$$ExternalSyntheticOutline0.m(this.right, IntIntPair$$ExternalSyntheticOutline0.m(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.left, "IntRect.fromLTRB(", ", ", this.top, ", ");
        sbM3m.append(this.right);
        sbM3m.append(", ");
        sbM3m.append(this.bottom);
        sbM3m.append(")");
        return sbM3m.toString();
    }
}
