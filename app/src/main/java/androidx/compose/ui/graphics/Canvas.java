package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface Canvas {
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo452clipPathmtrdDE(AndroidPath androidPath);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo453clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo454concat58bKbWc(float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo455drawCircle9KIMszo(float f, long j, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo456drawImaged4ec7I(ImageBitmap imageBitmap, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo457drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo458drawLineWko1d7g(long j, long j2, AndroidPaint androidPaint);

    void drawPath(AndroidPath androidPath, AndroidPaint androidPaint);

    void drawRect(float f, float f2, float f3, float f4, AndroidPaint androidPaint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(Rect rect, AndroidPaint androidPaint);

    void scale(float f, float f2);

    void translate(float f, float f2);
}
