package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.util.FileSystemsKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SweepGradient extends ShaderBrush {
    public final long center;
    public final List colors;
    public final List stops;

    public SweepGradient(long j, List list, List list2) {
        this.center = j;
        this.colors = list;
        this.stops = list2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo474createShaderuvyYCjk(long j) {
        long jFloatToRawIntBits;
        long j2 = this.center;
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            jFloatToRawIntBits = FileSystemsKt.m881getCenteruvyYCjk(j);
        } else {
            int i = (int) (j2 >> 32);
            if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
                i = (int) (j >> 32);
            }
            float fIntBitsToFloat = Float.intBitsToFloat(i);
            int i2 = (int) (j2 & 4294967295L);
            float fIntBitsToFloat2 = Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY ? Float.intBitsToFloat((int) (j & 4294967295L)) : Float.intBitsToFloat(i2);
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32);
        }
        List list = this.colors;
        List list2 = this.stops;
        ColorKt.validateColorStops(list, list2);
        if (Build.VERSION.SDK_INT >= 29) {
            return GradientColorLongVerifier.INSTANCE.m506createSweepGradientColorLong9KIMszo(jFloatToRawIntBits, ColorKt.toPlatformLongArray(list), list2 != null ? CollectionsKt.toFloatArray(list2) : null);
        }
        return new android.graphics.SweepGradient(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)), ColorKt.makeTransparentColors(list), ColorKt.makeTransparentStops(list2, list));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.m434equalsimpl0(this.center, sweepGradient.center) && this.colors.equals(sweepGradient.colors) && Intrinsics.areEqual(this.stops, sweepGradient.stops);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.center) * 31, 31, this.colors);
        List list = this.stops;
        return iM + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        long j = this.center;
        return "SweepGradient(" + ((9223372034707292159L & j) != 9205357640488583168L ? IntIntPair$$ExternalSyntheticOutline0.m("center=", Offset.m441toStringimpl(j), ", ") : "") + "colors=" + this.colors + ", stops=" + this.stops + ")";
    }
}
