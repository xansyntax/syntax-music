package androidx.compose.foundation.shape;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PxCornerSize implements CornerSize {
    public final float size;

    public PxCornerSize(float f) {
        this.size = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PxCornerSize) && Float.compare(this.size, ((PxCornerSize) obj).size) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public final float mo184toPxTmRCtEA(long j, Density density) {
        return this.size;
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("CornerSize(size = ", this.size, ".px)");
    }
}
