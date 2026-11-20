package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BlurEffect extends RenderEffect {
    public final int edgeTreatment;
    public final float radiusX;
    public final float radiusY;

    public BlurEffect(float f, float f2, int i) {
        this.radiusX = f;
        this.radiusY = f2;
        this.edgeTreatment = i;
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    public final android.graphics.RenderEffect createRenderEffect() {
        return TileModeVerificationHelper.m518createBlurEffect8A3gB4(this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        return this.radiusX == blurEffect.radiusX && this.radiusY == blurEffect.radiusY && this.edgeTreatment == blurEffect.edgeTreatment;
    }

    public final int hashCode() {
        return Integer.hashCode(this.edgeTreatment) + IntIntPair$$ExternalSyntheticOutline0.m(this.radiusY, Float.hashCode(this.radiusX) * 31, 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("BlurEffect(renderEffect=null, radiusX=", this.radiusX, ", radiusY=", this.radiusY, ", edgeTreatment="), ColorKt.m502toStringimpl$1(this.edgeTreatment), ")");
    }
}
