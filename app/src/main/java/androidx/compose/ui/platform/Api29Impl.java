package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.ColorKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api29Impl {
    /* JADX INFO: renamed from: calculateMatrixToWindow-V2T6pWw, reason: not valid java name */
    public static final void m703calculateMatrixToWindowV2T6pWw(View view, float[] fArr, Matrix matrix, int[] iArr) {
        matrix.reset();
        view.transformMatrixToGlobal(matrix);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view.getLocationInWindow(iArr);
        matrix.postTranslate(iArr[0] - i, iArr[1] - i2);
        ColorKt.m496setFromtUYjHk(matrix, fArr);
    }

    public static final void disallowForceDark(View view) {
        view.setForceDarkAllowed(false);
    }

    public static final boolean isValidMotionEvent(MotionEvent motionEvent, int i) {
        return (Float.floatToRawIntBits(motionEvent.getRawX(i)) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(motionEvent.getRawY(i)) & Integer.MAX_VALUE) < 2139095040;
    }
}
