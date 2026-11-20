package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GridCells$Adaptive {
    public final float minSize;

    public GridCells$Adaptive(float f) {
        this.minSize = f;
        if (Dp.m795compareTo0680j_4(f, CropImageView.DEFAULT_ASPECT_RATIO) > 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Provided min size should be larger than zero.");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GridCells$Adaptive) {
            return Dp.m796equalsimpl0(this.minSize, ((GridCells$Adaptive) obj).minSize);
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.minSize);
    }
}
