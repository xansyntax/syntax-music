package androidx.compose.ui.node;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DpTouchBoundsExpansion {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DpTouchBoundsExpansion) && Dp.m796equalsimpl0(10.0f, 10.0f) && Dp.m796equalsimpl0(40.0f, 40.0f) && Dp.m796equalsimpl0(10.0f, 10.0f) && Dp.m796equalsimpl0(40.0f, 40.0f);
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + IntIntPair$$ExternalSyntheticOutline0.m(40.0f, IntIntPair$$ExternalSyntheticOutline0.m(10.0f, IntIntPair$$ExternalSyntheticOutline0.m(40.0f, Float.hashCode(10.0f) * 31, 31), 31), 31);
    }

    public final String toString() {
        String strM797toStringimpl = Dp.m797toStringimpl(10.0f);
        String strM797toStringimpl2 = Dp.m797toStringimpl(40.0f);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("DpTouchBoundsExpansion(start=", strM797toStringimpl, ", top=", strM797toStringimpl2, ", end="), Dp.m797toStringimpl(10.0f), ", bottom=", Dp.m797toStringimpl(40.0f), ", isLayoutDirectionAware=true)");
    }
}
