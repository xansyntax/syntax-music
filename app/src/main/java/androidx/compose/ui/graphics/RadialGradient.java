package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import coil3.util.FileSystemsKt;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RadialGradient extends ShaderBrush {
    public final long center;
    public final List colors;
    public final float radius;
    public final List stops;

    public RadialGradient(List list, List list2, long j, float f) {
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo474createShaderuvyYCjk(long j) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        long j2 = this.center;
        if ((9223372034707292159L & j2) == 9205357640488583168L) {
            long jM881getCenteruvyYCjk = FileSystemsKt.m881getCenteruvyYCjk(j);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jM881getCenteruvyYCjk >> 32));
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM881getCenteruvyYCjk & 4294967295L));
        } else {
            int i = (int) (j2 >> 32);
            if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
                i = (int) (j >> 32);
            }
            fIntBitsToFloat = Float.intBitsToFloat(i);
            int i2 = (int) (j2 & 4294967295L);
            if (Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY) {
                i2 = (int) (j & 4294967295L);
            }
            fIntBitsToFloat2 = Float.intBitsToFloat(i2);
        }
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
        float fM448getMinDimensionimpl = this.radius;
        if (fM448getMinDimensionimpl == Float.POSITIVE_INFINITY) {
            fM448getMinDimensionimpl = Size.m448getMinDimensionimpl(j) / 2.0f;
        }
        float f = fM448getMinDimensionimpl;
        List list = this.colors;
        List list2 = this.stops;
        ColorKt.validateColorStops(list, list2);
        if (Build.VERSION.SDK_INT >= 29) {
            return GradientColorLongVerifier.INSTANCE.m505createRadialGradientColorLong8uybcMk(jFloatToRawIntBits, f, ColorKt.toPlatformLongArray(list), list2 != null ? CollectionsKt.toFloatArray(list2) : null, 0);
        }
        return new android.graphics.RadialGradient(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)), f, ColorKt.makeTransparentColors(list), ColorKt.makeTransparentStops(list2, list), ColorKt.m497toAndroidTileMode0vamqd0(0));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        return this.colors.equals(radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m434equalsimpl0(this.center, radialGradient.center) && this.radius == radialGradient.radius;
    }

    public final int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List list = this.stops;
        return Integer.hashCode(0) + IntIntPair$$ExternalSyntheticOutline0.m(this.radius, IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (list != null ? list.hashCode() : 0)) * 31, 31, this.center), 31);
    }

    public final String toString() {
        long j = this.center;
        String strM = (9223372034707292159L & j) != 9205357640488583168L ? IntIntPair$$ExternalSyntheticOutline0.m("center=", Offset.m441toStringimpl(j), ", ") : "";
        float f = this.radius;
        String strM2 = (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040 ? IntIntPair$$ExternalSyntheticOutline0.m("radius=", f, ", ") : "";
        String strM502toStringimpl$1 = ColorKt.m502toStringimpl$1(0);
        StringBuilder sb = new StringBuilder("RadialGradient(colors=");
        sb.append(this.colors);
        sb.append(", stops=");
        sb.append(this.stops);
        sb.append(", ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strM, strM2, "tileMode=", strM502toStringimpl$1);
        sb.append(")");
        return sb.toString();
    }
}
