package com.google.common.collect;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import coil3.util.UtilsKt;
import java.util.Arrays;
import java.util.Objects;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectCountHashMap {
    public transient long[] entries;
    public transient Object[] keys;
    public transient float loadFactor;
    public transient int size;
    public transient int[] table;
    public transient int threshold;
    public transient int[] values;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class MapEntry {
        public final Object key;
        public int lastKnownIndex;

        public MapEntry(int i) {
            this.key = ObjectCountHashMap.this.keys[i];
            this.lastKnownIndex = i;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof MapEntry) {
                MapEntry mapEntry = (MapEntry) obj;
                if (getCount() == mapEntry.getCount() && Objects.equals(this.key, mapEntry.key)) {
                    return true;
                }
            }
            return false;
        }

        public final int getCount() {
            int i = this.lastKnownIndex;
            Object obj = this.key;
            ObjectCountHashMap objectCountHashMap = ObjectCountHashMap.this;
            if (i == -1 || i >= objectCountHashMap.size || !Objects.equals(obj, objectCountHashMap.keys[i])) {
                this.lastKnownIndex = objectCountHashMap.indexOf(obj);
            }
            int i2 = this.lastKnownIndex;
            if (i2 == -1) {
                return 0;
            }
            return objectCountHashMap.values[i2];
        }

        public final int hashCode() {
            Object obj = this.key;
            return getCount() ^ (obj == null ? 0 : obj.hashCode());
        }

        public final String toString() {
            String strValueOf = String.valueOf(this.key);
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    public final void ensureCapacity(int i) {
        if (i > this.entries.length) {
            resizeEntries(i);
        }
        if (i >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    public final int get(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return 0;
        }
        return this.values[iIndexOf];
    }

    public final int indexOf(Object obj) {
        int iSmearedHash = Maps.smearedHash(obj);
        int[] iArr = this.table;
        int i = iArr[(iArr.length - 1) & iSmearedHash];
        while (i != -1) {
            long j = this.entries[i];
            if (((int) (j >>> 32)) == iSmearedHash && Objects.equals(obj, this.keys[i])) {
                return i;
            }
            i = (int) j;
        }
        return -1;
    }

    public final void init(int i) {
        UtilsKt.checkArgument("Initial capacity must be non-negative", i >= 0);
        int iMax = Math.max(i, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax > ((int) (1.0d * ((double) iHighestOneBit))) && (iHighestOneBit = iHighestOneBit << 1) <= 0) {
            iHighestOneBit = 1073741824;
        }
        int[] iArr = new int[iHighestOneBit];
        Arrays.fill(iArr, -1);
        this.table = iArr;
        this.loadFactor = 1.0f;
        this.keys = new Object[i];
        this.values = new int[i];
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        this.entries = jArr;
        this.threshold = Math.max(1, (int) (iHighestOneBit * 1.0f));
    }

    public final void put(int i, Object obj) {
        long j;
        if (i <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "count must be positive but was: "));
            return;
        }
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int iSmearedHash = Maps.smearedHash(obj);
        int[] iArr2 = this.table;
        int length = (iArr2.length - 1) & iSmearedHash;
        int i2 = this.size;
        int i3 = iArr2[length];
        if (i3 == -1) {
            iArr2[length] = i2;
            j = 4294967295L;
        } else {
            while (true) {
                long j2 = jArr[i3];
                j = 4294967295L;
                if (((int) (j2 >>> 32)) == iSmearedHash && Objects.equals(obj, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return;
                } else {
                    int i5 = (int) j2;
                    if (i5 == -1) {
                        jArr[i3] = ((-4294967296L) & j2) | (((long) i2) & 4294967295L);
                        break;
                    }
                    i3 = i5;
                }
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Cannot contain more than Integer.MAX_VALUE elements!");
            return;
        }
        int i6 = i2 + 1;
        int length2 = this.entries.length;
        if (i6 > length2) {
            int iMax = Math.max(1, length2 >>> 1) + length2;
            int i7 = iMax >= 0 ? iMax : Integer.MAX_VALUE;
            if (i7 != length2) {
                resizeEntries(i7);
            }
        }
        this.entries[i2] = (((long) iSmearedHash) << 32) | j;
        this.keys[i2] = obj;
        this.values[i2] = i;
        this.size = i6;
        if (i2 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
    }

    public final void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(jArrCopyOf, length, i, -1L);
        }
        this.entries = jArrCopyOf;
    }

    public final void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.loadFactor)) + 1;
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        long[] jArr = this.entries;
        int i3 = i - 1;
        for (int i4 = 0; i4 < this.size; i4++) {
            int i5 = (int) (jArr[i4] >>> 32);
            int i6 = i5 & i3;
            int i7 = iArr[i6];
            iArr[i6] = i4;
            jArr[i4] = (((long) i5) << 32) | (((long) i7) & 4294967295L);
        }
        this.threshold = i2;
        this.table = iArr;
    }
}
