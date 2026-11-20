package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Api21Impl {
    /* JADX INFO: renamed from: calculateMatrixToWindow-qGEkDyk, reason: not valid java name */
    public static final void m701calculateMatrixToWindowqGEkDyk(View view, float[] fArr, float[] fArr2, int[] iArr) {
        Matrix.m510resetimpl(fArr);
        m702transformMatrixToWindowqGEkDyk(view, fArr, fArr2, iArr);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-qGEkDyk, reason: not valid java name */
    public static void m702transformMatrixToWindowqGEkDyk(View view, float[] fArr, float[] fArr2, int[] iArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m702transformMatrixToWindowqGEkDyk((View) parent, fArr, fArr2, iArr);
            InvertMatrixKt.m712preTranslatecG2Xzmc(fArr, -view.getScrollX(), -view.getScrollY(), fArr2);
            InvertMatrixKt.m712preTranslatecG2Xzmc(fArr, view.getLeft(), view.getTop(), fArr2);
        } else {
            view.getLocationInWindow(iArr);
            InvertMatrixKt.m712preTranslatecG2Xzmc(fArr, -view.getScrollX(), -view.getScrollY(), fArr2);
            InvertMatrixKt.m712preTranslatecG2Xzmc(fArr, iArr[0], iArr[1], fArr2);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        ColorKt.m496setFromtUYjHk(matrix, fArr2);
        InvertMatrixKt.m711preTransformJiSxe2E(fArr, fArr2);
    }
}
