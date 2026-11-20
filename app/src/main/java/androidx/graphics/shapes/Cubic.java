package androidx.graphics.shapes;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Cubic {
    public final float[] points;

    public Cubic(float[] fArr) {
        this.points = fArr;
        if (fArr.length == 8) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Points array size should be 8");
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cubic)) {
            return false;
        }
        return Arrays.equals(this.points, ((Cubic) obj).points);
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("anchor0: (");
        float[] fArr = this.points;
        sb.append(fArr[0]);
        sb.append(", ");
        sb.append(fArr[1]);
        sb.append(") control0: (");
        sb.append(fArr[2]);
        sb.append(", ");
        sb.append(fArr[3]);
        sb.append("), control1: (");
        sb.append(fArr[4]);
        sb.append(", ");
        sb.append(fArr[5]);
        sb.append("), anchor1: (");
        sb.append(getAnchor1X());
        sb.append(", ");
        sb.append(getAnchor1Y());
        sb.append(')');
        return sb.toString();
    }

    public final MutableCubic transformed(PointTransformer pointTransformer) {
        float[] fArr = new float[8];
        MutableCubic mutableCubic = new MutableCubic(fArr);
        ArraysKt.copyInto$default(this.points, fArr, 14);
        mutableCubic.transformOnePoint(pointTransformer, 0);
        mutableCubic.transformOnePoint(pointTransformer, 2);
        mutableCubic.transformOnePoint(pointTransformer, 4);
        mutableCubic.transformOnePoint(pointTransformer, 6);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes() {
        float[] fArr = this.points;
        return Math.abs(fArr[0] - getAnchor1X()) < 1.0E-4f && Math.abs(fArr[1] - getAnchor1Y()) < 1.0E-4f;
    }
}
