package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyCanvas implements Canvas {
    public static final EmptyCanvas INSTANCE = new EmptyCanvas();

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    public final void mo452clipPathmtrdDE(AndroidPath androidPath) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg */
    public final void mo453clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc */
    public final void mo454concat58bKbWc(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void disableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawArc(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    public final void mo455drawCircle9KIMszo(float f, long j, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    public final void mo456drawImaged4ec7I(ImageBitmap imageBitmap, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    public final void mo457drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    public final void mo458drawLineWko1d7g(long j, long j2, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawPath(AndroidPath androidPath, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawRect(float f, float f2, float f3, float f4, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void enableZ() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void restore() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void rotate(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void save() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void saveLayer(Rect rect, AndroidPaint androidPaint) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void scale(float f, float f2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void translate(float f, float f2) {
        throw new UnsupportedOperationException();
    }
}
