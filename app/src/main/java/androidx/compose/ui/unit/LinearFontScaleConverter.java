package androidx.compose.ui.unit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinearFontScaleConverter implements FontScaleConverter {
    public final float fontScale;

    public LinearFontScaleConverter(float f) {
        this.fontScale = f;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertDpToSp(float f) {
        return f / this.fontScale;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final float convertSpToDp(float f) {
        return f * this.fontScale;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LinearFontScaleConverter) && Float.compare(this.fontScale, ((LinearFontScaleConverter) obj).fontScale) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.fontScale);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("LinearFontScaleConverter(fontScale=", this.fontScale, ")");
    }
}
