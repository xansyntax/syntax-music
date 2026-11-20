package androidx.compose.runtime.collection;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectListKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MultiValueMap {
    public final MutableScatterMap map;

    public /* synthetic */ MultiValueMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* JADX INFO: renamed from: removeLast-impl, reason: not valid java name */
    public static final Object m391removeLastimpl(MutableScatterMap mutableScatterMap) {
        Object obj = mutableScatterMap.get(null);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof MutableObjectList)) {
            mutableScatterMap.remove(null);
            return obj;
        }
        MutableObjectList mutableObjectList = (MutableObjectList) obj;
        if (mutableObjectList.isEmpty()) {
            PathKt$$ExternalSyntheticBUOutline0.m$1("List is empty.");
            return null;
        }
        int i = mutableObjectList._size - 1;
        Object obj2 = mutableObjectList.get(i);
        mutableObjectList.removeAt(i);
        obj2.getClass();
        if (mutableObjectList.isEmpty()) {
            mutableScatterMap.remove(null);
        }
        if (mutableObjectList._size == 1) {
            mutableScatterMap.set(null, mutableObjectList.first());
        }
        return obj2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x005e A[LOOP:0: B:9:0x001c->B:22:0x005e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0061 A[EDGE_INSN: B:25:0x0061->B:23:0x0061 BREAK  A[LOOP:0: B:9:0x001c->B:22:0x005e], SYNTHETIC] */
    /* JADX INFO: renamed from: values-impl, reason: not valid java name */
    public static final MutableObjectList m392valuesimpl(MutableScatterMap mutableScatterMap) {
        if (mutableScatterMap.isEmpty()) {
            MutableObjectList mutableObjectList = ObjectListKt.EmptyObjectList;
            mutableObjectList.getClass();
            return mutableObjectList;
        }
        MutableObjectList mutableObjectList2 = new MutableObjectList();
        Object[] objArr = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            if (obj instanceof MutableObjectList) {
                                mutableObjectList2.addAll((MutableObjectList) obj);
                            } else {
                                obj.getClass();
                                mutableObjectList2.add(obj);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return mutableObjectList2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof MultiValueMap) {
            return this.map.equals(((MultiValueMap) obj).map);
        }
        return false;
    }

    public final int hashCode() {
        return this.map.hashCode();
    }

    public final String toString() {
        return "MultiValueMap(map=" + this.map + ")";
    }
}
