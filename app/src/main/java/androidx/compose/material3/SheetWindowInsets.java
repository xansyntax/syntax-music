package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SheetWindowInsets implements WindowInsets {
    public final SheetState state;

    public SheetWindowInsets(SheetState sheetState) {
        this.state = sheetState;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SheetWindowInsets)) {
            return false;
        }
        return Intrinsics.areEqual(this.state, ((SheetWindowInsets) obj).state);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return 0;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        int i;
        float floatValue = ((ParcelableSnapshotMutableFloatState) this.state.anchoredDraggableState.head).getFloatValue();
        if (!Float.isNaN(floatValue) && (i = (int) floatValue) >= 0) {
            return i;
        }
        return 0;
    }

    public final int hashCode() {
        return this.state.hashCode();
    }
}
