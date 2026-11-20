package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AddedInsets implements WindowInsets {
    public final WindowInsets first;
    public final WindowInsets second;

    public AddedInsets(WindowInsets windowInsets, WindowInsets windowInsets2) {
        this.first = windowInsets;
        this.second = windowInsets2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddedInsets)) {
            return false;
        }
        AddedInsets addedInsets = (AddedInsets) obj;
        return Intrinsics.areEqual(addedInsets.first, this.first) && addedInsets.second.equals(this.second);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getBottom(Density density) {
        return this.second.getBottom(density) + this.first.getBottom(density);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getLeft(Density density, LayoutDirection layoutDirection) {
        return this.second.getLeft(density, layoutDirection) + this.first.getLeft(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getRight(Density density, LayoutDirection layoutDirection) {
        return this.second.getRight(density, layoutDirection) + this.first.getRight(density, layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public final int getTop(Density density) {
        return this.second.getTop(density) + this.first.getTop(density);
    }

    public final int hashCode() {
        return (this.second.hashCode() * 31) + this.first.hashCode();
    }

    public final String toString() {
        return "(" + this.first + " + " + this.second + ")";
    }
}
