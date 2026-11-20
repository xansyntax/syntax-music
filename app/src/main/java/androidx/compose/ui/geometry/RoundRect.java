package androidx.compose.ui.geometry;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.sqlite.SQLite;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RoundRect {
    public final float bottom;
    public final long bottomLeftCornerRadius;
    public final long bottomRightCornerRadius;
    public final float left;
    public final float right;
    public final float top;
    public final long topLeftCornerRadius;
    public final long topRightCornerRadius;

    static {
        MathKt.m1873RoundRectgG7oq9Y(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0L);
    }

    public RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && SQLite.m845equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && SQLite.m845equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && SQLite.m845equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && SQLite.m845equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final int hashCode() {
        return Long.hashCode(this.bottomLeftCornerRadius) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.bottom, IntIntPair$$ExternalSyntheticOutline0.m(this.right, IntIntPair$$ExternalSyntheticOutline0.m(this.top, Float.hashCode(this.left) * 31, 31), 31), 31), 31, this.topLeftCornerRadius), 31, this.topRightCornerRadius), 31, this.bottomRightCornerRadius);
    }

    public final String toString() {
        String stringAsFixed = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.left);
        String stringAsFixed2 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.top);
        String stringAsFixed3 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.right);
        String stringAsFixed4 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.bottom);
        StringBuilder sb = new StringBuilder();
        sb.append(stringAsFixed);
        sb.append(", ");
        sb.append(stringAsFixed2);
        sb.append(", ");
        sb.append(stringAsFixed3);
        String strM = IntIntPair$$ExternalSyntheticOutline0.m(sb, ", ", stringAsFixed4);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        boolean zM845equalsimpl0 = SQLite.m845equalsimpl0(j, j2);
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        if (zM845equalsimpl0 && SQLite.m845equalsimpl0(j2, j3) && SQLite.m845equalsimpl0(j3, j4)) {
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            if (Float.intBitsToFloat(i) == Float.intBitsToFloat(i2)) {
                return Fragment$5$$ExternalSyntheticOutline0.m("RoundRect(rect=", strM, ", radius=", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i)), ")");
            }
            String stringAsFixed5 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i));
            return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("RoundRect(rect=", strM, ", x=", stringAsFixed5, ", y="), DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(Float.intBitsToFloat(i2)), ")");
        }
        String strM848toStringimpl = SQLite.m848toStringimpl(j);
        String strM848toStringimpl2 = SQLite.m848toStringimpl(j2);
        String strM848toStringimpl3 = SQLite.m848toStringimpl(j3);
        String strM848toStringimpl4 = SQLite.m848toStringimpl(j4);
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("RoundRect(rect=", strM, ", topLeft=", strM848toStringimpl, ", topRight=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, strM848toStringimpl2, ", bottomRight=", strM848toStringimpl3, ", bottomLeft=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, strM848toStringimpl4, ")");
    }
}
