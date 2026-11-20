package androidx.core.graphics;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class TypefaceCompat$$ExternalSyntheticApiModelOutline1 {
    public static /* synthetic */ LinearGradient m(float f, float f2, float f3, float f4, long[] jArr, float[] fArr, Shader.TileMode tileMode) {
        return new LinearGradient(f, f2, f3, f4, jArr, fArr, tileMode);
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ BlendModeColorFilter m(int i, BlendMode blendMode) {
        return new BlendModeColorFilter(i, blendMode);
    }

    public static /* synthetic */ RadialGradient m(float f, float f2, float f3, long[] jArr, float[] fArr, Shader.TileMode tileMode) {
        return new RadialGradient(f, f2, f3, jArr, fArr, tileMode);
    }

    public static /* synthetic */ RenderNode m() {
        return new RenderNode("AndroidEdgeEffectOverscrollEffect");
    }

    public static /* synthetic */ SweepGradient m(float f, float f2, long[] jArr, float[] fArr) {
        return new SweepGradient(f, f2, jArr, fArr);
    }

    public static /* synthetic */ MediaSession m(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WindowInsets.Builder m827m() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder m(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m828m() {
    }
}
