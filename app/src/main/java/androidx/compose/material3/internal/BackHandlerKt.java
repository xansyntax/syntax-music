package androidx.compose.material3.internal;

import androidx.compose.animation.core.CubicBezierEasing;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BackHandlerKt {
    public static final CubicBezierEasing PredictiveBackEasing = new CubicBezierEasing(0.1f, 0.1f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
}
