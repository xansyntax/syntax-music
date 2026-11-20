package androidx.compose.foundation.gestures;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1 implements BringIntoViewSpec {
    @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
    public final float calculateScrollDistance(float f, float f2, float f3) {
        float fAbs = Math.abs((f2 + f) - f);
        boolean z = fAbs <= f3;
        float f4 = (0.3f * f3) - (CropImageView.DEFAULT_ASPECT_RATIO * fAbs);
        float f5 = f3 - f4;
        if (z && f5 < fAbs) {
            f4 = f3 - fAbs;
        }
        return f - f4;
    }
}
