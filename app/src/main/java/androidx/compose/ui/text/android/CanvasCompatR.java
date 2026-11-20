package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CanvasCompatR {
    public static boolean quickReject(Canvas canvas, RectF rectF) {
        return canvas.quickReject(rectF);
    }

    public static boolean quickReject(Canvas canvas, Path path) {
        return canvas.quickReject(path);
    }

    public static boolean quickReject(Canvas canvas, float f, float f2, float f3, float f4) {
        return canvas.quickReject(f, f2, f3, f4);
    }
}
