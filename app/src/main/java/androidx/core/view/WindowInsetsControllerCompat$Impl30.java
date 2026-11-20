package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.datastore.core.AtomicInt;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl30 extends LifecyclesKt {
    public final WindowInsetsController mInsetsController;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl30(Window window, AtomicInt atomicInt) {
        this.mInsetsController = window.getInsetsController();
        this.mWindow = window;
    }

    @Override // coil3.util.LifecyclesKt
    public final void hide() {
        this.mInsetsController.hide(1);
    }

    @Override // coil3.util.LifecyclesKt
    public void setAppearanceLightNavigationBars(boolean z) {
        Window window = this.mWindow;
        if (window != null) {
            if (!z) {
                unsetSystemUiFlag(16);
                return;
            } else {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                return;
            }
        }
        WindowInsetsController windowInsetsController = this.mInsetsController;
        if (z) {
            windowInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    @Override // coil3.util.LifecyclesKt
    public void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (window != null) {
            if (!z) {
                unsetSystemUiFlag(8192);
                return;
            } else {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
                return;
            }
        }
        WindowInsetsController windowInsetsController = this.mInsetsController;
        if (z) {
            windowInsetsController.setSystemBarsAppearance(8, 8);
        } else {
            windowInsetsController.setSystemBarsAppearance(0, 8);
        }
    }

    @Override // coil3.util.LifecyclesKt
    public void setSystemBarsBehavior() {
        Window window = this.mWindow;
        if (window == null) {
            this.mInsetsController.setSystemBarsBehavior(2);
            return;
        }
        window.getDecorView().setTag(356039078, 2);
        unsetSystemUiFlag(2048);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4096);
    }

    @Override // coil3.util.LifecyclesKt
    public final void show() {
        this.mInsetsController.show(1);
    }

    public final void unsetSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
