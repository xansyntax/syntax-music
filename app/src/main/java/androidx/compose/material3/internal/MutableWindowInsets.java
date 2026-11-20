package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableWindowInsets implements WindowInsets {
    public final ParcelableSnapshotMutableState insets$delegate;

    public MutableWindowInsets(WindowInsets windowInsets) {
        this.insets$delegate = Stack.mutableStateOf$default(windowInsets);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return ((WindowInsets) this.insets$delegate.getValue()).getBottom(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return ((WindowInsets) this.insets$delegate.getValue()).getLeft(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return ((WindowInsets) this.insets$delegate.getValue()).getRight(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        return ((WindowInsets) this.insets$delegate.getValue()).getTop(density);
    }
}
