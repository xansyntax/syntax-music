package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InsetsValues {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public InsetsValues(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsValues)) {
            return false;
        }
        InsetsValues insetsValues = (InsetsValues) obj;
        return this.left == insetsValues.left && this.top == insetsValues.top && this.right == insetsValues.right && this.bottom == insetsValues.bottom;
    }

    public final int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final String toString() {
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.left, "InsetsValues(left=", ", top=", this.top, ", right=");
        sbM3m.append(this.right);
        sbM3m.append(", bottom=");
        sbM3m.append(this.bottom);
        sbM3m.append(")");
        return sbM3m.toString();
    }
}
