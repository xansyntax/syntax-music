package androidx.compose.ui;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.LayoutDirection;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BiasAbsoluteAlignment implements Alignment {
    public final float horizontalBias;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Horizontal implements Alignment.Horizontal {
        public final float bias;

        public Horizontal(float f) {
            this.bias = f;
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public final int align(int i, int i2, LayoutDirection layoutDirection) {
            return Math.round((1.0f + this.bias) * ((i2 - i) / 2.0f));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Horizontal) && Float.compare(this.bias, ((Horizontal) obj).bias) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(this.bias);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("Horizontal(bias=", this.bias, ")");
        }
    }

    public BiasAbsoluteAlignment(float f) {
        this.horizontalBias = f;
    }

    @Override // androidx.compose.ui.Alignment
    /* JADX INFO: renamed from: align-KFBX0sM */
    public final long mo397alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection) {
        long j3 = (((long) (((int) (j2 >> 32)) - ((int) (j >> 32)))) << 32) | (((long) (((int) (j2 & 4294967295L)) - ((int) (j & 4294967295L)))) & 4294967295L);
        return (((long) Math.round((1.0f + this.horizontalBias) * (((int) (j3 >> 32)) / 2.0f))) << 32) | (((long) Math.round(CropImageView.DEFAULT_ASPECT_RATIO * (((int) (j3 & 4294967295L)) / 2.0f))) & 4294967295L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BiasAbsoluteAlignment) && Float.compare(this.horizontalBias, ((BiasAbsoluteAlignment) obj).horizontalBias) == 0 && Float.compare(-1.0f, -1.0f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(-1.0f) + (Float.hashCode(this.horizontalBias) * 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("BiasAbsoluteAlignment(horizontalBias=", this.horizontalBias, ", verticalBias=-1.0)");
    }
}
