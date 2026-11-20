package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPath {
    public final Path internalPath;
    public android.graphics.Matrix mMatrix;
    public float[] radii;
    public RectF rectF;

    public AndroidPath(Path path) {
        this.internalPath = path;
    }

    /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
    public static void m469addPathUv8p0NA$default(AndroidPath androidPath, AndroidPath androidPath2) {
        Path path = androidPath.internalPath;
        if (androidPath2 instanceof AndroidPath) {
            path.addPath(androidPath2.internalPath, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
        }
    }

    public static void addRect$default(AndroidPath androidPath, Rect rect) {
        androidPath.getClass();
        float f = rect.left;
        float f2 = rect.bottom;
        float f3 = rect.right;
        float f4 = rect.top;
        if (Float.isNaN(f) || Float.isNaN(f4) || Float.isNaN(f3) || Float.isNaN(f2)) {
            AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        }
        RectF rectF = androidPath.rectF;
        if (rectF == null) {
            rectF = new RectF();
            androidPath.rectF = rectF;
        }
        rectF.set(rect.left, f4, f3, f2);
        Path path = androidPath.internalPath;
        RectF rectF2 = androidPath.rectF;
        rectF2.getClass();
        path.addRect(rectF2, Path.Direction.CCW);
    }

    public static void addRoundRect$default(AndroidPath androidPath, RoundRect roundRect) {
        RectF rectF = androidPath.rectF;
        if (rectF == null) {
            rectF = new RectF();
            androidPath.rectF = rectF;
        }
        float f = roundRect.left;
        long j = roundRect.bottomLeftCornerRadius;
        long j2 = roundRect.bottomRightCornerRadius;
        long j3 = roundRect.topRightCornerRadius;
        long j4 = roundRect.topLeftCornerRadius;
        rectF.set(f, roundRect.top, roundRect.right, roundRect.bottom);
        float[] fArr = androidPath.radii;
        if (fArr == null) {
            fArr = new float[8];
            androidPath.radii = fArr;
        }
        fArr[0] = Float.intBitsToFloat((int) (j4 >> 32));
        fArr[1] = Float.intBitsToFloat((int) (j4 & 4294967295L));
        fArr[2] = Float.intBitsToFloat((int) (j3 >> 32));
        fArr[3] = Float.intBitsToFloat((int) (j3 & 4294967295L));
        fArr[4] = Float.intBitsToFloat((int) (j2 >> 32));
        fArr[5] = Float.intBitsToFloat((int) (j2 & 4294967295L));
        fArr[6] = Float.intBitsToFloat((int) (j >> 32));
        fArr[7] = Float.intBitsToFloat((int) (j & 4294967295L));
        Path path = androidPath.internalPath;
        RectF rectF2 = androidPath.rectF;
        rectF2.getClass();
        float[] fArr2 = androidPath.radii;
        fArr2.getClass();
        path.addRoundRect(rectF2, fArr2, Path.Direction.CCW);
    }

    public final Rect getBounds() {
        RectF rectF = this.rectF;
        if (rectF == null) {
            rectF = new RectF();
            this.rectF = rectF;
        }
        this.internalPath.computeBounds(rectF, true);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void lineTo(float f, float f2) {
        this.internalPath.lineTo(f, f2);
    }

    public final void moveTo(float f, float f2) {
        this.internalPath.moveTo(f, f2);
    }

    /* JADX INFO: renamed from: op-N5in7k0, reason: not valid java name */
    public final boolean m470opN5in7k0(AndroidPath androidPath, AndroidPath androidPath2, int i) {
        Path.Op op;
        if (i == 0) {
            op = Path.Op.DIFFERENCE;
        } else if (i == 1) {
            op = Path.Op.INTERSECT;
        } else if (i == 4) {
            op = Path.Op.REVERSE_DIFFERENCE;
        } else {
            op = i == 2 ? Path.Op.UNION : Path.Op.XOR;
        }
        if (!(androidPath instanceof AndroidPath)) {
            PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
            return false;
        }
        Path path = androidPath.internalPath;
        if (androidPath2 instanceof AndroidPath) {
            return this.internalPath.op(path, androidPath2.internalPath, op);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
        return false;
    }

    public final void reset() {
        this.internalPath.reset();
    }

    public final void rewind() {
        this.internalPath.rewind();
    }

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public final void m471setFillTypeoQ8Xj4U(int i) {
        this.internalPath.setFillType(i == 1 ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final void m472translatek4lQ0M(long j) {
        android.graphics.Matrix matrix = this.mMatrix;
        if (matrix == null) {
            this.mMatrix = new android.graphics.Matrix();
        } else {
            matrix.reset();
        }
        android.graphics.Matrix matrix2 = this.mMatrix;
        matrix2.getClass();
        matrix2.setTranslate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        android.graphics.Matrix matrix3 = this.mMatrix;
        matrix3.getClass();
        this.internalPath.transform(matrix3);
    }
}
