package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GlowEdgeEffectCompat extends EdgeEffect {
    public float oppositeReleaseDelta;
    public final float oppositeReleaseDeltaThreshold;

    public GlowEdgeEffectCompat(Context context) {
        super(context);
        this.oppositeReleaseDeltaThreshold = MathKt.Density(context).density * 1.0f;
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int i) {
        this.oppositeReleaseDelta = CropImageView.DEFAULT_ASPECT_RATIO;
        super.onAbsorb(i);
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f, float f2) {
        this.oppositeReleaseDelta = CropImageView.DEFAULT_ASPECT_RATIO;
        super.onPull(f, f2);
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        this.oppositeReleaseDelta = CropImageView.DEFAULT_ASPECT_RATIO;
        super.onRelease();
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f) {
        this.oppositeReleaseDelta = CropImageView.DEFAULT_ASPECT_RATIO;
        super.onPull(f);
    }
}
