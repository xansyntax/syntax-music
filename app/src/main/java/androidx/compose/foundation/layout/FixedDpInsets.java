package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedDpInsets implements WindowInsets {
    public final float bottomDp;
    public final float leftDp;
    public final float topDp;

    public FixedDpInsets(float f, float f2, float f3) {
        this.leftDp = f;
        this.topDp = f2;
        this.bottomDp = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.m796equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m796equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m796equalsimpl0(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) && Dp.m796equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return density.mo75roundToPx0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return density.mo75roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return density.mo75roundToPx0680j_4(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        return density.mo75roundToPx0680j_4(this.topDp);
    }

    public final int hashCode() {
        return Float.hashCode(this.bottomDp) + IntIntPair$$ExternalSyntheticOutline0.m(CropImageView.DEFAULT_ASPECT_RATIO, IntIntPair$$ExternalSyntheticOutline0.m(this.topDp, Float.hashCode(this.leftDp) * 31, 31), 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.leftDp);
        String strM797toStringimpl2 = Dp.m797toStringimpl(this.topDp);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Insets(left=", strM797toStringimpl, ", top=", strM797toStringimpl2, ", right="), Dp.m797toStringimpl(CropImageView.DEFAULT_ASPECT_RATIO), ", bottom=", Dp.m797toStringimpl(this.bottomDp), ")");
    }
}
