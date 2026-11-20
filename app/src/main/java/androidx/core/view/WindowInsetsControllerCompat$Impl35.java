package androidx.core.view;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl35 extends WindowInsetsControllerCompat$Impl30 {
    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl30, coil3.util.LifecyclesKt
    public final void setAppearanceLightNavigationBars(boolean z) {
        this.mInsetsController.setSystemBarsAppearance(z ? 16 : 0, 16);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl30, coil3.util.LifecyclesKt
    public final void setAppearanceLightStatusBars(boolean z) {
        this.mInsetsController.setSystemBarsAppearance(z ? 8 : 0, 8);
    }

    @Override // androidx.core.view.WindowInsetsControllerCompat$Impl30, coil3.util.LifecyclesKt
    public final void setSystemBarsBehavior() {
        this.mInsetsController.setSystemBarsBehavior(2);
    }
}
