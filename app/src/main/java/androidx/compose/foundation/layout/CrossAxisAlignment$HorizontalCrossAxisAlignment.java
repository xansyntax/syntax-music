package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CrossAxisAlignment$HorizontalCrossAxisAlignment extends OffsetKt {
    public final Alignment.Horizontal horizontal;

    public CrossAxisAlignment$HorizontalCrossAxisAlignment(BiasAlignment.Horizontal horizontal) {
        this.horizontal = horizontal;
    }

    @Override // androidx.compose.foundation.layout.OffsetKt
    public final int align$foundation_layout(int i, int i2, LayoutDirection layoutDirection) {
        return this.horizontal.align(i2, i, layoutDirection);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CrossAxisAlignment$HorizontalCrossAxisAlignment) && Intrinsics.areEqual(this.horizontal, ((CrossAxisAlignment$HorizontalCrossAxisAlignment) obj).horizontal);
    }

    public final int hashCode() {
        return this.horizontal.hashCode();
    }

    public final String toString() {
        return "HorizontalCrossAxisAlignment(horizontal=" + this.horizontal + ")";
    }
}
