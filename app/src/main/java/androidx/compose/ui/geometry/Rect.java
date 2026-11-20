package androidx.compose.ui.geometry;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Rect {
    public static final Rect Zero = new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    public final float bottom;
    public final float left;
    public final float right;
    public final float top;

    public Rect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public static Rect copy$default(Rect rect, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = rect.left;
        }
        float f3 = (i & 2) != 0 ? rect.top : Float.NEGATIVE_INFINITY;
        if ((i & 4) != 0) {
            f2 = rect.right;
        }
        return new Rect(f, f3, f2, (i & 8) != 0 ? rect.bottom : Float.POSITIVE_INFINITY);
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m442containsk4lQ0M(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat >= this.left) & (fIntBitsToFloat < this.right) & (fIntBitsToFloat2 >= this.top) & (fIntBitsToFloat2 < this.bottom);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return Float.compare(this.left, rect.left) == 0 && Float.compare(this.top, rect.top) == 0 && Float.compare(this.right, rect.right) == 0 && Float.compare(this.bottom, rect.bottom) == 0;
    }

    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m443getCenterF1C5BW0() {
        float f = this.right;
        float f2 = this.left;
        float f3 = ((f - f2) / 2.0f) + f2;
        float f4 = this.bottom;
        float f5 = this.top;
        return (((long) Float.floatToRawIntBits(((f4 - f5) / 2.0f) + f5)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32);
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m444getSizeNHjbRc() {
        float f = this.right - this.left;
        return (((long) Float.floatToRawIntBits(this.bottom - this.top)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    /* JADX INFO: renamed from: getTopLeft-F1C5BW0, reason: not valid java name */
    public final long m445getTopLeftF1C5BW0() {
        return (((long) Float.floatToRawIntBits(this.left)) << 32) | (((long) Float.floatToRawIntBits(this.top)) & 4294967295L);
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + IntIntPair$$ExternalSyntheticOutline0.m(this.right, IntIntPair$$ExternalSyntheticOutline0.m(this.top, Float.hashCode(this.left) * 31, 31), 31);
    }

    public final Rect intersect(Rect rect) {
        return new Rect(Math.max(this.left, rect.left), Math.max(this.top, rect.top), Math.min(this.right, rect.right), Math.min(this.bottom, rect.bottom));
    }

    public final boolean isEmpty() {
        return (this.left >= this.right) | (this.top >= this.bottom);
    }

    public final boolean overlaps(Rect rect) {
        return (this.left < rect.right) & (rect.left < this.right) & (this.top < rect.bottom) & (rect.top < this.bottom);
    }

    public final String toString() {
        String stringAsFixed = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.left);
        String stringAsFixed2 = DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.top);
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("Rect.fromLTRB(", stringAsFixed, ", ", stringAsFixed2, ", "), DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.right), ", ", DatabaseDao_Impl.AnonymousClass17.toStringAsFixed(this.bottom), ")");
    }

    public final Rect translate(float f, float f2) {
        return new Rect(this.left + f, this.top + f2, this.right + f, this.bottom + f2);
    }

    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final Rect m446translatek4lQ0M(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return new Rect(Float.intBitsToFloat(i) + this.left, Float.intBitsToFloat(i2) + this.top, Float.intBitsToFloat(i) + this.right, Float.intBitsToFloat(i2) + this.bottom);
    }
}
