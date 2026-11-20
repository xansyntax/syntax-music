package androidx.compose.ui.platform;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewConfiguration implements ViewConfiguration {
    public final android.view.ViewConfiguration viewConfiguration;

    public AndroidViewConfiguration(android.view.ViewConfiguration viewConfiguration) {
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getDoubleTapMinTimeMillis() {
        return 40L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getDoubleTapTimeoutMillis() {
        return android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getHandwritingGestureLineMargin() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AndroidViewConfigurationApi34.getScaledHandwritingGestureLineMargin(this.viewConfiguration);
        }
        return 16.0f;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getHandwritingSlop() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AndroidViewConfigurationApi34.getScaledHandwritingSlop(this.viewConfiguration);
        }
        return 2.0f;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getLongPressTimeoutMillis() {
        return android.view.ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getMaximumFlingVelocity() {
        return this.viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }
}
