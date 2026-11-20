package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MutableOrderedScatterSet {
    public int _capacity;
    public int _size;
    public int growthLimit;
    public long[] metadata = ScatterMapKt.EmptyGroup;
    public Object[] elements = ContainerHelpersKt.EMPTY_OBJECTS;
    public long[] nodes = ArraySetKt.EmptyNodes;
    public int head = Integer.MAX_VALUE;
    public int tail = Integer.MAX_VALUE;

    public MutableOrderedScatterSet(int i) {
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Capacity must be a positive value.");
            throw null;
        }
    }

    public final boolean add(Object obj) {
        int i = this._size;
        int iFindAbsoluteInsertIndex = findAbsoluteInsertIndex(obj);
        this.elements[iFindAbsoluteInsertIndex] = obj;
        long[] jArr = this.nodes;
        int i2 = this.head;
        jArr[iFindAbsoluteInsertIndex] = (((long) i2) & 2147483647L) | 4611686016279904256L;
        if (i2 != Integer.MAX_VALUE) {
            jArr[i2] = ((((long) iFindAbsoluteInsertIndex) & 2147483647L) << 31) | (jArr[i2] & (-4611686016279904257L));
        }
        this.head = iFindAbsoluteInsertIndex;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = iFindAbsoluteInsertIndex;
        }
        return this._size != i;
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(jArr, -9187201950435737472L);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        ArraysKt.fill(0, this._capacity, null, this.elements);
        ArraysKt.fill$default(this.nodes, 4611686018427387903L);
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
    }

    public final boolean contains(Object obj) {
        int iNumberOfTrailingZeros;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (((long) i2) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], obj)) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
        return iNumberOfTrailingZeros >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[LOOP:0: B:14:0x001d->B:26:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0059 A[SYNTHETIC] */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MutableOrderedScatterSet)) {
            return false;
        }
        MutableOrderedScatterSet mutableOrderedScatterSet = (MutableOrderedScatterSet) obj;
        if (mutableOrderedScatterSet._size != this._size) {
            return false;
        }
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128 && !mutableOrderedScatterSet.contains(objArr[(i << 3) + i3])) {
                            return false;
                        }
                        j >>= 8;
                    }
                    if (i2 == 8) {
                        if (i != length) {
                            i++;
                        }
                    }
                } else if (i != length) {
                    i++;
                }
            }
        }
        return true;
    }

    public final int findAbsoluteInsertIndex(Object obj) {
        int i;
        long j;
        long j2;
        long j3;
        char c;
        long[] jArr;
        int i2 = -862048943;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i3 = iHashCode ^ (iHashCode << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this._capacity;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr2 = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j4 = ((jArr2[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr2[i9] >>> i10);
            long j5 = i5;
            long j6 = j4 ^ (j5 * 72340172838076673L);
            long j7 = (j6 - 72340172838076673L) & (~j6) & (-9187201950435737472L);
            while (j7 != 0) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j7) >> 3) + i7) & i6;
                int i11 = i2;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
                j7 &= j7 - 1;
                i2 = i11;
            }
            int i12 = i2;
            if ((j4 & ((~j4) << 6) & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i4);
                long j8 = 255;
                if (this.growthLimit != 0 || ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) == 254) {
                    i = 0;
                    j = j5;
                    j2 = 255;
                    j3 = 128;
                } else {
                    int i13 = this._capacity;
                    if (i13 > 8) {
                        c = 31;
                        j3 = 128;
                        if (Long.compareUnsigned(((long) this._size) * 32, ((long) i13) * 25) <= 0) {
                            long[] jArr3 = this.metadata;
                            if (jArr3 == null) {
                                i = 0;
                                j = j5;
                                j2 = 255;
                            } else {
                                int i14 = this._capacity;
                                Object[] objArr = this.elements;
                                long[] jArr4 = this.nodes;
                                long[] jArr5 = new long[i14];
                                Arrays.fill(jArr5, 0, i14, 9223372034707292159L);
                                i = 0;
                                int i15 = (i14 + 7) >> 3;
                                int i16 = 0;
                                while (i16 < i15) {
                                    long j9 = j8;
                                    long j10 = jArr3[i16] & (-9187201950435737472L);
                                    int i17 = i16;
                                    jArr3[i17] = ((~j10) + (j10 >>> 7)) & (-72340172838076674L);
                                    i16 = i17 + 1;
                                    j8 = j9;
                                }
                                j2 = j8;
                                int length = jArr3.length;
                                int i18 = length - 1;
                                int i19 = length - 2;
                                jArr3[i19] = (jArr3[i19] & 72057594037927935L) | (-72057594037927936L);
                                jArr3[i18] = jArr3[0];
                                int i20 = 0;
                                while (i20 != i14) {
                                    int i21 = i20 >> 3;
                                    int i22 = (i20 & 7) << 3;
                                    long j11 = (jArr3[i21] >> i22) & j2;
                                    if (j11 != 128 && j11 == 254) {
                                        Object obj2 = objArr[i20];
                                        int iHashCode2 = (obj2 != null ? obj2.hashCode() : 0) * i12;
                                        int i23 = iHashCode2 ^ (iHashCode2 << 16);
                                        int i24 = i23 >>> 7;
                                        int iFindFirstAvailableSlot2 = findFirstAvailableSlot(i24);
                                        int i25 = i24 & i14;
                                        if (((iFindFirstAvailableSlot2 - i25) & i14) / 8 == ((i20 - i25) & i14) / 8) {
                                            int i26 = i14;
                                            Object[] objArr2 = objArr;
                                            jArr3[i21] = (jArr3[i21] & (~(j2 << i22))) | (((long) (i23 & 127)) << i22);
                                            if (jArr5[i20] == 9223372034707292159L) {
                                                long j12 = i20;
                                                jArr5[i20] = j12 | (j12 << 32);
                                            }
                                            jArr3[jArr3.length - 1] = jArr3[0];
                                            i20++;
                                            i14 = i26;
                                            objArr = objArr2;
                                        } else {
                                            int i27 = i14;
                                            Object[] objArr3 = objArr;
                                            int i28 = iFindFirstAvailableSlot2 >> 3;
                                            long j13 = jArr3[i28];
                                            int i29 = (iFindFirstAvailableSlot2 & 7) << 3;
                                            if (((j13 >> i29) & j2) == 128) {
                                                jArr3[i28] = (j13 & (~(j2 << i29))) | (((long) (i23 & 127)) << i29);
                                                jArr3[i21] = (jArr3[i21] & (~(j2 << i22))) | (128 << i22);
                                                objArr3[iFindFirstAvailableSlot2] = objArr3[i20];
                                                objArr3[i20] = null;
                                                jArr4[iFindFirstAvailableSlot2] = jArr4[i20];
                                                jArr4[i20] = 4611686018427387903L;
                                                int i30 = (int) ((jArr5[i20] >> 32) & 4294967295L);
                                                if (i30 != Integer.MAX_VALUE) {
                                                    jArr5[i30] = ((long) iFindFirstAvailableSlot2) | (jArr5[i30] & (-4294967296L));
                                                    jArr5[i20] = (jArr5[i20] & 4294967295L) | (-4294967296L);
                                                } else {
                                                    jArr5[i20] = 9223372032559808512L | ((long) iFindFirstAvailableSlot2);
                                                }
                                                jArr5[iFindFirstAvailableSlot2] = (((long) i20) << 32) | 2147483647L;
                                            } else {
                                                j5 = j5;
                                                jArr3[i28] = (((long) (i23 & 127)) << i29) | (j13 & (~(j2 << i29)));
                                                Object obj3 = objArr3[iFindFirstAvailableSlot2];
                                                objArr3[iFindFirstAvailableSlot2] = objArr3[i20];
                                                objArr3[i20] = obj3;
                                                long j14 = jArr4[iFindFirstAvailableSlot2];
                                                jArr4[iFindFirstAvailableSlot2] = jArr4[i20];
                                                jArr4[i20] = j14;
                                                int i31 = (int) ((jArr5[i20] >> 32) & 4294967295L);
                                                if (i31 != Integer.MAX_VALUE) {
                                                    long j15 = iFindFirstAvailableSlot2;
                                                    jArr5[i31] = (jArr5[i31] & (-4294967296L)) | j15;
                                                    jArr5[i20] = (jArr5[i20] & 4294967295L) | (j15 << 32);
                                                } else {
                                                    long j16 = iFindFirstAvailableSlot2;
                                                    jArr5[i20] = j16 | (j16 << 32);
                                                    i31 = i20;
                                                }
                                                jArr5[iFindFirstAvailableSlot2] = (((long) i31) << 32) | ((long) i20);
                                                i20--;
                                            }
                                            jArr3[jArr3.length - 1] = jArr3[0];
                                            i20++;
                                            i14 = i27;
                                            objArr = objArr3;
                                            j5 = j5;
                                        }
                                    } else {
                                        i20++;
                                    }
                                }
                                j = j5;
                                this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
                                long[] jArr6 = this.nodes;
                                int length2 = jArr6.length;
                                for (int i32 = 0; i32 < length2; i32++) {
                                    long j17 = jArr6[i32];
                                    int i33 = (int) ((j17 >> 31) & 2147483647L);
                                    int i34 = (int) (j17 & 2147483647L);
                                    jArr6[i32] = (((j17 & (-4611686018427387904L)) | ((long) (i33 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr5[i33] & 4294967295L)))) << 31) | ((long) (i34 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr5[i34] & 4294967295L)));
                                }
                                int i35 = this.head;
                                if (i35 != Integer.MAX_VALUE) {
                                    this.head = (int) (jArr5[i35] & 4294967295L);
                                }
                                int i36 = this.tail;
                                if (i36 != Integer.MAX_VALUE) {
                                    this.tail = (int) (jArr5[i36] & 4294967295L);
                                }
                            }
                        }
                        iFindFirstAvailableSlot = findFirstAvailableSlot(i4);
                    } else {
                        c = 31;
                        j3 = 128;
                    }
                    i = 0;
                    j = j5;
                    j2 = 255;
                    int iNextCapacity = ScatterMapKt.nextCapacity(this._capacity);
                    long[] jArr7 = this.metadata;
                    Object[] objArr4 = this.elements;
                    long[] jArr8 = this.nodes;
                    int i37 = this._capacity;
                    int[] iArr = new int[i37];
                    initializeStorage(iNextCapacity);
                    long[] jArr9 = this.metadata;
                    Object[] objArr5 = this.elements;
                    long[] jArr10 = this.nodes;
                    int i38 = this._capacity;
                    int i39 = 0;
                    while (i39 < i37) {
                        if (((jArr7[i39 >> 3] >> ((i39 & 7) << 3)) & 255) < j3) {
                            Object obj4 = objArr4[i39];
                            int iHashCode3 = (obj4 != null ? obj4.hashCode() : 0) * i12;
                            int i40 = iHashCode3 ^ (iHashCode3 << 16);
                            int iFindFirstAvailableSlot3 = findFirstAvailableSlot(i40 >>> 7);
                            jArr = jArr9;
                            long j18 = i40 & 127;
                            int i41 = iFindFirstAvailableSlot3 >> 3;
                            int i42 = (iFindFirstAvailableSlot3 & 7) << 3;
                            long j19 = (jArr[i41] & (~(255 << i42))) | (j18 << i42);
                            jArr[i41] = j19;
                            jArr[(((iFindFirstAvailableSlot3 - 7) & i38) + (i38 & 7)) >> 3] = j19;
                            objArr5[iFindFirstAvailableSlot3] = obj4;
                            jArr10[iFindFirstAvailableSlot3] = jArr8[i39];
                            iArr[i39] = iFindFirstAvailableSlot3;
                        } else {
                            jArr = jArr9;
                        }
                        i39++;
                        jArr7 = jArr7;
                        jArr9 = jArr;
                    }
                    long[] jArr11 = this.nodes;
                    int length3 = jArr11.length;
                    for (int i43 = 0; i43 < length3; i43++) {
                        long j20 = jArr11[i43];
                        int i44 = (int) ((j20 >> c) & 2147483647L);
                        int i45 = (int) (j20 & 2147483647L);
                        jArr11[i43] = (((j20 & (-4611686018427387904L)) | ((long) (i44 == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[i44]))) << c) | ((long) (i45 == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[i45]));
                    }
                    int i46 = this.head;
                    if (i46 != Integer.MAX_VALUE) {
                        this.head = iArr[i46];
                    }
                    int i47 = this.tail;
                    if (i47 != Integer.MAX_VALUE) {
                        this.tail = iArr[i47];
                    }
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i4);
                }
                this._size++;
                int i48 = this.growthLimit;
                long[] jArr12 = this.metadata;
                int i49 = iFindFirstAvailableSlot >> 3;
                long j21 = jArr12[i49];
                int i50 = (iFindFirstAvailableSlot & 7) << 3;
                if (((j21 >> i50) & j2) == j3) {
                    i = 1;
                }
                this.growthLimit = i48 - i;
                int i51 = this._capacity;
                long j22 = (j21 & (~(j2 << i50))) | (j << i50);
                jArr12[i49] = j22;
                jArr12[(((iFindFirstAvailableSlot - 7) & i51) + (i51 & 7)) >> 3] = j22;
                return iFindFirstAvailableSlot;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i2 = i12;
        }
    }

    public final int findFirstAvailableSlot(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final int hashCode() {
        int iHashCode = (this._capacity * 31) + this._size;
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            if (!Intrinsics.areEqual(obj, this)) {
                                iHashCode += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return iHashCode;
                    }
                }
                if (i != length) {
                    i++;
                }
            }
        }
        return iHashCode;
    }

    public final void initializeStorage(int i) {
        long[] jArr;
        long[] jArr2;
        int iMax = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = iMax;
        if (iMax == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            int i2 = ((iMax + 15) & (-8)) >> 3;
            long[] jArr3 = new long[i2];
            Arrays.fill(jArr3, 0, i2, -9187201950435737472L);
            jArr = jArr3;
        }
        this.metadata = jArr;
        int i3 = iMax >> 3;
        long j = 255 << ((iMax & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j)) | j;
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - this._size;
        this.elements = iMax == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[iMax];
        if (iMax == 0) {
            jArr2 = ArraySetKt.EmptyNodes;
        } else {
            long[] jArr4 = new long[iMax];
            Arrays.fill(jArr4, 0, iMax, 4611686018427387903L);
            jArr2 = jArr4;
        }
        this.nodes = jArr2;
    }

    public final boolean remove(Object obj) {
        int iNumberOfTrailingZeros;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (((long) i2) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], obj)) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
        boolean z = iNumberOfTrailingZeros >= 0;
        if (z) {
            removeElementAt(iNumberOfTrailingZeros);
        }
        return z;
    }

    public final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.elements[i] = null;
        long[] jArr2 = this.nodes;
        long j2 = jArr2[i];
        int i5 = (int) ((j2 >> 31) & 2147483647L);
        int i6 = (int) (j2 & 2147483647L);
        if (i5 != Integer.MAX_VALUE) {
            jArr2[i5] = (jArr2[i5] & (-2147483648L)) | (((long) i6) & 2147483647L);
        } else {
            this.head = i6;
        }
        if (i6 != Integer.MAX_VALUE) {
            jArr2[i6] = ((((long) i5) & 2147483647L) << 31) | (jArr2[i6] & (-4611686016279904257L));
        } else {
            this.tail = i5;
        }
        jArr2[i] = 4611686018427387903L;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0051 A[LOOP:0: B:5:0x0012->B:17:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:24:0x0054 A[EDGE_INSN: B:24:0x0054->B:18:0x0054 BREAK  A[LOOP:0: B:5:0x0012->B:17:0x0051], SYNTHETIC] */
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Object[] objArr = this.elements;
        int i = this._size;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i2 != length) {
                        break;
                        break;
                    }
                    i2++;
                } else {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            if (!CollectionsKt.contains(collection, objArr[i5])) {
                                removeElementAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i2 != length) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return i != this._size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Object[] objArr = this.elements;
        long[] jArr = this.nodes;
        int i = this.tail;
        int i2 = 0;
        while (i != Integer.MAX_VALUE) {
            int i3 = (int) ((jArr[i] >> 31) & 2147483647L);
            Object obj = objArr[i];
            if (i2 == -1) {
                sb.append((CharSequence) "...");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append((CharSequence) ", ");
            }
            sb.append((CharSequence) (obj == this ? "(this)" : String.valueOf(obj)));
            i2++;
            i = i3;
        }
        sb.append((CharSequence) "]");
        return sb.toString();
    }
}
