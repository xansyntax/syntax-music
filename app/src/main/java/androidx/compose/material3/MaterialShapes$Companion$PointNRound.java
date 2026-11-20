package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.graphics.shapes.CornerRounding;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialShapes$Companion$PointNRound {
    public final long o;
    public final CornerRounding r;

    public MaterialShapes$Companion$PointNRound(long j, CornerRounding cornerRounding) {
        this.o = j;
        this.r = cornerRounding;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaterialShapes$Companion$PointNRound) {
            MaterialShapes$Companion$PointNRound materialShapes$Companion$PointNRound = (MaterialShapes$Companion$PointNRound) obj;
            return Offset.m434equalsimpl0(this.o, materialShapes$Companion$PointNRound.o) && this.r == materialShapes$Companion$PointNRound.r;
        }
        return false;
    }

    public final int hashCode() {
        return this.r.hashCode() + (Long.hashCode(this.o) * 31);
    }

    public final String toString() {
        return "PointNRound(o=" + Offset.m441toStringimpl(this.o) + ", r=" + this.r + ")";
    }
}
