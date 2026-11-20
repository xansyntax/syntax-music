package androidx.window.layout.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import androidx.window.layout.WindowMetrics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DensityCompatHelperApi34Impl implements DensityCompatHelper, WindowMetricsCompatHelper {
    public static final DensityCompatHelperApi34Impl INSTANCE = new DensityCompatHelperApi34Impl();
    public static final DensityCompatHelperApi34Impl INSTANCE$1 = new DensityCompatHelperApi34Impl();

    @Override // androidx.window.layout.util.WindowMetricsCompatHelper
    public WindowMetrics currentWindowMetrics(Context context, DensityCompatHelper densityCompatHelper) {
        WindowManager windowManager = context.isUiContext() ? (WindowManager) context.getSystemService(WindowManager.class) : (WindowManager) context.getApplicationContext().getSystemService(WindowManager.class);
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        bounds.getClass();
        return new WindowMetrics(bounds, windowManager.getCurrentWindowMetrics().getDensity());
    }

    @Override // androidx.window.layout.util.DensityCompatHelper
    public float density(Context context) {
        return ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getDensity();
    }
}
