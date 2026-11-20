package androidx.compose.ui.window;

import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PopupApi31Impl {
    public static final PopupApi31Impl INSTANCE = new PopupApi31Impl();

    public final void setBlurBehindRadius(WindowManager.LayoutParams layoutParams, int i) {
        if (i > 0) {
            layoutParams.flags |= 4;
        } else {
            layoutParams.flags &= -5;
        }
        layoutParams.setBlurBehindRadius(i);
    }
}
