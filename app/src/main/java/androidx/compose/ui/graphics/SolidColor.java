package androidx.compose.ui.graphics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SolidColor extends Brush {
    public final long value;

    public SolidColor(long j) {
        this.value = j;
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo473applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        androidPaint.setAlpha(1.0f);
        long jColor = this.value;
        if (f != 1.0f) {
            jColor = ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), Color.m481getAlphaimpl(jColor) * f, Color.m483getColorSpaceimpl(jColor));
        }
        androidPaint.m464setColor8_81llA(jColor);
        if (androidPaint.internalShader != null) {
            androidPaint.setShader(null);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SolidColor) {
            return ULong.m1869equalsimpl0(this.value, ((SolidColor) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("SolidColor(value=", Color.m486toStringimpl(this.value), ")");
    }
}
