package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WavyProgressIndicatorDefaults {
    public static final float LinearContainerHeight;
    public static final float LinearContainerWidth;
    public static final float LinearDeterminateWavelength;
    public static final float LinearIndicatorTrackGapSize;
    public static final float LinearTrackStopIndicatorSize;
    public static final TextKt$$ExternalSyntheticLambda0 indicatorAmplitude;

    static {
        ArcSplineKt.tween$default(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 0, new CubicBezierEasing(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f), 2);
        LinearDeterminateWavelength = 40.0f;
        LinearContainerHeight = 10.0f;
        LinearContainerWidth = 240.0f;
        LinearTrackStopIndicatorSize = 4.0f;
        LinearIndicatorTrackGapSize = 4.0f;
        indicatorAmplitude = new TextKt$$ExternalSyntheticLambda0((byte) 14);
    }
}
