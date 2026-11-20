package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.datastore.core.AtomicInt;
import coil3.util.LifecyclesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl26 extends LifecyclesKt {
    public final AtomicInt mSoftwareKeyboardControllerCompat;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl26(Window window, AtomicInt atomicInt) {
        this.mWindow = window;
        this.mSoftwareKeyboardControllerCompat = atomicInt;
    }

    @Override // coil3.util.LifecyclesKt
    public final void hide() {
        for (int i = 1; i <= 512; i <<= 1) {
            if ((1 & i) != 0) {
                if (i == 1) {
                    setSystemUiFlag(4);
                } else if (i == 2) {
                    setSystemUiFlag(2);
                } else if (i == 8) {
                    ((AtomicInt) this.mSoftwareKeyboardControllerCompat.delegate).hide();
                }
            }
        }
    }

    @Override // coil3.util.LifecyclesKt
    public final void setAppearanceLightNavigationBars(boolean z) {
        if (!z) {
            unsetSystemUiFlag(16);
            return;
        }
        Window window = this.mWindow;
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        setSystemUiFlag(16);
    }

    @Override // coil3.util.LifecyclesKt
    public final void setAppearanceLightStatusBars(boolean z) {
        if (!z) {
            unsetSystemUiFlag(8192);
            return;
        }
        Window window = this.mWindow;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        setSystemUiFlag(8192);
    }

    @Override // coil3.util.LifecyclesKt
    public final void setSystemBarsBehavior() {
        this.mWindow.getDecorView().setTag(356039078, 2);
        unsetSystemUiFlag(2048);
        setSystemUiFlag(4096);
    }

    public final void setSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    @Override // coil3.util.LifecyclesKt
    public final void show() {
        for (int i = 1; i <= 512; i <<= 1) {
            if ((1 & i) != 0) {
                if (i == 1) {
                    unsetSystemUiFlag(4);
                    this.mWindow.clearFlags(1024);
                } else if (i == 2) {
                    unsetSystemUiFlag(2);
                } else if (i == 8) {
                    ((AtomicInt) this.mSoftwareKeyboardControllerCompat.delegate).show();
                }
            }
        }
    }

    public final void unsetSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
