package androidx.compose.animation.core;

import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class EasingKt {
    public static final CubicBezierEasing FastOutLinearInEasing;
    public static final CubicBezierEasing FastOutSlowInEasing = new CubicBezierEasing(0.4f, CropImageView.DEFAULT_ASPECT_RATIO, 0.2f, 1.0f);
    public static final MarqueeSpacing$Companion$$ExternalSyntheticLambda0 LinearEasing;

    static {
        new CubicBezierEasing(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0.2f, 1.0f);
        FastOutLinearInEasing = new CubicBezierEasing(0.4f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f);
        LinearEasing = new MarqueeSpacing$Companion$$ExternalSyntheticLambda0((byte) 4);
    }
}
