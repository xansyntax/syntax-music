package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingValuesImpl implements PaddingValues {
    public final float bottom;
    public final float end;
    public final float start;
    public final float top;

    public PaddingValuesImpl(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        if (!((f >= CropImageView.DEFAULT_ASPECT_RATIO) & (f2 >= CropImageView.DEFAULT_ASPECT_RATIO) & (f3 >= CropImageView.DEFAULT_ASPECT_RATIO)) || !(f4 >= CropImageView.DEFAULT_ASPECT_RATIO)) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public final float mo122calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public final float mo123calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public final float mo124calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public final float mo125calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        return Dp.m796equalsimpl0(this.start, paddingValuesImpl.start) && Dp.m796equalsimpl0(this.top, paddingValuesImpl.top) && Dp.m796equalsimpl0(this.end, paddingValuesImpl.end) && Dp.m796equalsimpl0(this.bottom, paddingValuesImpl.bottom);
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + IntIntPair$$ExternalSyntheticOutline0.m(this.end, IntIntPair$$ExternalSyntheticOutline0.m(this.top, Float.hashCode(this.start) * 31, 31), 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(this.start);
        String strM797toStringimpl2 = Dp.m797toStringimpl(this.top);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("PaddingValues(start=", strM797toStringimpl, ", top=", strM797toStringimpl2, ", end="), Dp.m797toStringimpl(this.end), ", bottom=", Dp.m797toStringimpl(this.bottom), ")");
    }
}
