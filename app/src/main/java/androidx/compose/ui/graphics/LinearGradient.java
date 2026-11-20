package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush {
    public final List colors;
    public final long end;
    public final long start;
    public final List stops;

    public LinearGradient(long j, long j2, List list, List list2) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo474createShaderuvyYCjk(long j) {
        long j2 = this.start;
        int i = (int) (j2 >> 32);
        if (Float.intBitsToFloat(i) == Float.POSITIVE_INFINITY) {
            i = (int) (j >> 32);
        }
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        int i2 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i2) == Float.POSITIVE_INFINITY) {
            i2 = (int) (j & 4294967295L);
        }
        float fIntBitsToFloat2 = Float.intBitsToFloat(i2);
        long j3 = this.end;
        int i3 = (int) (j3 >> 32);
        if (Float.intBitsToFloat(i3) == Float.POSITIVE_INFINITY) {
            i3 = (int) (j >> 32);
        }
        float fIntBitsToFloat3 = Float.intBitsToFloat(i3);
        int i4 = (int) (j3 & 4294967295L);
        if (Float.intBitsToFloat(i4) == Float.POSITIVE_INFINITY) {
            i4 = (int) (j & 4294967295L);
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat(i4);
        return ColorKt.m487ActualLinearGradientShaderVjE6UOU((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & 4294967295L), this.colors, this.stops);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return this.colors.equals(linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m434equalsimpl0(this.start, linearGradient.start) && Offset.m434equalsimpl0(this.end, linearGradient.end);
    }

    public final int hashCode() {
        int iHashCode = this.colors.hashCode() * 31;
        List list = this.stops;
        return Integer.hashCode(0) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iHashCode + (list != null ? list.hashCode() : 0)) * 31, 31, this.start), 31, this.end);
    }

    public final String toString() {
        long j = this.start;
        String strM = ((((j & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0 ? IntIntPair$$ExternalSyntheticOutline0.m("start=", Offset.m441toStringimpl(j), ", ") : "";
        long j2 = this.end;
        String strM2 = ((((j2 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0 ? IntIntPair$$ExternalSyntheticOutline0.m("end=", Offset.m441toStringimpl(j2), ", ") : "";
        String strM502toStringimpl$1 = ColorKt.m502toStringimpl$1(0);
        StringBuilder sb = new StringBuilder("LinearGradient(colors=");
        sb.append(this.colors);
        sb.append(", stops=");
        sb.append(this.stops);
        sb.append(", ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, strM, strM2, "tileMode=", strM502toStringimpl$1);
        sb.append(")");
        return sb.toString();
    }
}
