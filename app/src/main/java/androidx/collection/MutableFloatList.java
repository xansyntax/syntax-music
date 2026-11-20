package androidx.collection;

import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;
import kotlin.ranges.IntRange;
import kotlin.uuid.UuidKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableFloatList {
    public int _size;
    public float[] content;

    public final void add(float f) {
        int i = this._size + 1;
        float[] fArrCopyOf = this.content;
        if (fArrCopyOf.length < i) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, Math.max(i, (fArrCopyOf.length * 3) / 2));
            this.content = fArrCopyOf;
        }
        int i2 = this._size;
        fArrCopyOf[i2] = f;
        this._size = i2 + 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MutableFloatList) {
            MutableFloatList mutableFloatList = (MutableFloatList) obj;
            int i = mutableFloatList._size;
            int i2 = this._size;
            if (i == i2) {
                float[] fArr = this.content;
                float[] fArr2 = mutableFloatList.content;
                IntRange intRangeUntil = UuidKt.until(0, i2);
                int i3 = intRangeUntil.first;
                int i4 = intRangeUntil.last;
                if (i3 > i4) {
                    return true;
                }
                while (fArr[i3] == fArr2[i3]) {
                    if (i3 == i4) {
                        return true;
                    }
                    i3++;
                }
                return false;
            }
        }
        return false;
    }

    public final float get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m("Index must be between 0 and size");
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public final int hashCode() {
        float[] fArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += Float.hashCode(fArr[i2]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        float[] fArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            float f = fArr[i2];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append(f);
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }
}
