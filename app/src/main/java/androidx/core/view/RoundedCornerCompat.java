package androidx.core.view;

import android.graphics.Point;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundedCornerCompat {
    public final Point mCenter;
    public final int mPosition;
    public final int mRadius;

    public RoundedCornerCompat(int i, int i2, Point point) {
        int i3 = point.x;
        int i4 = point.y;
        this.mPosition = i;
        this.mRadius = i2;
        this.mCenter = new Point(i3, i4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoundedCornerCompat)) {
            return false;
        }
        RoundedCornerCompat roundedCornerCompat = (RoundedCornerCompat) obj;
        return this.mPosition == roundedCornerCompat.mPosition && this.mRadius == roundedCornerCompat.mRadius && this.mCenter.equals(roundedCornerCompat.mCenter);
    }

    public final int hashCode() {
        return this.mCenter.hashCode() + (((this.mPosition * 31) + this.mRadius) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("RoundedCornerCompat{position=");
        int i = this.mPosition;
        if (i == 0) {
            str = "TopLeft";
        } else if (i == 1) {
            str = "TopRight";
        } else if (i != 2) {
            str = i != 3 ? "Invalid" : "BottomLeft";
        } else {
            str = "BottomRight";
        }
        sb.append(str);
        sb.append(", radius=");
        sb.append(this.mRadius);
        sb.append(", center=");
        sb.append(this.mCenter);
        sb.append('}');
        return sb.toString();
    }
}
