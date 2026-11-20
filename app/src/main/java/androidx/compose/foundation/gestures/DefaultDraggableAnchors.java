package androidx.compose.foundation.gestures;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultDraggableAnchors {
    public final float[] anchors;
    public final List keys;
    public final int size;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    public DefaultDraggableAnchors(List list, float[] fArr) {
        Object objListOf;
        this.keys = list;
        this.anchors = fArr;
        if (list.size() != fArr.length) {
            int length = fArr.length;
            if (length != 0) {
                if (length != 1) {
                    objListOf = new ArrayList(fArr.length);
                    for (float f : fArr) {
                        objListOf.add(Float.valueOf(f));
                    }
                } else {
                    objListOf = CollectionsKt__IterablesKt.listOf(Float.valueOf(fArr[0]));
                }
            } else {
                objListOf = EmptyList.INSTANCE;
            }
            InlineClassHelperKt.throwIllegalArgumentException("DraggableAnchors were constructed with inconsistent key-value sizes. Keys: " + list + " | Anchors: " + objListOf);
        }
        this.size = fArr.length;
    }

    public final Object closestAnchor(float f, boolean z) {
        float[] fArr = this.anchors;
        int length = fArr.length;
        int i = 0;
        int i2 = -1;
        float f2 = Float.POSITIVE_INFINITY;
        int i3 = 0;
        while (i < length) {
            float f3 = fArr[i];
            int i4 = i3 + 1;
            float f4 = z ? f3 - f : f - f3;
            if (f4 < CropImageView.DEFAULT_ASPECT_RATIO) {
                f4 = Float.POSITIVE_INFINITY;
            }
            if (f4 <= f2) {
                i2 = i3;
                f2 = f4;
            }
            i++;
            i3 = i4;
        }
        if (i2 == -1) {
            return null;
        }
        return this.keys.get(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultDraggableAnchors)) {
            return false;
        }
        DefaultDraggableAnchors defaultDraggableAnchors = (DefaultDraggableAnchors) obj;
        return this.keys.equals(defaultDraggableAnchors.keys) && Arrays.equals(this.anchors, defaultDraggableAnchors.anchors) && this.size == defaultDraggableAnchors.size;
    }

    public final boolean hasPositionFor(Object obj) {
        return this.keys.indexOf(obj) != -1;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.anchors) + (this.keys.hashCode() * 31)) * 31) + this.size;
    }

    public final float maxPosition() {
        float[] fArr = this.anchors;
        if (fArr.length == 0) {
            return Float.NaN;
        }
        float fMax = fArr[0];
        int i = 1;
        int length = fArr.length - 1;
        if (1 <= length) {
            while (true) {
                fMax = Math.max(fMax, fArr[i]);
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return fMax;
    }

    public final float minPosition() {
        float[] fArr = this.anchors;
        if (fArr.length == 0) {
            return Float.NaN;
        }
        float fMin = fArr[0];
        int i = 1;
        int length = fArr.length - 1;
        if (1 <= length) {
            while (true) {
                fMin = Math.min(fMin, fArr[i]);
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return fMin;
    }

    public final float positionOf(Object obj) {
        int iIndexOf = this.keys.indexOf(obj);
        if (iIndexOf < 0) {
            return Float.NaN;
        }
        float[] fArr = this.anchors;
        if (iIndexOf < fArr.length) {
            return fArr[iIndexOf];
        }
        return Float.NaN;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c  */
    public final String toString() {
        float f;
        StringBuilder sb = new StringBuilder("DraggableAnchors(anchors={");
        int i = 0;
        while (true) {
            int i2 = this.size;
            if (i >= i2) {
                sb.append("})");
                return sb.toString();
            }
            Object orNull = CollectionsKt.getOrNull(i, this.keys);
            if (i >= 0) {
                float[] fArr = this.anchors;
                if (i < fArr.length) {
                    f = fArr[i];
                } else {
                    f = Float.NaN;
                }
            } else {
                f = Float.NaN;
            }
            sb.append(orNull + "=" + f);
            if (i < i2 - 1) {
                sb.append(", ");
            }
            i++;
        }
    }

    public final Object closestAnchor(float f) {
        float[] fArr = this.anchors;
        int length = fArr.length;
        float f2 = Float.POSITIVE_INFINITY;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i < length) {
            int i4 = i3 + 1;
            float fAbs = Math.abs(f - fArr[i]);
            if (fAbs <= f2) {
                i2 = i3;
                f2 = fAbs;
            }
            i++;
            i3 = i4;
        }
        if (i2 == -1) {
            return null;
        }
        return this.keys.get(i2);
    }
}
