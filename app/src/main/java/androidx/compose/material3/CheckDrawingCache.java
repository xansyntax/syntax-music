package androidx.compose.material3;

import android.graphics.PathMeasure;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CheckDrawingCache {
    public final AndroidPath checkPath;
    public final AndroidPathMeasure pathMeasure;
    public final AndroidPath pathToDraw;

    public CheckDrawingCache() {
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        AndroidPathMeasure androidPathMeasure = new AndroidPathMeasure(new PathMeasure());
        AndroidPath androidPathPath2 = AndroidPath_androidKt.Path();
        this.checkPath = androidPathPath;
        this.pathMeasure = androidPathMeasure;
        this.pathToDraw = androidPathPath2;
    }
}
