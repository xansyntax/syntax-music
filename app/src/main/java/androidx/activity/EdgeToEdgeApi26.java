package androidx.activity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat$Impl26;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.core.view.WindowInsetsControllerCompat$Impl35;
import androidx.datastore.core.AtomicInt;
import coil3.util.LifecyclesKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class EdgeToEdgeApi26 {
    public void setUp(SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, Window window, View view, boolean z, boolean z2) {
        LifecyclesKt windowInsetsControllerCompat$Impl30;
        systemBarStyle.getClass();
        systemBarStyle2.getClass();
        window.getClass();
        view.getClass();
        MathKt.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(z ? systemBarStyle.darkScrim : systemBarStyle.lightScrim);
        window.setNavigationBarColor(z2 ? systemBarStyle2.darkScrim : systemBarStyle2.lightScrim);
        AtomicInt atomicInt = new AtomicInt(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            windowInsetsControllerCompat$Impl30 = new WindowInsetsControllerCompat$Impl35(window, atomicInt);
        } else {
            windowInsetsControllerCompat$Impl30 = i >= 30 ? new WindowInsetsControllerCompat$Impl30(window, atomicInt) : new WindowInsetsControllerCompat$Impl26(window, atomicInt);
        }
        windowInsetsControllerCompat$Impl30.setAppearanceLightStatusBars(!z);
        windowInsetsControllerCompat$Impl30.setAppearanceLightNavigationBars(!z2);
    }

    public void adjustLayoutInDisplayCutoutMode(Window window) {
    }
}
