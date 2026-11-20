package androidx.compose.material3;

import androidx.compose.runtime.ComputedProvidableCompositionLocal;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RippleKt {
    public static final RippleNodeFactory DefaultBoundedRipple;
    public static final RippleNodeFactory DefaultUnboundedRipple;
    public static final StaticProvidableCompositionLocal LocalRippleThemeConfiguration = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 7), (byte) 1);
    public static final ComputedProvidableCompositionLocal LocalRippleConfiguration = new ComputedProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda0(2));

    static {
        Rgb rgb = ColorSpaces.Unspecified;
        DefaultBoundedRipple = new RippleNodeFactory(true, Float.NaN, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), null, true);
        DefaultUnboundedRipple = new RippleNodeFactory(false, Float.NaN, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb), null, true);
    }

    /* JADX INFO: renamed from: ripple-Ou1YvPQ$default, reason: not valid java name */
    public static RippleNodeFactory m313rippleOu1YvPQ$default(boolean z, float f, long j, Shape shape, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean z2 = z;
        float f2 = (i & 2) != 0 ? Float.NaN : f;
        if ((i & 4) != 0) {
            j = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
        }
        long j2 = j;
        if ((i & 8) != 0) {
            shape = null;
        }
        Shape shape2 = shape;
        if (Dp.m796equalsimpl0(f2, Float.NaN) && ULong.m1869equalsimpl0(j2, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified)) && shape2 == null) {
            return z2 ? DefaultBoundedRipple : DefaultUnboundedRipple;
        }
        return new RippleNodeFactory(z2, f2, j2, shape2, true);
    }
}
