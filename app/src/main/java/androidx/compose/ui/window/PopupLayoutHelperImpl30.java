package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PopupLayoutHelperImpl30 extends PopupLayoutHelperImpl29 {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl
    public final void getWindowBounds(View view, Rect rect) {
        Object systemService = view.getContext().getSystemService("window");
        systemService.getClass();
        rect.set(((WindowManager) systemService).getCurrentWindowMetrics().getBounds());
    }
}
