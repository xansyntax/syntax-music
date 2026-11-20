package androidx.compose.ui.unit;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IntOffset {
    public final long packedValue;

    public /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static long m803copyiSbpLlY$default(int i, int i2, int i3, long j) {
        if ((i3 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i3 & 2) != 0) {
            i2 = (int) (j & 4294967295L);
        }
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m804equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m805minusqkQi6aY(long j, long j2) {
        return (((long) (((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L);
    }

    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m806plusqkQi6aY(long j, long j2) {
        return (((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m807toStringimpl(long j) {
        return IntIntPair$$ExternalSyntheticOutline0.m((int) (j >> 32), "(", ", ", (int) (j & 4294967295L), ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof IntOffset) {
            return this.packedValue == ((IntOffset) obj).packedValue;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.packedValue);
    }

    public final String toString() {
        return m807toStringimpl(this.packedValue);
    }
}
