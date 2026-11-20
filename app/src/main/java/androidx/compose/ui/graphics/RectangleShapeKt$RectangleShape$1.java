package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.math.IntMath;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RectangleShapeKt$RectangleShape$1 implements Shape {
    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public final ColorKt mo56createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        return new Outline$Rectangle(IntMath.m896Recttz77jQw(0L, j));
    }

    public final String toString() {
        return "RectangleShape";
    }
}
