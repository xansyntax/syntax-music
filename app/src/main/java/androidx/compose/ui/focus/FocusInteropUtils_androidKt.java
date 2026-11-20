package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidComposeView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FocusInteropUtils_androidKt {
    public static final int[] tempCoordinates = new int[2];
    public static final Rect tempRect = new Rect();

    public static final androidx.compose.ui.geometry.Rect calculateFocusRectRelativeTo(View view, View view2) {
        int[] iArr = tempCoordinates;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        float f = i2 - iArr[1];
        Rect rect = tempRect;
        view.getFocusedRect(rect);
        float f2 = (i - i3) + rect.left;
        return new androidx.compose.ui.geometry.Rect(f2, rect.top + f, rect.width() + f2, f + rect.top + rect.height());
    }

    public static final boolean requestInteropFocus(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !viewGroup.hasFocus()) {
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return ((AndroidComposeView) view).requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }

    /* JADX INFO: renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m408toAndroidFocusDirection3ESFkO8(int i) {
        if (i == 5) {
            return 33;
        }
        if (i == 6) {
            return 130;
        }
        if (i == 3) {
            return 17;
        }
        if (i == 4) {
            return 66;
        }
        if (i == 1) {
            return 2;
        }
        return i == 2 ? 1 : null;
    }

    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return new FocusDirection(2);
        }
        if (i == 2) {
            return new FocusDirection(1);
        }
        if (i == 17) {
            return new FocusDirection(3);
        }
        if (i == 33) {
            return new FocusDirection(5);
        }
        if (i == 66) {
            return new FocusDirection(4);
        }
        if (i != 130) {
            return null;
        }
        return new FocusDirection(6);
    }
}
