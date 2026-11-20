package androidx.compose.ui.text.style;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ColorStyle implements TextForegroundStyle {
    public final long value;

    public ColorStyle(long j) {
        this.value = j;
        if (j != 16) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && ULong.m1869equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final float getAlpha() {
        return Color.m481getAlphaimpl(this.value);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final Brush getBrush() {
        return null;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* JADX INFO: renamed from: getColor-0d7_KjU */
    public final long mo768getColor0d7_KjU() {
        return this.value;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("ColorStyle(value=", Color.m486toStringimpl(this.value), ")");
    }
}
