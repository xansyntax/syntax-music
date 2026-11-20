package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GridCells$Fixed {
    public final int count;

    public GridCells$Fixed(int i) {
        this.count = i;
        if (i > 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Provided count should be larger than zero");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GridCells$Fixed) {
            return this.count == ((GridCells$Fixed) obj).count;
        }
        return false;
    }

    public final int hashCode() {
        return -this.count;
    }
}
