package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.compose.foundation.MarqueeSpacing$Companion$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class SimpleArrayMap {
    public Object[] array;
    public int[] hashes;
    public int size;

    public SimpleArrayMap(int i) {
        this.hashes = i == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i];
        this.array = i == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i << 1];
    }

    public final int __restricted$indexOfValue(Object obj) {
        int i = this.size * 2;
        Object[] objArr = this.array;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void clear() {
        int i = this.size;
        if (i > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            i = 0;
            this.size = 0;
        }
        if (i <= 0) {
            return;
        }
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return __restricted$indexOfValue(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                int i = this.size;
                if (i != ((SimpleArrayMap) obj).size) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objKeyAt = keyAt(i2);
                    Object objValueAt = valueAt(i2);
                    Object obj2 = simpleArrayMap.get(objKeyAt);
                    if (objValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(objKeyAt)) {
                            return false;
                        }
                    } else if (!objValueAt.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.size != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.size;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objKeyAt2 = keyAt(i4);
                Object objValueAt2 = valueAt(i4);
                Object obj3 = ((Map) obj).get(objKeyAt2);
                if (objValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objKeyAt2)) {
                        return false;
                    }
                } else if (!objValueAt2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object get(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? this.array[(iIndexOfKey << 1) + 1] : obj2;
    }

    public final int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i = this.size;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final int indexOf(int i, Object obj) {
        int i2 = this.size;
        if (i2 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(i2, i, this.hashes);
        if (iBinarySearch < 0 || Intrinsics.areEqual(obj, this.array[iBinarySearch << 1])) {
            return iBinarySearch;
        }
        int i3 = iBinarySearch + 1;
        while (i3 < i2 && this.hashes[i3] == i) {
            if (Intrinsics.areEqual(obj, this.array[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iBinarySearch - 1; i4 >= 0 && this.hashes[i4] == i; i4--) {
            if (Intrinsics.areEqual(obj, this.array[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj.hashCode(), obj);
    }

    public final int indexOfNull() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(i, 0, this.hashes);
        if (iBinarySearch < 0 || this.array[iBinarySearch << 1] == null) {
            return iBinarySearch;
        }
        int i2 = iBinarySearch + 1;
        while (i2 < i && this.hashes[i2] == 0) {
            if (this.array[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iBinarySearch - 1; i3 >= 0 && this.hashes[i3] == 0; i3--) {
            if (this.array[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean isEmpty() {
        return this.size <= 0;
    }

    public final Object keyAt(int i) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (z) {
            return this.array[i << 1];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.size;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iIndexOf = obj != null ? indexOf(iHashCode, obj) : indexOfNull();
        if (iIndexOf >= 0) {
            int i2 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            this.hashes = Arrays.copyOf(iArr, i4);
            this.array = Arrays.copyOf(this.array, i4 << 1);
            if (i != this.size) {
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                return null;
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.hashes;
            int i5 = i3 + 1;
            ArraysKt.copyInto(i5, i3, i, iArr2, iArr2);
            Object[] objArr2 = this.array;
            ArraysKt.copyInto(i5 << 1, i3 << 1, this.size << 1, objArr2, objArr2);
        }
        int i6 = this.size;
        if (i == i6) {
            int[] iArr3 = this.hashes;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.array;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.size = i6 + 1;
                return null;
            }
        }
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
        return null;
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(obj2, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public final Object removeAt(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.size)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        Object[] objArr = this.array;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i4 = i2 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                ArraysKt.copyInto(i, i5, i2, iArr, iArr);
                Object[] objArr2 = this.array;
                ArraysKt.copyInto(i3, i5 << 1, i2 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.array;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            this.hashes = Arrays.copyOf(iArr, i7);
            this.array = Arrays.copyOf(this.array, i7 << 1);
            if (i2 != this.size) {
                MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
                return null;
            }
            if (i > 0) {
                ArraysKt.copyInto(0, 0, i, iArr, this.hashes);
                ArraysKt.copyInto(0, 0, i3, objArr, this.array);
            }
            if (i < i4) {
                int i8 = i + 1;
                ArraysKt.copyInto(i, i8, i2, iArr, this.hashes);
                ArraysKt.copyInto(i3, i8 << 1, i2 << 1, objArr, this.array);
            }
        }
        if (i2 == this.size) {
            this.size = i4;
            return obj;
        }
        MarqueeSpacing$Companion$$ExternalSyntheticLambda0.m52m();
        return null;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey < 0 || !Intrinsics.areEqual(obj2, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, obj3);
        return true;
    }

    public final Object setValueAt(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (!z) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.array;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final int size() {
        return this.size;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objKeyAt = keyAt(i2);
            if (objKeyAt != sb) {
                sb.append(objKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objValueAt = valueAt(i2);
            if (objValueAt != sb) {
                sb.append(objValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object valueAt(int i) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (z) {
            return this.array[(i << 1) + 1];
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public Object remove(Object obj) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iIndexOfKey = indexOfKey(obj);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, obj2);
        }
        return null;
    }
}
