package androidx.compose.ui.window;

import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DialogApi31Impl {
    public static final DialogApi31Impl INSTANCE = new DialogApi31Impl();

    public static void setBackgroundBlurRadius(Window window, int i) {
        window.setBackgroundBlurRadius(i);
    }

    public final void setBlurBehindRadius(Window window, int i) {
        if (i <= 0) {
            window.clearFlags(4);
            return;
        }
        window.addFlags(4);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.setBlurBehindRadius(i);
        window.setAttributes(attributes);
    }
}
