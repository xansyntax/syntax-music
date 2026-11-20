package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WindowMetrics {
    public final Bounds _bounds;
    public final float density;

    public WindowMetrics(Rect rect, float f) {
        this._bounds = new Bounds(rect);
        this.density = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!WindowMetrics.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        WindowMetrics windowMetrics = (WindowMetrics) obj;
        return Intrinsics.areEqual(this._bounds, windowMetrics._bounds) && this.density == windowMetrics.density;
    }

    public final Rect getBounds() {
        Bounds bounds = this._bounds;
        bounds.getClass();
        return new Rect(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public final int hashCode() {
        return Float.hashCode(this.density) + (this._bounds.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics(_bounds=" + this._bounds + ", density=" + this.density + ')';
    }

    public WindowMetrics(Bounds bounds, float f) {
        this._bounds = bounds;
        this.density = f;
    }
}
