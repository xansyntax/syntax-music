package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPathMeasure {
    public final PathMeasure internalPathMeasure;

    public AndroidPathMeasure(PathMeasure pathMeasure) {
        this.internalPathMeasure = pathMeasure;
    }

    public final boolean getSegment(float f, float f2, AndroidPath androidPath) {
        if (androidPath instanceof AndroidPath) {
            return this.internalPathMeasure.getSegment(f, f2, androidPath.internalPath, true);
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2("Unable to obtain android.graphics.Path");
        return false;
    }

    public final void setPath(AndroidPath androidPath) {
        this.internalPathMeasure.setPath(androidPath.internalPath, false);
    }
}
