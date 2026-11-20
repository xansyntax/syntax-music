package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.yalantis.ucrop.view.CropImageView;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utils {
    public static final long Zero = FloatFloatPair.m0constructorimpl(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    public static final float FloatPi = 3.1415927f;

    public static final long directionVector(float f, float f2) {
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        if (fSqrt > CropImageView.DEFAULT_ASPECT_RATIO) {
            return FloatFloatPair.m0constructorimpl(f / fSqrt, f2 / fSqrt);
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Required distance greater than zero");
        return 0L;
    }

    public static final float interpolate(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }
}
