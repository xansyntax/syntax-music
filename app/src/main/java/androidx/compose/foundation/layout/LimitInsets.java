package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LimitInsets implements WindowInsets {
    public final WindowInsets insets;
    public final int sides;

    public LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && this.sides == limitInsets.sides;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        if ((this.sides & 32) != 0) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        if (((layoutDirection == LayoutDirection.Ltr ? 8 : 2) & this.sides) != 0) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        if (((layoutDirection == LayoutDirection.Ltr ? 4 : 1) & this.sides) != 0) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        if ((this.sides & 16) != 0) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public final int hashCode() {
        return Integer.hashCode(this.sides) + (this.insets.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.sides;
        if ((i & 9) == 9) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "Start");
        }
        if ((i & 10) == 10) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "Left");
        }
        if ((i & 16) == 16) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "Top");
        }
        if ((i & 6) == 6) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "End");
        }
        if ((i & 5) == 5) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "Right");
        }
        if ((i & 32) == 32) {
            OffsetKt.valueToString_impl$lambda$0$appendPlus(sb, "Bottom");
        }
        return "(" + this.insets + " only " + IntIntPair$$ExternalSyntheticOutline0.m("WindowInsetsSides(", sb.toString(), ")") + ")";
    }
}
