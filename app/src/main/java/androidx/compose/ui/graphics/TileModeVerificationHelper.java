package androidx.compose.ui.graphics;

import android.graphics.Shader;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TileModeVerificationHelper {
    /* JADX INFO: renamed from: createBlurEffect-8A-3gB4, reason: not valid java name */
    public static android.graphics.RenderEffect m518createBlurEffect8A3gB4(float f, float f2, int i) {
        return (f == CropImageView.DEFAULT_ASPECT_RATIO && f2 == CropImageView.DEFAULT_ASPECT_RATIO) ? android.graphics.RenderEffect.createOffsetEffect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO) : android.graphics.RenderEffect.createBlurEffect(f, f2, ColorKt.m497toAndroidTileMode0vamqd0(i));
    }

    public static Shader.TileMode getFrameworkTileModeDecal() {
        return Shader.TileMode.DECAL;
    }
}
