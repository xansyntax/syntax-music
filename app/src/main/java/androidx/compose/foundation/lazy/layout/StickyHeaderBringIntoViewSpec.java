package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StickyHeaderBringIntoViewSpec implements BringIntoViewSpec {
    public final BringIntoViewSpec bringIntoViewSpec;
    public final boolean isVertical;
    public final LayoutDirection layoutDirection;
    public final Function0 stickyItemsCombinedSizeLambda;

    public StickyHeaderBringIntoViewSpec(Function0 function0, LayoutDirection layoutDirection, boolean z, BringIntoViewSpec bringIntoViewSpec) {
        this.stickyItemsCombinedSizeLambda = function0;
        this.layoutDirection = layoutDirection;
        this.isVertical = z;
        this.bringIntoViewSpec = bringIntoViewSpec;
    }

    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final float calculateScrollDistance(float f, float f2, float f3) {
        float fIntValue = ((Number) this.stickyItemsCombinedSizeLambda.invoke()).intValue();
        boolean z = this.layoutDirection == LayoutDirection.Rtl;
        if (this.isVertical || !z) {
            f -= fIntValue;
        }
        return this.bringIntoViewSpec.calculateScrollDistance(f, f2, f3 - fIntValue);
    }
}
