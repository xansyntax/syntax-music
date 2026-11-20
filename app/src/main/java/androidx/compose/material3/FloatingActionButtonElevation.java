package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Dp;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingActionButtonElevation {
    public final float defaultElevation;
    public final float focusedElevation;
    public final float hoveredElevation;
    public final float pressedElevation;

    public FloatingActionButtonElevation(float f, float f2, float f3, float f4) {
        this.defaultElevation = f;
        this.pressedElevation = f2;
        this.focusedElevation = f3;
        this.hoveredElevation = f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FloatingActionButtonElevation)) {
            return false;
        }
        FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) obj;
        if (Dp.m796equalsimpl0(this.defaultElevation, floatingActionButtonElevation.defaultElevation) && Dp.m796equalsimpl0(this.pressedElevation, floatingActionButtonElevation.pressedElevation) && Dp.m796equalsimpl0(this.focusedElevation, floatingActionButtonElevation.focusedElevation)) {
            return Dp.m796equalsimpl0(this.hoveredElevation, floatingActionButtonElevation.hoveredElevation);
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.hoveredElevation) + IntIntPair$$ExternalSyntheticOutline0.m(this.focusedElevation, IntIntPair$$ExternalSyntheticOutline0.m(this.pressedElevation, Float.hashCode(this.defaultElevation) * 31, 31), 31);
    }
}
