package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedIntInsets implements WindowInsets {
    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof FixedIntInsets);
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
        return 0;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "Insets(left=0, top=0, right=0, bottom=0)";
    }
}
