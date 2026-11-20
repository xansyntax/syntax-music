package androidx.window.layout;

import android.os.Build;
import androidx.window.layout.util.BoundsHelperApi24Impl;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.layout.util.DensityCompatHelperApi34Impl;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    public final DensityCompatHelper densityCompatHelper;

    public WindowMetricsCalculatorCompat() {
        this.densityCompatHelper = Build.VERSION.SDK_INT >= 34 ? DensityCompatHelperApi34Impl.INSTANCE : BoundsHelperApi24Impl.INSTANCE$3;
        CollectionsKt__IterablesKt.arrayListOf(1, 2, 4, 8, 16, 32, 64, 128);
    }
}
