package androidx.window.core;

import android.graphics.Rect;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Bounds {
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static {
        new Bounds(0, 0, 0, 0);
    }

    public Bounds(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        if (i > i3) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i, i3, "Left must be less than or equal to right, left: ", ", right: "));
            throw null;
        }
        if (i2 <= i4) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) Fragment$5$$ExternalSyntheticOutline0.m(i2, i4, "top must be less than or equal to bottom, top: ", ", bottom: "));
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Bounds.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        Bounds bounds = (Bounds) obj;
        return this.left == bounds.left && this.top == bounds.top && this.right == bounds.right && this.bottom == bounds.bottom;
    }

    public final int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Bounds { [");
        sb.append(this.left);
        sb.append(',');
        sb.append(this.top);
        sb.append(',');
        sb.append(this.right);
        sb.append(',');
        return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.bottom, "] }");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        rect.getClass();
    }
}
