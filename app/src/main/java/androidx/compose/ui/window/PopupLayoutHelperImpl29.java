package androidx.compose.ui.window;

import android.graphics.Rect;
import kotlin.collections.CollectionsKt__IterablesKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl
    public final void setGestureExclusionRects(PopupLayout popupLayout, int i, int i2) {
        popupLayout.setSystemGestureExclusionRects(CollectionsKt__IterablesKt.mutableListOf(new Rect(0, 0, i, i2)));
    }
}
