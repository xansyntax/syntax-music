package androidx.compose.ui.window;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class PopupLayoutHelperImpl {
    public void getWindowBounds(View view, Rect rect) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        rect.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public void setGestureExclusionRects(PopupLayout popupLayout, int i, int i2) {
    }
}
