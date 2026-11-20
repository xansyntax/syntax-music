package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InsetsPaddingValues implements PaddingValues {
    public final Density density;
    public final WindowInsets insets;

    public InsetsPaddingValues(WindowInsets windowInsets, Density density) {
        this.insets = windowInsets;
        this.density = density;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public final float mo122calculateBottomPaddingD9Ej5fM() {
        WindowInsets windowInsets = this.insets;
        Density density = this.density;
        return density.mo78toDpu2uoSUM(windowInsets.getBottom(density));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public final float mo123calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        WindowInsets windowInsets = this.insets;
        Density density = this.density;
        return density.mo78toDpu2uoSUM(windowInsets.getLeft(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public final float mo124calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        WindowInsets windowInsets = this.insets;
        Density density = this.density;
        return density.mo78toDpu2uoSUM(windowInsets.getRight(density, layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public final float mo125calculateTopPaddingD9Ej5fM() {
        WindowInsets windowInsets = this.insets;
        Density density = this.density;
        return density.mo78toDpu2uoSUM(windowInsets.getTop(density));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingValues)) {
            return false;
        }
        InsetsPaddingValues insetsPaddingValues = (InsetsPaddingValues) obj;
        return Intrinsics.areEqual(this.insets, insetsPaddingValues.insets) && Intrinsics.areEqual(this.density, insetsPaddingValues.density);
    }

    public final int hashCode() {
        return this.density.hashCode() + (this.insets.hashCode() * 31);
    }

    public final String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ")";
    }
}
