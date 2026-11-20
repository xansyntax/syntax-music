package androidx.core.view;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingParent2 {
    void onNestedPreScroll(int i, int i2, int i3, int[] iArr);

    void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(View view, View view2, int i, int i2);

    boolean onStartNestedScroll(View view, View view2, int i, int i2);

    void onStopNestedScroll(View view, int i);
}
