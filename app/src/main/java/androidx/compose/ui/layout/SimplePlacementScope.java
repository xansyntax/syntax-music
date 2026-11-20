package androidx.compose.ui.layout;

import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SimplePlacementScope extends Placeable.PlacementScope {
    public final float density;
    public final float fontScale;
    public final LayoutDirection parentLayoutDirection;
    public final int parentWidth;

    public SimplePlacementScope(int i, LayoutDirection layoutDirection, float f, float f2) {
        this.parentWidth = i;
        this.parentLayoutDirection = layoutDirection;
        this.density = f;
        this.fontScale = f2;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.fontScale;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    @Override // androidx.compose.ui.layout.Placeable.PlacementScope
    public final int getParentWidth() {
        return this.parentWidth;
    }
}
