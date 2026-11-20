package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BorderStroke {
    public final Brush brush;
    public final float width;

    public BorderStroke(float f, Brush brush) {
        this.width = f;
        this.brush = brush;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return Dp.m796equalsimpl0(this.width, borderStroke.width) && Intrinsics.areEqual(this.brush, borderStroke.brush);
    }

    public final int hashCode() {
        return this.brush.hashCode() + (Float.hashCode(this.width) * 31);
    }

    public final String toString() {
        return "BorderStroke(width=" + Dp.m797toStringimpl(this.width) + ", brush=" + this.brush + ")";
    }
}
