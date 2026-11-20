package androidx.compose.foundation.shape;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PercentCornerSize implements CornerSize {
    public final float percent;

    public PercentCornerSize(float f) {
        this.percent = f;
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 100.0f) {
            InlineClassHelperKt.throwIllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PercentCornerSize) && Float.compare(this.percent, ((PercentCornerSize) obj).percent) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.percent);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public final float mo184toPxTmRCtEA(long j, Density density) {
        return (this.percent / 100.0f) * Size.m448getMinDimensionimpl(j);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("CornerSize(size = ", this.percent, "%)");
    }
}
